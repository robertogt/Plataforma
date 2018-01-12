/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgc.plataforma.service;

import cgc.plataforma.model.zeus.ZeusBitacora;
import cgc.plataforma.model.zeus.ZeusMenu;
import cgc.plataforma.pojo.ResultsLaboralRue;
import cgc.plataforma.pojo.ResultsMenu;
import cgc.plataforma.pojo.ResultsMenuIcono;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ejmorales
 */
@Stateless
@LocalBean
//public  abstract class ZeusService {
public class ZeusService {
    
    //protected abstract EntityManager getEntityManager();
    @PersistenceContext(unitName = "zeusPersist")
    private EntityManager em;

    public ZeusService() {
    }
    
    public void createBitacora(ZeusBitacora bitacora){
        try {
            em.persist(bitacora);
        } catch (Exception e) {
            System.out.println("createBitacora: "+e.getMessage());
        }
    }
    
    public ZeusMenu findMenuByMenu(Integer menu) throws Exception{
        try {
            TypedQuery<ZeusMenu> query = em
                    .createNamedQuery("ZeusMenu.findByMenu",ZeusMenu.class);
            query.setParameter("menu", menu);
            return query.getSingleResult();
        } catch (Exception e) {
            System.out.println("findMenuByMenu: "+e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
    
    public List<ZeusMenu> getListByUser(String username, String tipo){
        try {
            TypedQuery<ZeusMenu> query = em
                    .createNamedQuery("ZeusMenu.findByUsuario",ZeusMenu.class);
            query.setParameter("usuario", username);
            query.setParameter("tipo", tipo);

            return query.getResultList(); 
        } catch (Exception e) {
            System.out.println("getListByUser: "+e.getMessage());
            return new ArrayList<ZeusMenu>();
        }
    }
    
    public List<ResultsMenu> getListByUsuarioByMenuPadre(String usuario, Integer menuPadre){
        try {
            TypedQuery<ResultsMenu> query = em
                    .createNamedQuery("ZeusMenu.NativeQueryMenu",ResultsMenu.class);
                query.setParameter(1, usuario);
                query.setParameter(2, menuPadre);
                
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("getListByUsuarioByMenuPadre: "+e.getMessage());
            return new ArrayList<ResultsMenu>();
        }
    }
    
    public ResultsMenuIcono getIconoByMenu(BigDecimal menu){
        try {
            TypedQuery<ResultsMenuIcono> query = em
                    .createNamedQuery("ZeusMenu.NativeQueryIcono", ResultsMenuIcono.class);
            query.setParameter(1, menu);
            
            return query.getSingleResult();
        }catch (NoResultException | NonUniqueResultException nr) {
            return null;
        } catch (Exception e) {
            System.out.println("getIconoByMenu: "+e.getMessage());
            return null;
        }
    }
    
    
}
