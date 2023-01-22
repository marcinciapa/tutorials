package com.github.marcinciapa.chapter1.problem19;

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
