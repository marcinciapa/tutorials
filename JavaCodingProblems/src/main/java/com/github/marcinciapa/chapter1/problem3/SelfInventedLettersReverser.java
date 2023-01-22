package com.github.marcinciapa.chapter1.problem3;

import java.util.Stack;
import java.util.StringTokenizer;

import static java.util.Objects.isNull;

class SelfInventedLettersReverser {

    private static final String WORDS_DELIMITER = " ";
    private static final boolean TOKENIZE_DELIMITERS = true;

    String reverseLettersInWords(String inputString) {
        if (isNull(inputString)) {
            return null;
        }

        StringBuilder outputString = new StringBuilder();

        StringTokenizer wordsTokenizer = new StringTokenizer(inputString, WORDS_DELIMITER, TOKENIZE_DELIMITERS);
        while (wordsTokenizer.hasMoreTokens()) {
            String nextWord = wordsTokenizer.nextToken();
            String wordWithInvertedLetters = invertLettersInWord(nextWord);
            outputString.append(wordWithInvertedLetters);
        }
        return outputString.toString();

    }

    private String invertLettersInWord(String word) {
        Stack<Character> lettersStack = stackLetters(word);
        return joinLetters(lettersStack);
    }

    private static String joinLetters(Stack<Character> lettersStack) {
        StringBuilder wordWithInvertedLetters = new StringBuilder();
        while (!lettersStack.isEmpty()) {
            wordWithInvertedLetters.append(lettersStack.pop());
        }
        return wordWithInvertedLetters.toString();
    }

    private static Stack<Character> stackLetters(String word) {
        Stack<Character> lettersStack = new Stack<>();
        for (Character character : word.toCharArray()) {
            lettersStack.push(character);
        }
        return lettersStack;
    }
}
