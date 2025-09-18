package org.example;

public class CheckoutPedido {

    private static final double ICMS_ELETRONICO = 0.18;
    private static final double TETO_FRETE_GRATIS = 200.00;
    private static final double FRETE_GRATIS = 0.00;
    private static final double FRETE_PADRAO = 20.00;
    private static final double FRETE_REGIAO = 30.00;
    private static final double CASHBACK = 0.01;
    private static final double MINIMO = 10.00;


    public static double calcularTotal(Produto produto, Cupom cupom) {

        double total = 0.0;

        //VALIDAÇÃO DO STATUS DO PRODUTO
        validar(produto);

        total = produto.getPreco();

            //VALIDA SE A CLASSIFICACAO EH "ELETRONICO" PARA APLICAR O IMPOSTO ICMS
            if ("ELETRÔNICO".equalsIgnoreCase(produto.getCategoria())) {
                total *= 1 + ICMS_ELETRONICO;
            }

            //INCREMENTA O VALOR DOS FRETES COM BASE EM CONDICOES DE REGIAO E TETO DO PRECO
            if (produto.getPreco() >= TETO_FRETE_GRATIS) {
                total += FRETE_GRATIS;

            }
            else {
                if ("INTERIOR".equalsIgnoreCase(produto.getRegiao())) {
                    total += FRETE_REGIAO;
                }
                else{
                    total += FRETE_PADRAO;
                }
            }

            //VALIDA SE O CUPOM ESTA ATIVO E APLICA SOBRE O TOTAL
            if(cupom.getDiasParaExpirar() > 0 && produto.getPreco() >= cupom.getTeto()){
                total -= (produto.getPreco() * cupom.getPercentual());
            }
            else{
                total -= (produto.getPreco() * CASHBACK);
            }

            total = Math.max(MINIMO,total);

        return total;
    }

    public static void validar(Produto produto){
        if(!produto.isStatus()) throw new IllegalArgumentException("Status do produto deve ser true");
        if(produto.getQuantidade() <= 0) throw new IllegalArgumentException("Quantidade do produto deve ser maior que 0");
    }

    public static void main(String[] args){
        CheckoutPedido pedido = new CheckoutPedido();

        Produto celular = new Produto("Smartphone Galaxy A26 8/256 5G", 1400, "ELETRÔNICO", 1000, 40,true, "CAPITAL");
        Cupom primeiracompra = new Cupom("PRIMEIRA COMPRA 10%", 0.10,1000,10);
        System.out.println("\nPedido 1 :\n" + celular.toString() + "\n" + primeiracompra.toString() + "\nTOTAL: R$" + pedido.calcularTotal(celular, primeiracompra));

        Produto cobertor = new Produto("Kit Cobertor", 300, "CAMA", 50, 20,true, "CAPITAL");
        Cupom promocama = new Cupom("PROMOÇÃO KIT CAMA 20%", 0.20,300,5);
        System.out.println("\nPedido 2 :\n" + cobertor.toString() + "\n" + promocama.toString() + "\nTOTAL: R$" + pedido.calcularTotal(cobertor, promocama));

        Produto mala = new Produto("Mala G", 320, "VIAGEM", 1000, 40,true, "CAPITAL");
        Cupom promotrip = new Cupom("PROMOÇÃO VIAGEM 25%", 0.25,400,10);
        System.out.println("\nPedido 3 :\n" + mala.toString() + "\n" + promotrip.toString() + "\nTOTAL: R$" + pedido.calcularTotal(mala, promotrip));

        Produto tenis = new Produto("Tênis Corrida", 320, "CALÇADO", 20, 10,true, "CAPITAL");
        Cupom queimaestoque = new Cupom("PROMOÇÃO TÊNIS 98%", 0.98,300,1);
        System.out.println("\nPedido 4 :\n" + tenis.toString() + "\n" + queimaestoque.toString() + "\nTOTAL: R$" + pedido.calcularTotal(tenis, queimaestoque));




    }



}
