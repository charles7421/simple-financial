/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ux;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author charles
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        // following code can be used to customize Jersey 1.x JSON provider:
        try {
            Class jacksonProvider = Class.forName("org.codehaus.jackson.jaxrs.JacksonJsonProvider");
            resources.add(jacksonProvider);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
        resources.add(br.com.ux.service.CartaoCreditoFacadeREST.class);
        resources.add(br.com.ux.service.CategoriaFacadeREST.class);
        resources.add(br.com.ux.service.ClienteFornecedorFacadeREST.class);
        resources.add(br.com.ux.service.LancamentoFinanceiroFacadeREST.class);
        resources.add(br.com.ux.service.SubCategoriaFacadeREST.class);
        resources.add(br.com.ux.service.TipoDocumentoFacadeREST.class);
        resources.add(br.com.ux.service.UsuarioFacadeREST.class);
    }
    
}
