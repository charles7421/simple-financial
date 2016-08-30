package br.com.ux.view;

import br.com.ux.controller.CategoriasEJB;
import br.com.ux.model.Categorias;
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
public final class CategoriasMB {

    @EJB
    CategoriasEJB cEJB;
    public Categorias categorias;
    
    public CategoriasMB() {
        novoRegistro();
    }
    
    // Método para nova instância do objeto corrente da classe.
    public void novoRegistro() {
        categorias = new Categorias();
    }

    // Método para salvar o registro. Se o registro já foi salvo, então aciona o método para atualizar.
    public void Salvar(Categorias categorias) {
        if (categorias.getIdCategoria() == null) {
            try {
                cEJB.Salvar(categorias);
                System.out.println("Salvo com sucesso.");
            } catch (Exception e) {
                System.out.println("Erro ocorrido: " + e);
            }
        } else {            
            try {
                cEJB.Atualizar(categorias);
            } catch (Exception e) {
                System.out.println("Erro ocorrido: " + e);
            }
        }
    }
    
    // Método para excluir o registro.    
    public void excluir() {
        try {
            cEJB.Excluir(categorias, categorias.getIdCategoria());
            System.out.println("Excluido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ocorrido é: " + e);
        }
    }
    
    // Método para listar todos os registros deste objeto.     
    public List<Categorias> listarCategorias() {
        return cEJB.ListarTodos();
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }
    
    
    
    
    
}
