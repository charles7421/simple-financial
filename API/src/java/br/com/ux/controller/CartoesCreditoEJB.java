package br.com.ux.controller;

import br.com.ux.model.CartoesCredito;
import javax.ejb.Stateless;

/**
 *
 * @author charles
 */
@Stateless
public class CartoesCreditoEJB extends FacadeEJB<CartoesCredito>{
    
    
    public CartoesCreditoEJB() {
        super(CartoesCredito.class);
    }
  
}
