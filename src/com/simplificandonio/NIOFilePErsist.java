package com.simplificandonio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path; // Import necessário
import java.nio.file.Paths; // Import necessário
import java.nio.file.StandardOpenOption; // Import necessário
import java.util.List; // Import necessário
import java.util.stream.Collectors; // Import necessário

// Assumindo que FilePersistence é uma interface que você criou
public class NIOFilePersist implements FilePersistence {

    private final String currentDir = System.getProperty("user.dir");
    // Removi a barra inicial para evitar problemas se currentDir não terminar com barra
    private final String storedDir = "/managedFiles/NIO/";
    private final String fileName;

    // Transformei 'path' em atributo da classe para ser usado no clearFile()
    private final Path path;

    public NIOFilePersist(final String fileName) {
        this.fileName = fileName;
        // Forma mais segura de criar caminhos:
        this.path = Paths.get(currentDir, storedDir, fileName);

        // Lógica corrigida: Se NÃO existe, cria.
        if (!Files.exists(path)) {
            try {
                // Cria diretórios pais se não existirem
                Files.createDirectories(path.getParent());
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException("Não foi possível criar o diretório ou arquivo: " + e.getMessage(), e);
            }
        }
    }

    @Override
    public String write(final String data) {
        try {
            // StandardOpenOption.CREATE garante que cria se foi deletado acidentalmente
            Files.writeString(path, data + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever no arquivo: " + e.getMessage(), e);
        }
        return "Dados escritos com NIO: " + data;
    }

    @Override
    public boolean remove(final String identifier) {
        var content = toListString(); // Agora este método existe (veja abaixo)

        var contentList = content.stream()
                .filter(line -> !line.contains(identifier))
                .collect(Collectors.toList());

        clearFile();
        contentList.forEach(this::write);
        return true;
    }

    @Override
    public String replace(final String identifier, final String newData) {
        var content = toListString();

        if (content.stream().anyMatch(line -> line.contains(identifier))) {
            var updatedContent = content.stream()
                    .map(line -> line.contains(identifier) ? newData : line)
                    .collect(Collectors.toList());

            clearFile();
            updatedContent.forEach(this::write);
        }
        return "Dados substituídos com NIO: " + newData;
    }

    @Override
    public String findAll() {
        StringBuilder content = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo: " + e.getMessage(), e);
        }
        return content.toString();
    }

    @Override
    public String findById(final String identifier) {
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                if (line.contains(identifier)) {
                    return line;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo: " + e.getMessage(), e);
        }
        return null;
    }

    // Método auxiliar adicionado para corrigir o erro de compilação
    private List<String> toListString() {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler lista do arquivo: " + e.getMessage(), e);
        }
    }

    private void clearFile() {
        try {
            // Agora 'path' é visível aqui porque é um atributo da classe
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao limpar o arquivo: " + e.getMessage(), e);
        }
    }
}
