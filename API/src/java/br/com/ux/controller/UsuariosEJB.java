package br.com.ux.controller;

import br.com.ux.model.Usuarios;
import javax.ejb.Stateless;

/**
 *
 * @author charles
 */
@Stateless
public class UsuariosEJB extends FacadeEJB<Usuarios>{

    public UsuariosEJB() {
        super(Usuarios.class);
    }

    
}
