package com.github.marcinciapa.chapter1.problem3;

import static java.util.Objects.isNull;

class SuggestedWordsReverser {

    private final SuggestedLettersReverser lettersReverser = new SuggestedLettersReverser();

    private final String WORDS_DELIMITER = " ";
    private final boolean TOKENIZE_DELIMITER = true;

    /* Reserve letters in words first and then reverse the entire string */
    String reverseWordsInString(String inputString) {
        if (isNull(inputString)) {
            return null;
        }

        String inputStringWithLettersInWordsReversed = lettersReverser.reverseLettersInWords(inputString);
        StringBuilder revertedString = new StringBuilder(inputStringWithLettersInWordsReversed);
        return revertedString.reverse().toString();


    }
}
