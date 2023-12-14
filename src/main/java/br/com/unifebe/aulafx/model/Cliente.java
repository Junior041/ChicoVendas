package br.com.unifebe.aulafx.model;

import javafx.beans.property.SimpleStringProperty;

public class Cliente {

    private SimpleStringProperty titular;
    private SimpleStringProperty cpf;
    private SimpleStringProperty agencia;
    private SimpleStringProperty conta;

    public Cliente() {
        this.titular = new SimpleStringProperty();
        this.cpf = new SimpleStringProperty();
        this.agencia = new SimpleStringProperty();
        this.conta = new SimpleStringProperty();
    }

    public Cliente(String titular, String cpf, String agencia, String conta) {
        this.titular = new SimpleStringProperty(titular);
        this.cpf = new SimpleStringProperty(cpf);
        this.agencia = new SimpleStringProperty(agencia);
        this.conta = new SimpleStringProperty(conta);
    }

    public String getTitular() {
        return titular.get();
    }

    public SimpleStringProperty titularProperty() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular.set(titular);
    }

    public String getCpf() {
        return cpf.get();
    }

    public SimpleStringProperty cpfProperty() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf.set(cpf);
    }

    public String getAgencia() {
        return agencia.get();
    }

    public SimpleStringProperty agenciaProperty() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia.set(agencia);
    }

    public String getConta() {
        return conta.get();
    }

    public SimpleStringProperty contaProperty() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta.set(conta);
    }
}
