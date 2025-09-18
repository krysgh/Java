package org.example;

public class Cupom {

    private String nome;
    private double percentual;
    private double teto;
    private int diasParaExpirar;

    public Cupom(String nome,double percentual, double teto, int diasParaExpirar ){
        this.nome= nome;
        this.percentual = percentual;
        this.teto = teto;
        this.diasParaExpirar = diasParaExpirar;
    }


    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }

    public double getTeto() {
        return teto;
    }

    public void setTeto(double teto) {
        this.teto = teto;
    }

    public int getDiasParaExpirar() {
        return diasParaExpirar;
    }

    public void setDiasParaExpirar(int diasParaExpirar) {
        this.diasParaExpirar = diasParaExpirar;
    }

    @Override
    public String toString() {
        return "Cupom{" +
                "nome ='" + nome + '\'' +
                ", percentual =" + percentual +
                ", teto =" + teto +
                ", diasParaExpirar =" + diasParaExpirar +
                '}';
    }
}
