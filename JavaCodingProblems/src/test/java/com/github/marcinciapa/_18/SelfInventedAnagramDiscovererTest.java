package com.github.marcinciapa._18;

class SelfInventedAnagramDiscovererTest extends AnagramDiscovererTest<SelfInventedAnagramDiscoverer> {

    @Override
    SelfInventedAnagramDiscoverer createInstance() {
        return new SelfInventedAnagramDiscoverer();
    }
}
