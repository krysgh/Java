import org.example.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DecoratorTest {

    @Test
    public void testarNegrito() {
        EditorTexto editor = new EditorBasico();
        editor = new NegritoDecorator(editor);
        assertEquals("**olá**", editor.escrever("olá"));
    }

    @Test
    public void testarItalicoNegrito() {
        EditorTexto editor = new EditorBasico();
        editor = new NegritoDecorator(editor);
        editor = new ItalicoDecorator(editor);
        assertEquals("_**olá**_", editor.escrever("olá"));
    }

    @Test
    public void testarCorretor() {
        EditorTexto editor = new EditorBasico();
        editor = new CorretorDecorator(editor);
        assertEquals("erros corrigidos", editor.escrever("erros"));
    }
}

