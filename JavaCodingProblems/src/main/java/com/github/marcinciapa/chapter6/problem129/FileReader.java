package com.github.marcinciapa.chapter6.problem129;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class FileReader {

    public String readFile(String path) throws FileReadException {
        Path filePath = Path.of(path);
        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            throw new FileReadException(path);
        }
    }
}
