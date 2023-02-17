package com.github.marcinciapa.chapter1.problem39;

import java.text.NumberFormat;

import static java.math.RoundingMode.UP;
import static java.text.NumberFormat.Style.SHORT;
import static java.text.NumberFormat.getCompactNumberInstance;
import static java.util.Locale.ITALIAN;
import static java.util.Locale.US;

class SelfInventedNumberFormatter implements NumberFormatter {

    @Override
    public String formatShortAmerican(long number) {
        NumberFormat numberFormat = getCompactNumberInstance(US, SHORT);
        numberFormat.setRoundingMode(UP);
        return numberFormat.format(number);
    }

    @Override
    public String formatShortItalian(long number) {
        NumberFormat numberFormat = getCompactNumberInstance(ITALIAN, SHORT);
        numberFormat.setRoundingMode(UP);
        return numberFormat.format(number);
    }
}
