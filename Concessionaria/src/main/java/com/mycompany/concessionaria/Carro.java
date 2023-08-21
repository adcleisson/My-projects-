package com.mycompany.concessionaria;

public class Carro extends Veiculo{
    
    
    public Carro(String marca, String modelo, int ano, int quilometragem, String preco, int mot) {
        super(marca, modelo, ano, quilometragem, preco, mot);
    }
    public Carro(String modelo) {
        super(modelo);
    }
    
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public String getPreco() {
        return preco;
    }

    public int getQuilometragem() {
        return quilometragem;
    }
    public int getPotencia(){
        return mot;
    }
    public void setPotencia(int mot){
        this.mot = mot;
    }
    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
    
}