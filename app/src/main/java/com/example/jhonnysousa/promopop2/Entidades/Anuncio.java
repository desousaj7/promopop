package com.example.jhonnysousa.promopop2.Entidades;

public class Anuncio {

    private String id;
    private String titulo;
    private String imagem;
    private Integer valorAntigo;
    private Integer valorAtual;
    private String validade;
    private Usuario vendedor;

    public Anuncio() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Integer getValorAntigo() {
        return valorAntigo;
    }

    public void setValorAntigo(Integer valorAntigo) {
        this.valorAntigo = valorAntigo;
    }

    public int getValorAtual(Double s) {
        return valorAtual;
    }

    public void setValorAtual(Integer valorAtual) {
        this.valorAtual = valorAtual;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

}
