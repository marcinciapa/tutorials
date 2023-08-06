package com.github.marcinciapa.chapter5.problem115;

class TreeMapKeySorterTest extends MapKeySorterTest<TreeMapKeySorter> {

    @Override
    TreeMapKeySorter sorter() {
        return new TreeMapKeySorter();
    }
}
