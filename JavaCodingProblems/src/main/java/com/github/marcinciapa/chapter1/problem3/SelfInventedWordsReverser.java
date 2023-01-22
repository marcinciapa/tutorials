package com.github.marcinciapa.chapter1.problem3;

import java.util.Stack;
import java.util.StringTokenizer;

import static java.util.Objects.isNull;

class SelfInventedWordsReverser {

    private static final String WORDS_DELIMITER = " ";
    private static final boolean TOKENIZE_DELIMITERS = true;

    String reverseWordsInString(String inputString) {
        if(isNull(inputString)) {
            return null;
        }

        StringTokenizer wordsTokenizer = new StringTokenizer(inputString, WORDS_DELIMITER, TOKENIZE_DELIMITERS);

        Stack<String> wordsStack = stackWords(wordsTokenizer);
        return rejoinStackedWords(wordsStack);

    }

    private static String rejoinStackedWords(Stack<String> wordsStack) {
        StringBuilder outputString = new StringBuilder();
        while(!wordsStack.isEmpty()) {
            String word = wordsStack.pop();
            outputString.append(word);
        }
        return outputString.toString();
    }

    private static Stack<String> stackWords(StringTokenizer wordsTokenizer) {
        Stack<String> wordsStack = new Stack<>();
        while(wordsTokenizer.hasMoreTokens()) {
            wordsStack.push(wordsTokenizer.nextToken());
        }
        return wordsStack;
    }
}
