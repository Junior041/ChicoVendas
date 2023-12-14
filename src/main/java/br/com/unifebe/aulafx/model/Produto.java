package br.com.unifebe.aulafx.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produto {
    private final StringProperty nome;
    private final SimpleDoubleProperty preco;
    private final SimpleDoubleProperty quantidade;

    public Produto(String nome, double preco, double quantidade) {
        this.nome = new SimpleStringProperty(nome);
        this.preco = new SimpleDoubleProperty(preco);
        this.quantidade = new SimpleDoubleProperty(quantidade);
    }

    public String getNome() {
        return nome.get();
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public double getPreco() {
        return preco.get();
    }

    public SimpleDoubleProperty precoProperty() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco.set(preco);
    }

    public double getQuantidade() {
        return quantidade.get();
    }

    public SimpleDoubleProperty quantidadeProperty() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade.set(quantidade);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome=" + nome +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}
