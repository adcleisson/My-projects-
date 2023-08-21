package com.mycompany.concessionaria;
public class Pessoa implements Cpf{
    private String nome;
    private String telefone;
    private Data nascimento;
    private String cpf;
    
    public Pessoa(String nome, String telefone, int dia, int mes, int ano){
        this.nascimento = new Data(dia, mes, ano);
        this.nome = nome;
        this.telefone = telefone;
        
    }
    public Pessoa(String nome, int dia, int mes, int ano,String cpf){
        this.nascimento = new Data(dia, mes, ano);
        this.nome = nome;
        this.cpf = cpf;
    }
    public Pessoa(String nome,String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
    public Pessoa(String nome){
        this.nome = nome;
    }
    
    public Pessoa(int dia, int mes, int ano){
        this.nascimento = new Data(dia, mes, ano);
    }

  
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public String getTelefone(){
        return telefone;
    }
    public void setNascimento(int dia, int mes, int ano){
        this.nascimento.setDia(dia);
        this.nascimento.setMes(mes);
        this.nascimento.setAno(ano);
    }
    public Data getNascimento(){
        return this.nascimento = nascimento;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    @Override
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    int diaa;
    int mess;
    int anoo;
    public Pessoa(String nome, String telefone, int diaa, int mess, int anoo,String cpf){
        if(diaa > 0 || diaa < 32){
            this.diaa = diaa;
        }
        if(mess > 0 || mess < 13){
            this.mess = mess;
        }
        if(anoo > 1900 || anoo < 2004){
            this.anoo = anoo;
        }
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public int getDiaa() {
        return diaa;
    }

    public void setDiaa(int diaa) {
        if(diaa > 0 || diaa < 32){
            this.diaa = diaa;
        }
    }

    public int getMess() {
        return mess;
    }

    public void setMess(int mess) {
        if(mess > 0 || mess < 13){
            this.mess = mess;
        }
    }

    public int getAnoo() {
        return anoo;
    }

    public void setAnoo(int anoo) {
        if(anoo > 1900 || anoo < 2004){
            this.anoo = anoo;
        }
    }
    
    
}

