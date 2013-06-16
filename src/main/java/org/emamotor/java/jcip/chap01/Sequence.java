package org.emamotor.java.jcip.chap01;

import org.emamotor.java.jcip.annotations.GuardedBy;
import org.emamotor.java.jcip.annotations.ThreadSafe;

/**
 * Sequence
 */
@ThreadSafe
public class Sequence {

    @GuardedBy("this")
    private int _nextValue;

    public synchronized int getNext() {
        return _nextValue++;
    }

}
