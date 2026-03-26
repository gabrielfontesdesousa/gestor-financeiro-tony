package gerenciador.financeiro.model;

import gerenciador.financeiro.enums.StatusTransacao;
import gerenciador.financeiro.enums.TipoTransacao;

import java.time.LocalDateTime;

public class Transacao {
    private Integer id;
    private Double valor;
    private LocalDateTime dtHora;
    private StatusTransacao status;
    private String descricao;
    private Categoria categoria;
    private TipoTransacao tipoTransacao;
    private Integer categoriaId;

    public Transacao() {
    }

    public Transacao(Double valor, LocalDateTime dtHora, String descricao, Categoria categoria, TipoTransacao tipoTransacao) {
        this.valor = valor;
        this.dtHora = dtHora;
        this.descricao = descricao;
        this.categoria = categoria;
        this.tipoTransacao = tipoTransacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDtHora() {
        return dtHora;
    }

    public void setDtHora(LocalDateTime dtHora) {
        this.dtHora = dtHora;
    }

    public StatusTransacao getStatus() {
        return status;
    }

    public void setStatus(StatusTransacao status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", valor=" + valor +
                ", dtHora=" + dtHora +
                ", status=" + status +
                ", descricao='" + descricao + '\'' +
                ", categoria=" + categoria +
                ", tipoTransacao=" + tipoTransacao +
                ", categoriaId=" + categoriaId +
                '}';
    }
}