package br.com.ux.controller;

import br.com.ux.model.ClientesFornecedores;
import javax.ejb.Stateless;

/**
 *
 * @author charles
 */
@Stateless
public class ClientesFornecedoresEJB extends FacadeEJB<ClientesFornecedores>{

    public ClientesFornecedoresEJB() {
        super(ClientesFornecedores.class);
    }

    
}
