package org.example;

public class TradutorDecorator extends EditorDecorator {
    public TradutorDecorator(EditorTexto editor) {
        super(editor);
    }

    @Override
    public String escrever(String texto) {
        return super.escrever(texto.replaceAll("texto", "text").replaceAll("erros", "mistakes"));
    }
}
