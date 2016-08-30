/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ux.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuarios.findByTipo", query = "SELECT u FROM Usuarios u WHERE u.tipo = :tipo"),
    @NamedQuery(name = "Usuarios.findByNomeFantasia", query = "SELECT u FROM Usuarios u WHERE u.nomeFantasia = :nomeFantasia"),
    @NamedQuery(name = "Usuarios.findByRazaoSocial", query = "SELECT u FROM Usuarios u WHERE u.razaoSocial = :razaoSocial"),
    @NamedQuery(name = "Usuarios.findByUser", query = "SELECT u FROM Usuarios u WHERE u.user = :user"),
    @NamedQuery(name = "Usuarios.findBySenha", query = "SELECT u FROM Usuarios u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuarios.findByPrimeiroNome", query = "SELECT u FROM Usuarios u WHERE u.primeiroNome = :primeiroNome"),
    @NamedQuery(name = "Usuarios.findBySegundoNome", query = "SELECT u FROM Usuarios u WHERE u.segundoNome = :segundoNome"),
    @NamedQuery(name = "Usuarios.findByCpf", query = "SELECT u FROM Usuarios u WHERE u.cpf = :cpf"),
    @NamedQuery(name = "Usuarios.findByCnpj", query = "SELECT u FROM Usuarios u WHERE u.cnpj = :cnpj"),
    @NamedQuery(name = "Usuarios.findByAtividadePrincipal", query = "SELECT u FROM Usuarios u WHERE u.atividadePrincipal = :atividadePrincipal"),
    @NamedQuery(name = "Usuarios.findByRegimeTributario", query = "SELECT u FROM Usuarios u WHERE u.regimeTributario = :regimeTributario"),
    @NamedQuery(name = "Usuarios.findByAliquotaSimples", query = "SELECT u FROM Usuarios u WHERE u.aliquotaSimples = :aliquotaSimples"),
    @NamedQuery(name = "Usuarios.findByMoeda", query = "SELECT u FROM Usuarios u WHERE u.moeda = :moeda"),
    @NamedQuery(name = "Usuarios.findByTaxaUm", query = "SELECT u FROM Usuarios u WHERE u.taxaUm = :taxaUm"),
    @NamedQuery(name = "Usuarios.findByTaxaDois", query = "SELECT u FROM Usuarios u WHERE u.taxaDois = :taxaDois"),
    @NamedQuery(name = "Usuarios.findByCaixaInicial", query = "SELECT u FROM Usuarios u WHERE u.caixaInicial = :caixaInicial"),
    @NamedQuery(name = "Usuarios.findByLogo", query = "SELECT u FROM Usuarios u WHERE u.logo = :logo"),
    @NamedQuery(name = "Usuarios.findByAtivo", query = "SELECT u FROM Usuarios u WHERE u.ativo = :ativo"),
    @NamedQuery(name = "Usuarios.findByBloqueado", query = "SELECT u FROM Usuarios u WHERE u.bloqueado = :bloqueado"),
    @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email"),
    @NamedQuery(name = "Usuarios.findByEmailConfirmado", query = "SELECT u FROM Usuarios u WHERE u.emailConfirmado = :emailConfirmado"),
    @NamedQuery(name = "Usuarios.findByTelefone", query = "SELECT u FROM Usuarios u WHERE u.telefone = :telefone"),
    @NamedQuery(name = "Usuarios.findByFacebook", query = "SELECT u FROM Usuarios u WHERE u.facebook = :facebook"),
    @NamedQuery(name = "Usuarios.findByDtCadastro", query = "SELECT u FROM Usuarios u WHERE u.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "Usuarios.findByDtEncerramento", query = "SELECT u FROM Usuarios u WHERE u.dtEncerramento = :dtEncerramento"),
    @NamedQuery(name = "Usuarios.findByTrial", query = "SELECT u FROM Usuarios u WHERE u.trial = :trial")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Size(max = 100)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 250)
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @Size(max = 500)
    @Column(name = "razao_social")
    private String razaoSocial;
    @Size(max = 100)
    @Column(name = "user")
    private String user;
    @Size(max = 100)
    @Column(name = "senha")
    private String senha;
    @Size(max = 250)
    @Column(name = "primeiro_nome")
    private String primeiroNome;
    @Size(max = 250)
    @Column(name = "segundo_nome")
    private String segundoNome;
    @Size(max = 20)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 30)
    @Column(name = "cnpj")
    private String cnpj;
    @Size(max = 200)
    @Column(name = "atividade_principal")
    private String atividadePrincipal;
    @Size(max = 100)
    @Column(name = "regime_tributario")
    private String regimeTributario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "aliquota_simples")
    private BigDecimal aliquotaSimples;
    @Size(max = 100)
    @Column(name = "moeda")
    private String moeda;
    @Column(name = "taxa_um")
    private BigDecimal taxaUm;
    @Column(name = "taxa_dois")
    private BigDecimal taxaDois;
    @Column(name = "caixa_inicial")
    private BigDecimal caixaInicial;
    @Size(max = 255)
    @Column(name = "logo")
    private String logo;
    @Column(name = "ativo")
    private Boolean ativo;
    @Column(name = "bloqueado")
    private Boolean bloqueado;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Column(name = "email_confirmado")
    private Boolean emailConfirmado;
    @Size(max = 100)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 500)
    @Column(name = "facebook")
    private String facebook;
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "dt_encerramento")
    @Temporal(TemporalType.DATE)
    private Date dtEncerramento;
    @Column(name = "trial")
    private Boolean trial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<ClientesFornecedores> clientesFornecedoresList;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSegundoNome() {
        return segundoNome;
    }

    public void setSegundoNome(String segundoNome) {
        this.segundoNome = segundoNome;
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

    public String getRegimeTributario() {
        return regimeTributario;
    }

    public void setRegimeTributario(String regimeTributario) {
        this.regimeTributario = regimeTributario;
    }

    public BigDecimal getAliquotaSimples() {
        return aliquotaSimples;
    }

    public void setAliquotaSimples(BigDecimal aliquotaSimples) {
        this.aliquotaSimples = aliquotaSimples;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public BigDecimal getTaxaUm() {
        return taxaUm;
    }

    public void setTaxaUm(BigDecimal taxaUm) {
        this.taxaUm = taxaUm;
    }

    public BigDecimal getTaxaDois() {
        return taxaDois;
    }

    public void setTaxaDois(BigDecimal taxaDois) {
        this.taxaDois = taxaDois;
    }

    public BigDecimal getCaixaInicial() {
        return caixaInicial;
    }

    public void setCaixaInicial(BigDecimal caixaInicial) {
        this.caixaInicial = caixaInicial;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEmailConfirmado() {
        return emailConfirmado;
    }

    public void setEmailConfirmado(Boolean emailConfirmado) {
        this.emailConfirmado = emailConfirmado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Date getDtEncerramento() {
        return dtEncerramento;
    }

    public void setDtEncerramento(Date dtEncerramento) {
        this.dtEncerramento = dtEncerramento;
    }

    public Boolean getTrial() {
        return trial;
    }

    public void setTrial(Boolean trial) {
        this.trial = trial;
    }

    @XmlTransient
    public List<ClientesFornecedores> getClientesFornecedoresList() {
        return clientesFornecedoresList;
    }

    public void setClientesFornecedoresList(List<ClientesFornecedores> clientesFornecedoresList) {
        this.clientesFornecedoresList = clientesFornecedoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ux.model.Usuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
