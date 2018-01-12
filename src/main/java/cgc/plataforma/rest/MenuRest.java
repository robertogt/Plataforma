/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgc.plataforma.rest;

import cgc.plataforma.model.zeus.ZeusBitacora;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import cgc.plataforma.model.zeus.ZeusMenu;
import cgc.plataforma.pojo.JsonMenu;
import cgc.plataforma.pojo.ResultsLaboralRue;
import cgc.plataforma.pojo.ResultsMenu;
import cgc.plataforma.pojo.ResultsMenuIcono;
import cgc.plataforma.service.RepoDao;
import cgc.plataforma.service.ZeusService;
import cgc.plataforma.util.Constants;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.StringTokenizer;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ejmorales
 */

@Stateless
@Path("/menu")
public class MenuRest {//extends ZeusService{
    
    /*@PersistenceContext(unitName = "zeusPersist")
    private EntityManager em;*/
    @EJB
    private ZeusService zeusService;
    
    /*@EJB
    private RepoDao repoDao;*/
    
    /*public MenuRest() {
        super();
    }*/

    @POST
    @Path("/consultMenu")
    @RolesAllowed("autenticado")
    @Produces(MediaType.APPLICATION_JSON)
    public String menuConsultado(@FormParam("menu") Integer menu,
            @Context SecurityContext sc,
            @Context HttpServletRequest req){
        String resp = "{}";
        String ip = null;
        try {
            if(menu != null){
                String xForwardedForHeader = req.getHeader("X-Forwarded-For");
                if (xForwardedForHeader == null) {
                    //System.out.println("xForwarded Null: "+ req.getRemoteAddr());
                    ip = req.getRemoteAddr();
                } else {
                    ip = new StringTokenizer(xForwardedForHeader, ",").nextToken().trim();
                    //System.out.println(new StringTokenizer(xForwardedForHeader, ",").nextToken().trim());
                }
                
                ZeusBitacora bitacora = new ZeusBitacora();
                ZeusMenu zeusMenu = zeusService.findMenuByMenu(menu);
                bitacora.setMenu(zeusMenu);
                bitacora.setMaquina(ip);
                bitacora.setFecha(new Date());
                bitacora.setUsuario(sc.getUserPrincipal().getName().toUpperCase());
                bitacora.setPlataformaWeb("P");
                zeusService.createBitacora(bitacora);
            }
        } catch (Exception e) {
            resp = "{\"code\": 4, \"message\":\""+e.getMessage()+"\"}";
        }
       return resp;     
    }
    
    /*
    @GET
    @RolesAllowed("autenticado")    
    @Produces(MediaType.APPLICATION_JSON)
    public List<ZeusMenu> zeusMenu(@Context SecurityContext sc){
        List<ZeusMenu> result = new ArrayList<ZeusMenu>();
        try{
            TypedQuery<ZeusMenu> query = em.createNamedQuery("ZeusMenu.findByUsuario",ZeusMenu.class);
            query.setParameter("usuario", "zeus");

            result = query.getResultList();            
         
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return result;
    }*/
    
    @GET
    @Path("/jsonMenuPersonal")
    @RolesAllowed("autenticado")
    @Produces(MediaType.APPLICATION_JSON)
    public List<JsonMenu> constructMenuPersonalJson(@Context SecurityContext ctx){
        List<ZeusMenu> result = new ArrayList<ZeusMenu>();          
        List<JsonMenu> jsonResponse = new ArrayList<>();
        try{
           // ResultsLaboralRue laboral = repoDao.getRenglonByUsuario(ctx.getUserPrincipal().getName());
            
            /*Se Agrego Esta linea para evitar que vean el menu los contratistas*/
            //if(laboral.getRenglon() == 1){
                result = zeusService.getListByUser(ctx.getUserPrincipal().getName(),Constants.PERSONAL); 
            //}
            
            
            for(ZeusMenu menu: result){
               //ResultsMenuIcono icono = new ResultsMenuIcono();
                //icono = super.getIconoByMenu(menu.getMenu());
                String imgBytes = null;
                if(menu.getIcono() != null){
                      imgBytes = Base64.getEncoder().encodeToString(menu.getIcono());
                }
                
                jsonResponse.add(new JsonMenu(menu.getMenu().intValue(),
                                              menu.getEtiqueta(),
                                              "",
                                              "",
                                               0,                                              
                                              Constants.LEFT_ICON_SHARE,
                                              "",
                                              Constants.RIGHT_ICON,
                                              "",
                                              Constants.TYPE_TREEVIEW,
                                              false,
                                              imgBytes,
                                              this.constructJson(menu.getMenu().intValue(), ctx.getUserPrincipal().getName())));
      
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return jsonResponse;
    }
    
    
    @GET
    @Path("/jsonMenu")
    @RolesAllowed("autenticado")
    @Produces(MediaType.APPLICATION_JSON)
    public List<JsonMenu> constructMenuJson(@Context SecurityContext ctx){
        List<ZeusMenu> result = new ArrayList<ZeusMenu>();          
        List<JsonMenu> jsonResponse = new ArrayList<>();
        try{
            result = zeusService.getListByUser(ctx.getUserPrincipal().getName(),Constants.INDIVIDUAL); 
            
            for(ZeusMenu menu: result){
               //ResultsMenuIcono icono = new ResultsMenuIcono();
                //icono = super.getIconoByMenu(menu.getMenu());
                String imgBytes = null;
                if(menu.getIcono() != null){
                      imgBytes = Base64.getEncoder().encodeToString(menu.getIcono());
                }
                //System.out.println(menu.getMenu());
                /*Se Agrego Esta linea para evitar que vean el menu en lo que se migran los proyectos a weblogic*/
                if(menu.getPlataformaWeb().equalsIgnoreCase("P")){
                jsonResponse.add(new JsonMenu(menu.getMenu().intValue(),
                                              menu.getEtiqueta(),
                                              "",
                                              "",
                                               0,                                              
                                              Constants.LEFT_ICON_SHARE,
                                              "",
                                              Constants.RIGHT_ICON,
                                              "",
                                              Constants.TYPE_TREEVIEW,
                                              false,
                                              imgBytes,
                                              this.constructJson(menu.getMenu().intValue(), ctx.getUserPrincipal().getName())));
      
            }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return jsonResponse;
    }
    
    public ArrayList<JsonMenu> constructJson(Integer menuPadre, String usuario){
        ArrayList<JsonMenu> resultado = new ArrayList<JsonMenu>();
                List<ResultsMenu> tempO = zeusService.getListByUsuarioByMenuPadre(usuario, menuPadre);
         if(tempO != null && !tempO.isEmpty()){
                for(ResultsMenu resMenu: tempO){
                        if(resMenu.getHoja().intValue() == 1){   
                           resultado.add(new JsonMenu(resMenu.getMenu().intValue(),
                                                    resMenu.getEtiqueta(),
                                                    resMenu.getPath(),
                                                    resMenu.getNombreFisico(),
                                                    resMenu.getHoja().intValue(),
                                                    Constants.LEFT_ICON_CIRCLE,
                                                    null,
                                                    null,
                                                    null,
                                                    null,
                                                    false,
                                                    "N",
                                                    new ArrayList<JsonMenu>()));
                        }else{
                           resultado.add(new JsonMenu(resMenu.getMenu().intValue(),
                                         resMenu.getEtiqueta(),
                                         "",
                                         "",
                                         resMenu.getHoja().intValue(),                                         
                                         Constants.LEFT_ICON_CIRCLE,
                                         "",
                                         Constants.RIGHT_ICON,
                                         "",
                                         null,
                                         false,
                                         "N",
                                         this.constructJson(resMenu.getMenu().intValue(), usuario)));
                        }   
                    
                }
                
         }
         
         return resultado;
    }
    
   
    
   /*  @Override
    protected EntityManager getEntityManager() {
        return em;
    }*/
    
}
