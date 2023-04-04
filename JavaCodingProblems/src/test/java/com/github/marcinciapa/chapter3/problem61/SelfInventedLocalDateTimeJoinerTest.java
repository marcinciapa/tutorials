package com.github.marcinciapa.chapter3.problem61;

class SelfInventedLocalDateTimeJoinerTest extends LocalDateTimeJoinerTest<SelfInventedLocalDateTimeJoiner> {

    @Override
    SelfInventedLocalDateTimeJoiner createInstance() {
        return new SelfInventedLocalDateTimeJoiner();
    }
}
