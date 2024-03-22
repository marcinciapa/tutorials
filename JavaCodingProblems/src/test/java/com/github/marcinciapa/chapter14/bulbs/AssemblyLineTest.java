package com.github.marcinciapa.chapter14.bulbs;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AssemblyLineTest<T extends AssemblyLine> {

    protected abstract T assemblyLine();

    @Test
    void shouldAssemblyBulbs() {
        // given
        List<? extends Bulb> bulbs = IntStream.range(0, 100)
                .mapToObj(NewBulb::new)
                .toList();

        // when
        Collection<Bulb> assembledBulbs = assemblyLine().assembly(bulbs);

        // then
        assertEquals(100, assembledBulbs.size());
        assembledBulbs.forEach((bulb) -> {
            assertTrue(bulb.isChecked());
            assertTrue(bulb.isPacked());
        });
    }
}