package org.example;

public class PDFDecorator extends EditorDecorator {
    public PDFDecorator(EditorTexto editor) {
        super(editor);
    }

    @Override
    public String escrever(String texto) {
        return "[PDF] " + super.escrever(texto);
    }
}
