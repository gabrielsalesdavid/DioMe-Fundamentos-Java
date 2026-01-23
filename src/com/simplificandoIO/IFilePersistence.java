package com.SimplificandoIO;

public interface IFilePersistence {

    String write(final String data);

    boolean removeContent(final String sentence);

    String replace(final String oldContent, final String newContent);

    String findAll();

    String findBy(final String sentence);
}
