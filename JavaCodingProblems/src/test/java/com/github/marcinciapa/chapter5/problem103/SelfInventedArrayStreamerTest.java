package com.github.marcinciapa.chapter5.problem103;

class SelfInventedArrayStreamerTest extends ArrayStreamerTest<SelfInventedArrayStreamer> {

    @Override
    SelfInventedArrayStreamer streamer(int[] array) {
        return new SelfInventedArrayStreamer(array);
    }
}
