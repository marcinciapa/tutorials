package com.github.marcinciapa._19;

class SelfInventedTextBlockProvider implements TextBlockProvider {

    @Override
    public String provideTextBlock() {
        return """
                This
                is
                a
                multiline
                string""";
    }
}
