package org.example;

public class CorretorDecorator extends EditorDecorator {
    public CorretorDecorator(EditorTexto editor) {
        super(editor);
    }

    @Override
    public String escrever(String texto) {
        return super.escrever(texto.replaceAll("erros", "erros corrigidos"));
    }
}
