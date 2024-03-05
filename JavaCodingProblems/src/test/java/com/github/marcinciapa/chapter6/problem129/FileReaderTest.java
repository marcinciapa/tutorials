package com.github.marcinciapa.chapter6.problem129;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileReaderTest {

    public static final String PATH = "/Users/c4rb0n/Desktop/test";
    private final FileReader fileReader = new FileReader();

    @Test
    void shouldReadFileContent() throws IOException, FileReadException {
        // given
        File file = new File(PATH);
        file.createNewFile();
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("content");
        }
        // when
        String content = fileReader.readFile(PATH);

        // then
        assertEquals("content", content);
        file.delete();
    }

    @Test
    void shouldThrowExceptionWhenFileDoesNotExist() {
        assertThrows(FileReadException.class, () -> fileReader.readFile("nonExisting"));
    }
}
