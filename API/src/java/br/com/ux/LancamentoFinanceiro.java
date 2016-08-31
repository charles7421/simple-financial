/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ux;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author charles
 */
@Entity
@Table(name = "lancamento_financeiro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LancamentoFinanceiro.findAll", query = "SELECT l FROM LancamentoFinanceiro l"),
    @NamedQuery(name = "LancamentoFinanceiro.findByIdLancamentoFinanceiro", query = "SELECT l FROM LancamentoFinanceiro l WHERE l.idLancamentoFinanceiro = :idLancamentoFinanceiro"),
    @NamedQuery(name = "LancamentoFinanceiro.findByDescricao", query = "SELECT l FROM LancamentoFinanceiro l WHERE l.descricao = :descricao"),
    @NamedQuery(name = "LancamentoFinanceiro.findByTipo", query = "SELECT l FROM LancamentoFinanceiro l WHERE l.tipo = :tipo"),
    @NamedQuery(name = "LancamentoFinanceiro.findBySituacao", query = "SELECT l FROM LancamentoFinanceiro l WHERE l.situacao = :situacao"),
    @NamedQuery(name = "LancamentoFinanceiro.findByDtLancamento", query = "SELECT l FROM LancamentoFinanceiro l WHERE l.dtLancamento = :dtLancamento"),
    @NamedQuery(name = "LancamentoFinanceiro.findByDtVencimento", query = "SELECT l FROM LancamentoFinanceiro l WHERE l.dtVencimento = :dtVencimento"),
    @NamedQuery(name = "LancamentoFinanceiro.findByDtEstorno", query = "SELECT l FROM LancamentoFinanceiro l WHERE l.dtEstorno = :dtEstorno"),
    @NamedQuery(name = "LancamentoFinanceiro.findByDespesaFixa", query = "SELECT l FROM LancamentoFinanceiro l WHERE l.despesaFixa = :despesaFixa"),
    @NamedQuery(name = "LancamentoFinanceiro.findByOcorrenciaDespesa", query = "SELECT l FROM LancamentoFinanceiro l WHERE l.ocorrenciaDespesa = :ocorrenciaDespesa"),
    @NamedQuery(name = "LancamentoFinanceiro.findByParcelado", query = "SELECT l FROM LancamentoFinanceiro l WHERE l.parcelado = :parcelado"),
    @NamedQuery(name = "LancamentoFinanceiro.findByOcorrenciaParcelamento", query = "SELECT l FROM LancamentoFinanceiro l WHERE l.ocorrenciaParcelamento = :ocorrenciaParcelamento"),
    @NamedQuery(name = "LancamentoFinanceiro.findByQtdParcelamento", query = "SELECT l FROM LancamentoFinanceiro l WHERE l.qtdParcelamento = :qtdParcelamento"),
    @NamedQuery(name = "LancamentoFinanceiro.findByValor", query = "SELECT l FROM LancamentoFinanceiro l WHERE l.valor = :valor")})
public class LancamentoFinanceiro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lancamento_financeiro")
    private Integer idLancamentoFinanceiro;
    @Size(max = 500)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 255)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 100)
    @Column(name = "situacao")
    private String situacao;
    @Column(name = "dt_lancamento")
    @Temporal(TemporalType.DATE)
    private Date dtLancamento;
    @Column(name = "dt_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dtVencimento;
    @Column(name = "dt_estorno")
    @Temporal(TemporalType.DATE)
    private Date dtEstorno;
    @Column(name = "despesa_fixa")
    private Boolean despesaFixa;
    @Size(max = 255)
    @Column(name = "ocorrencia_despesa")
    private String ocorrenciaDespesa;
    @Column(name = "parcelado")
    private Boolean parcelado;
    @Column(name = "ocorrencia_parcelamento")
    private Integer ocorrenciaParcelamento;
    @Size(max = 255)
    @Column(name = "qtd_parcelamento")
    private String qtdParcelamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
    @ManyToOne(optional = false)
    private TipoDocumento idTipoDocumento;
    @JoinColumn(name = "id_sub_categoria", referencedColumnName = "id_sub_categoria")
    @ManyToOne(optional = false)
    private SubCategoria idSubCategoria;
    @JoinColumn(name = "id_cliente_fornecedor", referencedColumnName = "id_cliente_fornecedor")
    @ManyToOne(optional = false)
    private ClienteFornecedor idClienteFornecedor;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @JoinColumn(name = "id_cartao_credito", referencedColumnName = "id_cartao_credito")
    @ManyToOne(optional = false)
    private CartaoCredito idCartaoCredito;

    public LancamentoFinanceiro() {
    }

    public LancamentoFinanceiro(Integer idLancamentoFinanceiro) {
        this.idLancamentoFinanceiro = idLancamentoFinanceiro;
    }

    public Integer getIdLancamentoFinanceiro() {
        return idLancamentoFinanceiro;
    }

    public void setIdLancamentoFinanceiro(Integer idLancamentoFinanceiro) {
        this.idLancamentoFinanceiro = idLancamentoFinanceiro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(Date dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public Date getDtEstorno() {
        return dtEstorno;
    }

    public void setDtEstorno(Date dtEstorno) {
        this.dtEstorno = dtEstorno;
    }

    public Boolean getDespesaFixa() {
        return despesaFixa;
    }

    public void setDespesaFixa(Boolean despesaFixa) {
        this.despesaFixa = despesaFixa;
    }

    public String getOcorrenciaDespesa() {
        return ocorrenciaDespesa;
    }

    public void setOcorrenciaDespesa(String ocorrenciaDespesa) {
        this.ocorrenciaDespesa = ocorrenciaDespesa;
    }

    public Boolean getParcelado() {
        return parcelado;
    }

    public void setParcelado(Boolean parcelado) {
        this.parcelado = parcelado;
    }

    public Integer getOcorrenciaParcelamento() {
        return ocorrenciaParcelamento;
    }

    public void setOcorrenciaParcelamento(Integer ocorrenciaParcelamento) {
        this.ocorrenciaParcelamento = ocorrenciaParcelamento;
    }

    public String getQtdParcelamento() {
        return qtdParcelamento;
    }

    public void setQtdParcelamento(String qtdParcelamento) {
        this.qtdParcelamento = qtdParcelamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public TipoDocumento getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(TipoDocumento idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public SubCategoria getIdSubCategoria() {
        return idSubCategoria;
    }

    public void setIdSubCategoria(SubCategoria idSubCategoria) {
        this.idSubCategoria = idSubCategoria;
    }

    public ClienteFornecedor getIdClienteFornecedor() {
        return idClienteFornecedor;
    }

    public void setIdClienteFornecedor(ClienteFornecedor idClienteFornecedor) {
        this.idClienteFornecedor = idClienteFornecedor;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public CartaoCredito getIdCartaoCredito() {
        return idCartaoCredito;
    }

    public void setIdCartaoCredito(CartaoCredito idCartaoCredito) {
        this.idCartaoCredito = idCartaoCredito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLancamentoFinanceiro != null ? idLancamentoFinanceiro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LancamentoFinanceiro)) {
            return false;
        }
        LancamentoFinanceiro other = (LancamentoFinanceiro) object;
        if ((this.idLancamentoFinanceiro == null && other.idLancamentoFinanceiro != null) || (this.idLancamentoFinanceiro != null && !this.idLancamentoFinanceiro.equals(other.idLancamentoFinanceiro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ux.LancamentoFinanceiro[ idLancamentoFinanceiro=" + idLancamentoFinanceiro + " ]";
    }
    
}
