package com.github.marcinciapa._3;

import java.util.StringTokenizer;

import static java.util.Objects.isNull;

class SuggestedLettersReverser {

    private final String WORDS_DELIMITER = " ";
    private final boolean TOKENIZE_DELIMITER = true;

    String reverseLettersInWords(String inputString) {
        if(isNull(inputString)) {
            return null;
        }

        StringTokenizer wordsTokens = new StringTokenizer(inputString, WORDS_DELIMITER, TOKENIZE_DELIMITER);
        StringBuilder revertedWordsBuilder = new StringBuilder();
        while(wordsTokens.hasMoreTokens()) {
            String word = wordsTokens.nextToken();
            String revertedWord = revertLetters(word);
            revertedWordsBuilder.append(revertedWord);
        }
        return revertedWordsBuilder.toString();
    }

    private static String revertLetters(String word) {
        StringBuilder revertedWordBuilder = new StringBuilder();
        for(char letter : word.toCharArray()) {
            revertedWordBuilder.append(letter);
        }
        return revertedWordBuilder.reverse().toString();
    }

}
