/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgc.plataforma.rest;

import cgc.plataforma.pojo.InfoUsuario;
import cgc.plataforma.pojo.ResultsImg;
import cgc.plataforma.pojo.ResultsUser;
import cgc.plataforma.service.InfoService;
import java.util.Base64;
import java.util.Date;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author ejmorales
 */
@Stateless
@Path("/info")
public class InfoREST extends InfoService{
    
    @PersistenceContext(unitName = "ruePersist")
    private EntityManager em;

    public InfoREST() {
        super();
    }
    
    @GET
    @Path("/username")
    @RolesAllowed("autenticado")
    @Produces(MediaType.APPLICATION_JSON)
    public InfoUsuario getUsername(@Context SecurityContext sc){
      /*  InfoUsuario info = new InfoUsuario(sc.getUserPrincipal().getName(),
                "N/A", null, "N/A", new Date(System.currentTimeMillis()).toString());
        return info;*/
      InfoUsuario info = new InfoUsuario();
      try{
                
        ResultsUser user = super.findEmployeInfoByUser(sc.getUserPrincipal().getName());
        
        if(user != null){            
            ResultsImg img = super.findImageEmployee(user.getRue().longValue());
            
            String imgBytes = null;
            if(img != null){
                  imgBytes = Base64.getEncoder().encodeToString(img.getArchivoImg());
            }
                
            info = new InfoUsuario(sc.getUserPrincipal().getName(),
                                user.getNombre(),
                                imgBytes,
                                user.getPuestoFuncional(),
                                user.getFechaActivo());
        }else{
            info = new InfoUsuario(sc.getUserPrincipal().getName(),
                                   "N/A",
                                   null,
                                   "N/A",
                                   "N/A");
        }
        
        
      }catch(Exception e){
          e.printStackTrace();
      }
           
      return info;
        //return "{\"username\":\""+sc.getUserPrincipal().getName()+"\"}";
    }
    
     @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
