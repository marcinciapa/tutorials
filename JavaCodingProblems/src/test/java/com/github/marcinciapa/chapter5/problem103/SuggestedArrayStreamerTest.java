package com.github.marcinciapa.chapter5.problem103;

class SuggestedArrayStreamerTest extends ArrayStreamerTest<SuggestedArrayStreamer> {

    @Override
    SuggestedArrayStreamer streamer(int[] array) {
        return new SuggestedArrayStreamer(array);
    }
}
