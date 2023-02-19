package com.github.marcinciapa.chapter1.problem39;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import static java.util.Objects.isNull;

class SelfInventedNumberParser implements NumberParser {

    @Override
    public Number parseShortAmerican(String number) {
        NumberFormat parser = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        parser.setGroupingUsed(true);
        return parse(number, parser);
    }

    @Override
    public Number parseShortItalian(String number) {
        NumberFormat parser = NumberFormat.getCompactNumberInstance(Locale.ITALIAN, NumberFormat.Style.SHORT);
        parser.setGroupingUsed(true);
        return parse(number, parser);
    }

    private Number parse(String number, NumberFormat parser) {
        if (isNull(number)) {
            throw new IllegalArgumentException();
        }
        try {
            return parser.parse(number);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
