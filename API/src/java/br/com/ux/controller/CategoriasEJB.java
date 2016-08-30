package br.com.ux.controller;

import br.com.ux.model.Categorias;
import javax.ejb.Stateless;

/**
 *
 * @author charles
 */
@Stateless
public class CategoriasEJB extends FacadeEJB<Categorias>{

    public CategoriasEJB() {
        super(Categorias.class);
    }

   
}
