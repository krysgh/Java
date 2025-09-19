package org.example;

public class NegritoDecorator extends EditorDecorator {
    public NegritoDecorator(EditorTexto editor) {
        super(editor);
    }

    @Override
    public String escrever(String texto) {
        return "**" + super.escrever(texto) + "**";
    }
}
