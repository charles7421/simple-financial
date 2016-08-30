package br.com.ux.view;

import br.com.ux.controller.ClientesFornecedoresEJB;
import br.com.ux.model.ClientesFornecedores;
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
public final class ClientesFornecedoresMB {

    @EJB
    ClientesFornecedoresEJB cfEJB;
    ClientesFornecedores clientesFornecedores;
    
    public ClientesFornecedoresMB() {
        novoRegistro();
    }
    
    // Método para nova instância do objeto corrente da classe.
    public void novoRegistro() {
        clientesFornecedores = new ClientesFornecedores();
    }

    // Método para salvar o registro. Se o registro já foi salvo, então aciona o método para atualizar.
    public void Salvar(ClientesFornecedores cf) {
        if (cf.getIdClienteFornecedor() == null) {
            try {
                cfEJB.Salvar(cf);
                System.out.println("Salvo com sucesso.");
            } catch (Exception e) {
                System.out.println("Erro ocorrido: " + e);
            }
        } else {            
            try {
                cfEJB.Atualizar(cf);
                System.out.println("Editado com sucesso.");
            } catch (Exception e) {
                System.out.println("Erro ocorrido: " + e);
            }
        }
    }
    
    // Método para excluir o registro. 
    public void excluir() {
        try {
            cfEJB.Excluir(clientesFornecedores, clientesFornecedores.getIdClienteFornecedor());
            System.out.println("Excluido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ocorrido é: " + e);
        }
    }
    
    // Método para listar todos os registros deste objeto.        
    public List<ClientesFornecedores> listarClientesFornecedores() {
        return cfEJB.ListarTodos();
    }

    public ClientesFornecedores getClientesFornecedores() {
        return clientesFornecedores;
    }

    public void setClientesFornecedores(ClientesFornecedores clientesFornecedores) {
        this.clientesFornecedores = clientesFornecedores;
    }
    
    
}
