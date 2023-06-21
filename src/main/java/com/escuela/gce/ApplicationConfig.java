/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escuela.gce;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Desarrollador3
 */
@javax.ws.rs.ApplicationPath("escuela")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.escuela.gce.rest.controller.AsistenciaRestController.class);
        resources.add(com.escuela.gce.rest.controller.ConcursosRestController.class);
        resources.add(com.escuela.gce.rest.controller.EventosRestController.class);
        resources.add(com.escuela.gce.rest.controller.InscritosRestController.class);
        resources.add(com.escuela.gce.rest.controller.PersonaActivaRestController.class);
        resources.add(com.escuela.gce.rest.controller.PublicosRestController.class);
    }
    
}
