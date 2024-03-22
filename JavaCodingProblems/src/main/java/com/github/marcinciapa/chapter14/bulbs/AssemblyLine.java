package com.github.marcinciapa.chapter14.bulbs;

import java.util.Collection;

public interface AssemblyLine {

    Collection<Bulb> assembly(Collection<? extends Bulb> bulbs);
}
