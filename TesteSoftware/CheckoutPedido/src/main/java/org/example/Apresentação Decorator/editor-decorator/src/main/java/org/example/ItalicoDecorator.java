package org.example;

public class ItalicoDecorator extends EditorDecorator {
    public ItalicoDecorator(EditorTexto editor) {
        super(editor);
    }

    @Override
    public String escrever(String texto) {
        return "_" + super.escrever(texto) + "_";
    }
}
