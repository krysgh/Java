package org.example;

import java.util.Objects;

public class Produto {

    private String nome;
    private double preco;
    private String categoria;
    private int quantidade;
    private double distancia;
    private boolean status;
    private String regiao;

    public Produto(String nome, double preco, String categoria, int quantidade, double distancia, boolean status, String regiao) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.distancia = distancia;
        this.status = status;
        this.regiao = regiao;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome ='" + nome + '\'' +
                ", preco =" + preco +
                ", categoria ='" + categoria + '\'' +
                ", quantidade =" + quantidade +
                ", distancia=" + distancia +
                ", status =" + status +
                ", regiao ='" + regiao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Double.compare(preco, produto.preco) == 0 && quantidade == produto.quantidade && Double.compare(distancia, produto.distancia) == 0 && status == produto.status && Objects.equals(nome, produto.nome) && Objects.equals(categoria, produto.categoria) && Objects.equals(regiao, produto.regiao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, preco, categoria, quantidade, distancia, status, regiao);
    }
}
