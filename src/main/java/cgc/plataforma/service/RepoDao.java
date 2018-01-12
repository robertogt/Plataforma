/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgc.plataforma.service;

import cgc.plataforma.pojo.ResultsLaboralRue;
import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ejmorales
 */
@Stateless
@LocalBean
public class RepoDao implements Serializable{
    
    @PersistenceContext(unitName = "ruePersist")
    private EntityManager emRue;
    
    
     public ResultsLaboralRue getRenglonByUsuario(String usuario){
        try {
            TypedQuery<ResultsLaboralRue> query = emRue
                    .createNamedQuery("RrhhRue.NativeQueryRueLaboral", ResultsLaboralRue.class);
            query.setParameter(1, usuario);
            return query.getSingleResult();
        } catch (Exception e) {
            System.out.println("getRenglonByUsuario: "+e.getMessage());
            return null;
        }
    }
}
