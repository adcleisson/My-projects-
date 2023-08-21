package com.mycompany.concessionaria;
public class Cliente extends Pessoa {
    public String comprado;
    public Cliente(String nome, String telefone, int diaa, int mess, int anoo, String cpf, String comprado) {
        super(nome, telefone, diaa, mess, anoo, cpf);
        this.comprado = comprado;
    }

    public Cliente(String nome, int dia, int mes, int ano, String cpf, String comprado) {
        super(nome, dia, mes, ano, cpf);
        this.comprado = comprado;
    }

    public Cliente(String nome, String cpf, String comprado) {
        super(nome, cpf);
        this.comprado = comprado;
    }
    public String getCarroComprado(){
        return comprado;
    }

    public void setCarroComprado(String comprado) {
        this.comprado = comprado;
    }
    
}
