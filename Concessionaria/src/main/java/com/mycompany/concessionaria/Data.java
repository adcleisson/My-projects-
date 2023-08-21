package com.mycompany.concessionaria;
public class Data {

    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia=dia;
        this.mes=mes;
        this.ano=ano;
    }

    public void Data(int dia, int mes, int ano) {
        if (dia > 0 || dia < 32){
            this.dia = dia;
        }
        if (mes > 0 || mes < 13){
            this.mes = mes;
        }
        if (ano > 1921) {
            this.ano = ano;
        }
    }
    
    
    public void setDia(int dia) {
        if (dia > 0 || dia < 32){
            this.dia = dia;
        }
        else{
            System.out.println("Data inexistente!!");
        }
    }
    public int getDia(){
        return dia;
    }
    public void setMes(int dia) {
        if (mes > 0 || mes < 13){
            this.mes = mes;
        }
        else{
            System.out.println("Data inexistente!!");
        }
    }
    public int getMes(){
        return mes;
    }
    public void setAno(int dia) {
        if (ano > 1921) {
            this.ano = ano;
        }
        else{
            System.out.println("Data inexistente!!");
        }
    }
    public int getAno(){
        return ano;
    }
}

