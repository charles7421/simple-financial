package br.com.ux.controller;

import br.com.ux.model.SubCategorias;
import javax.ejb.Stateless;

/**
 *
 * @author charles
 */
@Stateless
public class SubCategoriasEJB extends FacadeEJB<SubCategorias>{

    public SubCategoriasEJB() {
        super(SubCategorias.class);
    }

    
}
