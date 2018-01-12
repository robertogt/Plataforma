/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgc.plataforma.rest;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author ejmorales
 */
@ApplicationPath("restresources")
public class ApplicationConfig extends Application{
    
      @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(cgc.plataforma.rest.CorsFilter.class);
        resources.add(cgc.plataforma.rest.InfoREST.class);
        resources.add(cgc.plataforma.rest.MenuRest.class);
    }
}
