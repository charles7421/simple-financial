/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ux;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author charles
 */
@Entity
@Table(name = "cliente_fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteFornecedor.findAll", query = "SELECT c FROM ClienteFornecedor c"),
    @NamedQuery(name = "ClienteFornecedor.findByIdClienteFornecedor", query = "SELECT c FROM ClienteFornecedor c WHERE c.idClienteFornecedor = :idClienteFornecedor"),
    @NamedQuery(name = "ClienteFornecedor.findByTipo", query = "SELECT c FROM ClienteFornecedor c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "ClienteFornecedor.findByNomeFantasia", query = "SELECT c FROM ClienteFornecedor c WHERE c.nomeFantasia = :nomeFantasia"),
    @NamedQuery(name = "ClienteFornecedor.findByRazaoSocial", query = "SELECT c FROM ClienteFornecedor c WHERE c.razaoSocial = :razaoSocial"),
    @NamedQuery(name = "ClienteFornecedor.findByCpf", query = "SELECT c FROM ClienteFornecedor c WHERE c.cpf = :cpf"),
    @NamedQuery(name = "ClienteFornecedor.findByCnpj", query = "SELECT c FROM ClienteFornecedor c WHERE c.cnpj = :cnpj"),
    @NamedQuery(name = "ClienteFornecedor.findByAtividadePrincipal", query = "SELECT c FROM ClienteFornecedor c WHERE c.atividadePrincipal = :atividadePrincipal"),
    @NamedQuery(name = "ClienteFornecedor.findByAtivo", query = "SELECT c FROM ClienteFornecedor c WHERE c.ativo = :ativo"),
    @NamedQuery(name = "ClienteFornecedor.findByEmail", query = "SELECT c FROM ClienteFornecedor c WHERE c.email = :email"),
    @NamedQuery(name = "ClienteFornecedor.findByTelefone", query = "SELECT c FROM ClienteFornecedor c WHERE c.telefone = :telefone"),
    @NamedQuery(name = "ClienteFornecedor.findByCep", query = "SELECT c FROM ClienteFornecedor c WHERE c.cep = :cep"),
    @NamedQuery(name = "ClienteFornecedor.findByEndereco", query = "SELECT c FROM ClienteFornecedor c WHERE c.endereco = :endereco"),
    @NamedQuery(name = "ClienteFornecedor.findByComplemento", query = "SELECT c FROM ClienteFornecedor c WHERE c.complemento = :complemento"),
    @NamedQuery(name = "ClienteFornecedor.findByCidade", query = "SELECT c FROM ClienteFornecedor c WHERE c.cidade = :cidade"),
    @NamedQuery(name = "ClienteFornecedor.findByEstado", query = "SELECT c FROM ClienteFornecedor c WHERE c.estado = :estado"),
    @NamedQuery(name = "ClienteFornecedor.findByDtCadastro", query = "SELECT c FROM ClienteFornecedor c WHERE c.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "ClienteFornecedor.findByDtUltimaAlteracao", query = "SELECT c FROM ClienteFornecedor c WHERE c.dtUltimaAlteracao = :dtUltimaAlteracao"),
    @NamedQuery(name = "ClienteFornecedor.findByPalavrasChave", query = "SELECT c FROM ClienteFornecedor c WHERE c.palavrasChave = :palavrasChave")})
public class ClienteFornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente_fornecedor")
    private Integer idClienteFornecedor;
    @Size(max = 100)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 250)
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @Size(max = 500)
    @Column(name = "razao_social")
    private String razaoSocial;
    @Size(max = 20)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 30)
    @Column(name = "cnpj")
    private String cnpj;
    @Size(max = 200)
    @Column(name = "atividade_principal")
    private String atividadePrincipal;
    @Column(name = "ativo")
    private Boolean ativo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 100)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 100)
    @Column(name = "cep")
    private String cep;
    @Size(max = 500)
    @Column(name = "endereco")
    private String endereco;
    @Size(max = 500)
    @Column(name = "complemento")
    private String complemento;
    @Size(max = 250)
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 100)
    @Column(name = "estado")
    private String estado;
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "dt_ultima_alteracao")
    @Temporal(TemporalType.DATE)
    private Date dtUltimaAlteracao;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacoes")
    private String observacoes;
    @Size(max = 500)
    @Column(name = "palavras_chave")
    private String palavrasChave;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClienteFornecedor")
    private Collection<LancamentoFinanceiro> lancamentoFinanceiroCollection;

    public ClienteFornecedor() {
    }

    public ClienteFornecedor(Integer idClienteFornecedor) {
        this.idClienteFornecedor = idClienteFornecedor;
    }

    public Integer getIdClienteFornecedor() {
        return idClienteFornecedor;
    }

    public void setIdClienteFornecedor(Integer idClienteFornecedor) {
        this.idClienteFornecedor = idClienteFornecedor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAtividadePrincipal() {
        return atividadePrincipal;
    }

    public void setAtividadePrincipal(String atividadePrincipal) {
        this.atividadePrincipal = atividadePrincipal;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Date getDtUltimaAlteracao() {
        return dtUltimaAlteracao;
    }

    public void setDtUltimaAlteracao(Date dtUltimaAlteracao) {
        this.dtUltimaAlteracao = dtUltimaAlteracao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public Collection<LancamentoFinanceiro> getLancamentoFinanceiroCollection() {
        return lancamentoFinanceiroCollection;
    }

    public void setLancamentoFinanceiroCollection(Collection<LancamentoFinanceiro> lancamentoFinanceiroCollection) {
        this.lancamentoFinanceiroCollection = lancamentoFinanceiroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClienteFornecedor != null ? idClienteFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteFornecedor)) {
            return false;
        }
        ClienteFornecedor other = (ClienteFornecedor) object;
        if ((this.idClienteFornecedor == null && other.idClienteFornecedor != null) || (this.idClienteFornecedor != null && !this.idClienteFornecedor.equals(other.idClienteFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ux.ClienteFornecedor[ idClienteFornecedor=" + idClienteFornecedor + " ]";
    }
    
}
