package br.com.ux.controller;

import br.com.ux.model.TiposDocumentos;
import javax.ejb.Stateless;

/**
 *
 * @author charles
 */
@Stateless
public class TiposDocumentosEJB extends FacadeEJB<TiposDocumentos>{

    public TiposDocumentosEJB() {
        super(TiposDocumentos.class);
    }

    
}
