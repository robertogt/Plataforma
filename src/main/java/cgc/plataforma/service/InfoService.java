/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgc.plataforma.service;

import cgc.plataforma.pojo.ResultsImg;
import cgc.plataforma.pojo.ResultsUser;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author ejmorales
 */
public abstract class InfoService {
    
     protected abstract EntityManager getEntityManager();

    public InfoService() {
    }
    
     public ResultsUser findEmployeInfoByUser(String username){
         try {
            TypedQuery<ResultsUser> query = getEntityManager().createNamedQuery("RrhhRue.NativeQueryUsuario",ResultsUser.class);
            query.setParameter(1, username);
            
            return query.getSingleResult();
         }catch(NoResultException | NonUniqueResultException nr) {
             return null;
         }catch (Exception e) {
             System.out.println("findEmployeInfoByUser: "+e.getMessage());
             return null;
         }
     }
     
     public ResultsImg findImageEmployee(Long idRue){
         try {
            TypedQuery<ResultsImg> queryImg = getEntityManager().createNamedQuery("RrhhRue.NativeQueryImg",ResultsImg.class);
            queryImg.setParameter(1, idRue);
            queryImg.setMaxResults(1);
            return queryImg.getSingleResult();
         }catch(NoResultException | NonUniqueResultException nr) {
             return null;
         }catch (Exception e) {
             System.out.println("findImageEmployee: "+e.getMessage());
             return null;
         }
     }
}
