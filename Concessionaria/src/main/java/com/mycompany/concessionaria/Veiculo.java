package com.mycompany.concessionaria;
public abstract class Veiculo {
    public String marca;
    public String modelo;
    public int ano;
    public int quilometragem;
    public String preco;
    public Motor motor;
    
    Motor m = new Motor(0);
    int mot = m.getPotencia();
    
    public Veiculo(String marca, String modelo, int ano, int quilometragem, String preco, int mot) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.preco = preco;
        
        
    }
    public Veiculo(String modelo) {
        this.modelo = modelo;
    }
}
