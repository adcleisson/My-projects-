package com.mycompany.concessionaria;
public class Vendedor extends Pessoa{
    private int cadastro;
    private String cliente;
    private String carro;
    private String situacao;
    public Vendedor(String nome, int cadastro, String carro, String cliente, String situacao) {
        super(nome);
        this.cadastro = cadastro;
        this.cliente = cliente;
        this.carro = carro;
        this.situacao = situacao;
    }
    
    public int getCadastro() {
        return cadastro;
    }

    public void setCadastro(int cadastro) {
        this.cadastro = cadastro;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
}
