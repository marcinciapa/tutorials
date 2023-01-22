package com.github.marcinciapa.chapter1.problem18;

class SelfInventedAnagramDiscovererTest extends AnagramDiscovererTest<SelfInventedAnagramDiscoverer> {

    @Override
    SelfInventedAnagramDiscoverer createInstance() {
        return new SelfInventedAnagramDiscoverer();
    }
}
