import org.example.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheckoutPedidoTest {

    private static final CheckoutPedido pedido = new CheckoutPedido();
    private static final double DELTA = 0.0001;


    @Test
    public void validarStatusProduto(){
            assertThrows(IllegalArgumentException.class, () ->{

            pedido.calcularTotal(new Produto("Caderno",40.00, "Papelaria", 2, 4, false, "Capital"), new Cupom("PRIMEIRA COMPRA 10%", 0.10, 50000, 10));

            });
        }

    @Test
    public void validarQntPositiva(){
        assertThrows(IllegalArgumentException.class, () -> {

            pedido.calcularTotal(new Produto("Lapiseira", 10, "Papelaria", 0, 2,true, "INTERIOR"),new Cupom("PRIMEIRA COMPRA 10%", 0.10,50000,10));
            pedido.calcularTotal(new Produto("Lapiseira", 10, "Papelaria", -5, 2,true, "INTERIOR"),new Cupom("PRIMEIRA COMPRA 10%", 0.10,50000,10));

        });
    }

    @Test
    public void validarCategoriaELETRONICO(){

        Produto celular = new Produto("Smartphone Galaxy A26 8/256 5G", 1400, "ELETRÔNICO", 1000, 40,true, "CAPITAL");
        Cupom primeiracompra = new Cupom("PRIMEIRA COMPRA 10%", 0.10,1000,10);

        /* total = 1400 (preco do produto) +
                   ICMS (1400 * 0.18) +
                   FRETE GRÁTIS (preco > 200) -
                   CUPOM DE DESCONTO ATIVO (10% 1400 = 140)
                 = 1512.00 */
        assertEquals(1512.00,pedido.calcularTotal(celular,primeiracompra),DELTA,"Erro no cálculo do ICMS para a categoria ELETRÔNCO");

    }

    @Test
    public void validarFreteGratis(){

        Produto cobertor = new Produto("Kit Cobertor", 300, "CAMA", 50, 20,true, "CAPITAL");
        Cupom promocama = new Cupom("PROMOÇÃO KIT CAMA 20%", 0.20,300,5);

        /* total = 300 (preco do produto) +
                   FRETE GRÁTIS (preco > 200) -
                   CUPOM DE DESCONTO ATIVO (20% 300 = 60)
                 = 240.00 */

        assertEquals(240.00,pedido.calcularTotal(cobertor,promocama),DELTA,"Erro no cálculo de Frete Grátis");

    }

    @Test
    public void validarFretePadrao(){

        Produto bolsa = new Produto("Bolsa Nike", 180.00, "ESCOLA", 200, 20,true, "CAPITAL");
        Cupom promoescola = new Cupom("PROMOÇÃO ESCOLAR 20%", 0.20,150,10);

        /* total = 180 (preco do produto) +
                   FRETE  PADRAO (preco < 200 && regiao != "INTERIOR") -
                   CUPOM ATIVO (15% 180 = 36)
                 = 164.00 */

        assertEquals(164.00, pedido.calcularTotal(bolsa, promoescola), DELTA, "Erro no cálculo do Frete Padrão");

    }

    @Test
    public void validarFreteRegiao(){

        Produto mouse = new Produto("Mouse Gamer", 190.00, "PERIFÉRICOS", 15, 60,true, "INTERIOR");
        Cupom promoRazer = new Cupom("PROMOÇÃO RAZER 5%", 0.05,150,20);

        /* total = 190 (preco produto) +
                   FRETE REGIAO (30) -
                   CUPOM DE DESCONTO ATIVO (5% 190 = 9.5)
                 = 210.50 */

        assertEquals(210.50, pedido.calcularTotal(mouse, promoRazer), DELTA, "Erro no cálculo do Frete Região");

    }

    @Test
    public void validarCashback(){

        Produto casaco = new Produto("Casaco Couro", 280.00, "ROUPA", 20, 10,true, "INTERIOR");
        Cupom promoroupa = new Cupom("PROMOÇÃO ROUPAS 10%", 0.10,100,0);

        /* total = 280 (preco do produto)+
                   FRETE GRATIS (preco > 280) -
                   CASHBACK (1% 280 = 2.8)
                 = 277.20 */

        assertEquals(277.20,pedido.calcularTotal(casaco, promoroupa), DELTA,"Erro no cálculo do Cashback");

    }






    }


