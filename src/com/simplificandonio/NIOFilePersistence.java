package com.simplificandonio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NIOFilePersistence implements FilePersistence {

    private final String currentDir = System.getProperty("user.dir");
    private final String storedDir = "/managedFiles/IO/";
    private final String fileName;

    public NIOFilePersistence(final String fileName) {
        this.fileName = fileName;
        var file = new File(currentDir + storedDir);

        // Verifica se o diretório existe, se não, tenta criar
        if (!file.exists() && !file.mkdirs()) {
            throw new RuntimeException("Não foi possível criar o diretório: " + file.getPath());
            // A linha clearFile() foi removida pois era inalcançável aqui
        }
    }

    @Override
    public String write(final String data) {
        // Uso de RandomAccessFile com Channel
        try (var file = new RandomAccessFile(new File(currentDir + storedDir + fileName), "rw"); FileChannel channel = file.getChannel()) {

            // Move o cursor para o final do arquivo para fazer append
            channel.position(channel.size());

            // Converte string para ByteBuffer corretamente
            byte[] bytes = (data + System.lineSeparator()).getBytes(StandardCharsets.UTF_8);
            ByteBuffer buffer = ByteBuffer.wrap(bytes);

            channel.write(buffer);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever no arquivo: " + e.getMessage(), e);
        }
        return "Dados escritos com NIO Channel: " + data;
    }

    @Override
    public boolean remove(final String identifier) {
        var content = toListString(); // Retorna List<String>

        // Filtra removendo o item desejado
        var filteredContent = content.stream()
                .filter(line -> !line.contains(identifier))
                .collect(Collectors.toList());

        clearFile();

        // Reescreve o arquivo
        filteredContent.forEach(this::write);

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
        File file = new File(currentDir + storedDir + fileName);
        if (!file.exists()) {
            return "";
        }

        try (var randomAccessFile = new RandomAccessFile(file, "r"); FileChannel channel = randomAccessFile.getChannel()) {

            // Cuidado: allocate com channel.size() pode falhar se o arquivo for maior que 2GB (Integer.MAX_VALUE)
            ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());

            channel.read(buffer);
            buffer.flip(); // Prepara o buffer para leitura (leitura dos dados que foram escritos nele)

            // Converte os bytes do buffer para String usando UTF-8 para não quebrar acentos
            return new String(buffer.array(), StandardCharsets.UTF_8);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo: " + e.getMessage(), e);
        }
    }

    // Assumi que o nome na interface é findById
    @Override
    public String findById(final String identifier) {
        // Reutilizando findAll para evitar duplicação de lógica de leitura de Channel
        // Ler o arquivo inteiro para achar uma linha não é o mais eficiente para arquivos gigantes,
        // mas para este exemplo funciona bem.
        String content = findAll();

        if (content.contains(identifier)) {
            // Retorna a linha específica ou apenas a mensagem de sucesso conforme seu código original
            return "Dado encontrado com NIO: " + identifier;
        }

        return "Dado não encontrado com NIO: " + identifier;
    }

    private List<String> toListString() {
        var content = findAll();
        if (content.isEmpty()) {
            return List.of();
        }
        // Split correto da String retornada pelo findAll
        return Stream.of(content.split(System.lineSeparator()))
                .collect(Collectors.toList());
    }

    private void clearFile() {
        var file = new File(currentDir + storedDir + fileName);
        if (file.exists() && !file.delete()) {
            throw new RuntimeException("Não foi possível limpar o arquivo: " + file.getPath());
        }
        // Cria um novo arquivo vazio imediatamente para evitar erros de leitura subsequentes
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao recriar arquivo vazio: " + e.getMessage());
        }
    }
}
