package com.github.marcinciapa.chapter2.problem45;

import java.util.List;

class SelfInventedListWrapperTest extends ListWrapperTest<SelfInventedListWrapper> {

    @Override
    SelfInventedListWrapper wrap(List<?> listToWrap) {
        return new SelfInventedListWrapper(listToWrap);
    }
}
