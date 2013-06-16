package org.emamotor.java.jcip.chap01;

import org.emamotor.java.jcip.annotations.NotThreadSafe;

/**
 * UnsafeSequence
 */
@NotThreadSafe
public class UnsafeSequence {

    private int _nextValue;

    /* 重複のない数を返す */
    public int getNext() {
        return _nextValue++;
    }

}
