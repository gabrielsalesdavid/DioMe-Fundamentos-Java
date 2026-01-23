package com.simplificandoIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.stream.Stream;

public class IOFilePersistence implements IFilePersistence {

    private final String currentDir = System.getProperty("user.dir");
    private final String filePath = currentDir + "/data/data.txt";
    private final String fileName;

    public IOFilePersistence(String fileName) {
        this.fileName = fileName;
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String write(final String data) {

        var conten = new StringBuilder();

        try (FileWriter fileWrite = new FileWriter(currentDir + filePath + fileName, true); var bufferedWriter = fileWrite.getBufferedWriter(fileWrite); var printWriter = fileWrite.getPrintWriter(bufferedWriter)) {

            String line;

            do {

                line = fileWrite.readLine();
                if (line != null) {
                    conten.append(line).append(System.lineSeparator());
                }
            } while (line != null);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean removeContent(final String sentence) {
        var content = findAll();
        if (content != null && content.contains(sentence)) {
            content = content.replace(sentence + System.lineSeparator(), "");
            clearFile();
            write(content);
            return true;
        }
        return false;
    }

    @Override
    public String replace(final String oldContent, final String newContent) {
        var content = findAll();
        var contentListed = new ArrayList<>(Stream.of(content.split(System.lineSeparator())).toList());
        if (content != null && content.contains(oldContent)) {
            var index = contentListed.indexOf(oldContent);
            contentListed.set(index, newContent);
            clearFile();
            for (String line : contentListed) {
                write(line + System.lineSeparator());
            }
        }
        return null;
    }

    @Override
    public String findAll() {

        var content = new StringBuilder();
        try (var reader = new BufferedReader(new FileReader(currentDir + filePath + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
            return content.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String findBy(final String sentence) {
        String found;
        try (var reader = new BufferedReader(new FileReader(currentDir + filePath + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(sentence)) {
                    return line;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<String> readFileLines() {
        var lines = new ArrayList<String>();
        try (var reader = new BufferedReader(new FileReader(currentDir + filePath + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    private void clearFile() {

        try {
            OutputStream outputStream = new FileOutputStream(new File(currentDir + filePath + fileName));
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
