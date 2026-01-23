package com.simplificandoio;

import java.io.BufferedReader; // Import necessário
import java.io.BufferedWriter; // Import necessário
import java.io.File;
import java.io.FileReader;     // Import necessário
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;    // Import necessário
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IOFilePersistence implements IFilePersistence {

    private final String baseDir;
    private final String fullPath;

    public IOFilePersistence(String fileName) {
        // Define o diretório base
        this.baseDir = System.getProperty("user.dir") + File.separator + "data";
        // Cria o caminho completo do arquivo de forma segura
        this.fullPath = baseDir + File.separator + fileName;

        File directory = new File(baseDir);
        File file = new File(fullPath);

        try {
            // Cria o diretório se não existir
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Cria o arquivo se não existir
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String write(final String data) {
        // FileWriter com 'true' no construtor ativa o modo APPEND (adicionar ao final)
        try (FileWriter fw = new FileWriter(fullPath, true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)) {

            out.println(data);

        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao escrever: " + e.getMessage();
        }
        return "Dados escritos com IO: " + data;
    }

    @Override
    public boolean removeContent(final String sentence) {
        List<String> lines = readFileLines();
        boolean removed = false;

        // Filtra removendo a linha exata (ou que contém a sentença, conforme lógica desejada)
        List<String> newContent = new ArrayList<>();
        for (String line : lines) {
            if (!line.contains(sentence)) {
                newContent.add(line);
            } else {
                removed = true;
            }
        }

        if (removed) {
            rewriteFile(newContent);
            return true;
        }
        return false;
    }

    @Override
    public String replace(final String oldContent, final String newContent) {
        List<String> lines = readFileLines();
        boolean replaced = false;

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains(oldContent)) {
                // Substitui a linha antiga pela nova (pode usar replace da String se quiser substituição parcial)
                lines.set(i, lines.get(i).replace(oldContent, newContent));
                replaced = true;
            }
        }

        if (replaced) {
            rewriteFile(lines);
            return "Conteúdo substituído.";
        }
        return "Conteúdo não encontrado.";
    }

    @Override
    public String findAll() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fullPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String findBy(final String sentence) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fullPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(sentence)) {
                    return line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método auxiliar para ler todas as linhas em uma Lista
    private List<String> readFileLines() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fullPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    // Método auxiliar para reescrever o arquivo do zero (usado no remove e replace)
    private void rewriteFile(List<String> lines) {
        try (FileWriter fw = new FileWriter(fullPath, false); // false = sobrescrever
                 BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)) {

            for (String line : lines) {
                out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
