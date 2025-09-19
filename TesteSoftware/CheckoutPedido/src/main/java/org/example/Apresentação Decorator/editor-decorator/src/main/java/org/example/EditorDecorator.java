package org.example;

public abstract class EditorDecorator implements EditorTexto {
    protected EditorTexto editor;

    public EditorDecorator(EditorTexto editor) {
        this.editor = editor;
    }

    @Override
    public String escrever(String texto) {
        return editor.escrever(texto);
    }
}
