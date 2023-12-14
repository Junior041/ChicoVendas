package br.com.unifebe.aulafx.model;

public class CarrinhoItem {

    private String produtoNome;
    private int quantidade;

    public CarrinhoItem(String produtoNome, int quantidade) {
        this.produtoNome = produtoNome;
        this.quantidade = quantidade;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "CarrinhoItem{" +
                "produtoNome='" + produtoNome + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
