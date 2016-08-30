package br.com.ux.view;

import br.com.ux.controller.TiposDocumentosEJB;
import br.com.ux.model.TiposDocumentos;
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
public class TiposDocumentosMB {

    @EJB
    TiposDocumentosEJB tdEJB;
    TiposDocumentos tiposDocumentos;
    
    public TiposDocumentosMB() {
        novoRegistro();
    }
    
    // Método para nova instância do objeto corrente da classe.
    public void novoRegistro() {
        tiposDocumentos = new TiposDocumentos();
    }
    
    // Método para salvar o registro. Se o registro já foi salvo, então aciona o método para atualizar.
    public void Salvar(TiposDocumentos td) {
        if (td.getIdTipoDocumento() == null) {
            try {
                tdEJB.Salvar(td);
                System.out.println("Salvo com sucesso.");
            } catch (Exception e) {
                System.out.println("Erro ocorrido: " + e);
            }
        } else {            
            try {
                tdEJB.Atualizar(td);
                System.out.println("Editado com sucesso.");
            } catch (Exception e) {
                System.out.println("Erro ocorrido: " + e);
            }
        }
    }
    
    // Método para excluir o registro. 
    public void excluir() {
        try {
            tdEJB.Excluir(tiposDocumentos, tiposDocumentos.getIdTipoDocumento());
            System.out.println("Excluido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ocorrido é: " + e);
        }
    }
    
    // Método para listar todos os registros deste objeto.    
    public List<TiposDocumentos> listarSubCategorias() {
        return tdEJB.ListarTodos();
    }

    public TiposDocumentos getTiposDocumentos() {
        return tiposDocumentos;
    }

    public void setTiposDocumentos(TiposDocumentos tiposDocumentos) {
        this.tiposDocumentos = tiposDocumentos;
    }
    
    
    
}
