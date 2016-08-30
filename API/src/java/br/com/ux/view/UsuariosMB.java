package br.com.ux.view;

import br.com.ux.controller.UsuariosEJB;
import br.com.ux.model.Usuarios;
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
public class UsuariosMB {

    @EJB
    UsuariosEJB uEJB;
    Usuarios usuarios;
    
    public UsuariosMB() {
        novoRegistro();
    }
    
    // Método para nova instância do objeto corrente da classe.
    public void novoRegistro() {
        usuarios = new Usuarios();
    }
    
    // Método para salvar o registro. Se o registro já foi salvo, então aciona o método para atualizar.
    public void Salvar(Usuarios u) {
        if (u.getIdUsuario() == null) {
            try {
                uEJB.Salvar(u);
                System.out.println("Salvo com sucesso.");
            } catch (Exception e) {
                System.out.println("Erro ocorrido: " + e);
            }
        } else {            
            try {
                uEJB.Atualizar(u);
                System.out.println("Editado com sucesso.");
            } catch (Exception e) {
                System.out.println("Erro ocorrido: " + e);
            }
        }
    }
    
    // Método para excluir o registro. 
    public void excluir() {
        try {
            uEJB.Excluir(usuarios, usuarios.getIdUsuario());
            System.out.println("Excluido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ocorrido é: " + e);
        }
    }
    
    // Método para listar todos os registros deste objeto.    
    public List<Usuarios> listarUsuarios() {
        return uEJB.ListarTodos();
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
}
