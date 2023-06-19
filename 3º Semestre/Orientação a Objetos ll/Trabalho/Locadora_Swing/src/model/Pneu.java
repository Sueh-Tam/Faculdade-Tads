/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author kirit
 */
public class Pneu {
    
    private int id;
    private String seriePneu;
    private String corPneu;
    private int codPneu;
    private String estadoPneu;
    private String dataLocacao;
    private Float preco;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getSeriePneu() {
        return seriePneu;
    }
    public void setSeriePneu(String seriePneu) {
        this.seriePneu = seriePneu;
    }

    public String getCorPneu() {
        return corPneu;
    }
    public void setCorPneu(String corPneu) {
        this.corPneu = corPneu;
    }

    public int getCodPneu() {
        return codPneu;
    }
    public void setCodPneu(int codPneu) {
        this.codPneu = codPneu;
    }

    public String getEstadoPneu() {
        return estadoPneu;
    }
    public void setEstadoPneu(String estadoPneu) {
        this.estadoPneu = estadoPneu;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }
    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Float getPreco() {
        return preco;
    }
    public void setPreco(Float preco) {
        this.preco = preco;
    }
    
    public void todosOsDados(){
        System.out.println("----------");
        System.out.println("----------");
        System.out.println("Serie do pneu: [ "+ this.seriePneu+" ]");
        System.out.println("Cor do Pneu: [ "+this.corPneu+" ]");
        System.out.println("Codigo pneu [ "+this.codPneu+" ]");
        System.out.println("Estado pneu [ "+this.estadoPneu+" ]");
        System.out.println("Preço do Pneu [ "+this.preco+" ]");
        System.out.println("----------");
        System.out.println("----------");
    }
}
