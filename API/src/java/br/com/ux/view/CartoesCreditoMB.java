package br.com.ux.view;

import br.com.ux.controller.CartoesCreditoEJB;
import br.com.ux.model.CartoesCredito;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author charles
 */
@ManagedBean
@ViewScoped
public final class CartoesCreditoMB {

    @EJB
    CartoesCreditoEJB ccEJB;
    CartoesCredito cartoesCredito;

    public CartoesCreditoMB() {
        novoRegistro();
    }
    
    // Método para nova instância do objeto corrente da classe.
    public void novoRegistro() {
        cartoesCredito = new CartoesCredito();
    }
    
    // Método para salvar o registro. Se o registro já foi salvo, então aciona o método para atualizar.    
    public void Salvar(CartoesCredito cartaoCredito) {
        if (cartaoCredito.getIdCartaoCredito() == null) {
            try {
                ccEJB.Salvar(cartaoCredito);
                System.out.println("Salvo com sucesso.");
            } catch (Exception e) {
                System.out.println("Erro ocorrido: " + e);
            }
        } else {            
            try {
                ccEJB.Atualizar(cartaoCredito);
            } catch (Exception e) {
                System.out.println("Erro ocorrido: " + e);
            }
        }
    }
    
    // Método para excluir o registro.    
    public void excluir() {
        try {
            ccEJB.Excluir(cartoesCredito, cartoesCredito.getIdCartaoCredito());
            System.out.println("Excluido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ocorrido é: " + e);
        }
    }
    
    // Método para listar todos os registros deste objeto.     
    public List<CartoesCredito> listarCartoesCreditos() {
        return ccEJB.ListarTodos();
    }

    public CartoesCredito getCartoesCredito() {
        return cartoesCredito;
    }

    public void setCartoesCredito(CartoesCredito cartoesCredito) {
        this.cartoesCredito = cartoesCredito;
    }

}
