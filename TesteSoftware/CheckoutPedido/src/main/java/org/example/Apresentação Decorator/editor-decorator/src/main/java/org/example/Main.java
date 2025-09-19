package org.example;

public class Main {
    public static void main(String[] args) {
        EditorTexto editor = new EditorBasico();

        // Adicionando decorators
        editor = new NegritoDecorator(editor);
        editor = new ItalicoDecorator(editor);
        editor = new CorretorDecorator(editor);
        editor = new TradutorDecorator(editor);
        editor = new PDFDecorator(editor);

        String texto = "Este é um texto com alguns erros.";
        System.out.println(editor.escrever(texto));
    }
}
