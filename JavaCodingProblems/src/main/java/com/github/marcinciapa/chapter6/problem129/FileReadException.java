package com.github.marcinciapa.chapter6.problem129;

public class FileReadException extends Exception {

    public FileReadException(String fileName) {
        super("File %s doesn't exist".formatted(fileName));
    }
}
