package br.com.ux.controller;

import br.com.ux.model.LancamentosFinanceiros;
import javax.ejb.Stateless;

/**
 *
 * @author charles
 */
@Stateless
public class LancamentosFinanceirosEJB extends FacadeEJB<LancamentosFinanceiros>{

    public LancamentosFinanceirosEJB() {
        super(LancamentosFinanceiros.class);
    }

    
}
