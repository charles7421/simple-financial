package br.com.ux.view;

import br.com.ux.controller.SubCategoriasEJB;
import br.com.ux.model.SubCategorias;
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
public final class SubCategoriasMB {

    @EJB
    SubCategoriasEJB scEJB;
    SubCategorias subCategorias;
    
    
    public SubCategoriasMB() {
        novoRegistro();
    }
    
    // Método para nova instância do objeto corrente da classe.
    public void novoRegistro() {
        subCategorias = new SubCategorias();
    }
    
    // Método para salvar o registro. Se o registro já foi salvo, então aciona o método para atualizar.
    public void Salvar(SubCategorias sc) {
        if (sc.getIdSubCategoria() == null) {
            try {
                scEJB.Salvar(sc);
                System.out.println("Salvo com sucesso.");
            } catch (Exception e) {
                System.out.println("Erro ocorrido: " + e);
            }
        } else {            
            try {
                scEJB.Atualizar(sc);
                System.out.println("Editado com sucesso.");
            } catch (Exception e) {
                System.out.println("Erro ocorrido: " + e);
            }
        }
    }
    
    // Método para excluir o registro. 
    public void excluir() {
        try {
            scEJB.Excluir(subCategorias, subCategorias.getIdSubCategoria());
            System.out.println("Excluido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ocorrido é: " + e);
        }
    }
    
    // Método para listar todos os registros deste objeto.    
    public List<SubCategorias> listarSubCategorias() {
        return scEJB.ListarTodos();
    }

    public SubCategorias getSubCategorias() {
        return subCategorias;
    }

    public void setSubCategorias(SubCategorias subCategorias) {
        this.subCategorias = subCategorias;
    }
    
    
    
}
