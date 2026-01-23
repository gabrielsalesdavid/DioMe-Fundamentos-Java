package com.simplificandoio; // Tudo em minúsculo

/**
 * Interface para persistência de dados em arquivos. Note que removi o "I" do
 * nome, seguindo o padrão Java.
 */
public interface FilePersistence {

    String write(final String data);

    boolean removeContent(final String sentence);

    String replace(final String oldContent, final String newContent);

    String findAll();

    String findBy(final String sentence);
}
