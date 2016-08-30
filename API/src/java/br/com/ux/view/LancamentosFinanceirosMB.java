package br.com.ux.view;

import br.com.ux.controller.LancamentosFinanceirosEJB;
import br.com.ux.model.LancamentosFinanceiros;
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
public final class LancamentosFinanceirosMB {

    @EJB
    LancamentosFinanceirosEJB lfEJB;
    LancamentosFinanceiros lancamentosFinanceiros;
        
    
    public LancamentosFinanceirosMB() {
        novoRegistro();
    }
    
    
    // Método para nova instância do objeto corrente da classe.
    public void novoRegistro() {
        lancamentosFinanceiros = new LancamentosFinanceiros();
    }
    
    // Método para salvar o registro. Se o registro já foi salvo, então aciona o método para atualizar.
    public void Salvar(LancamentosFinanceiros lf) {
        if (lf.getIdLancamentoFinanceiro() == null) {
            try {
                lfEJB.Salvar(lf);
                System.out.println("Salvo com sucesso.");
            } catch (Exception e) {
                System.out.println("Erro ocorrido: " + e);
            }
        } else {            
            try {
                lfEJB.Atualizar(lf);
                System.out.println("Editado com sucesso.");
            } catch (Exception e) {
                System.out.println("Erro ocorrido: " + e);
            }
        }
    }
    
    // Método para excluir o registro. 
    public void excluir() {
        try {
            lfEJB.Excluir(lancamentosFinanceiros, lancamentosFinanceiros.getIdLancamentoFinanceiro());
            System.out.println("Excluido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ocorrido é: " + e);
        }
    }
    
    // Método para listar todos os registros deste objeto.    
    public List<LancamentosFinanceiros> listarLancamentosFinanceiros() {
        return lfEJB.ListarTodos();
    }

    public LancamentosFinanceiros getLancamentosFinanceiros() {
        return lancamentosFinanceiros;
    }

    public void setLancamentosFinanceiros(LancamentosFinanceiros lancamentosFinanceiros) {
        this.lancamentosFinanceiros = lancamentosFinanceiros;
    }
    
    
    
}
