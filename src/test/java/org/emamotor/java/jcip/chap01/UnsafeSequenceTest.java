package org.emamotor.java.jcip.chap01;

import org.emamotor.java.jcip.annotations.UnstableTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.*;

/**
 * UnsafeSequence のテスト
 *
 * @author emag
 */
public class UnsafeSequenceTest {

    private static final int THREAD_NUM = 2;
    private static final int COUNT_NUM  = 1_000;
    private static final int RESULT_NUM = COUNT_NUM * THREAD_NUM - 1;

    @Ignore
    @Test
    @UnstableTest
    public void スレッド2つからgetNextで重複した値を得るため値が2倍にならない() throws Exception {

        // SetUp
        UnsafeSequence sut = new UnsafeSequence();
        Thread t1 = new CountTester(sut);
        Thread t2 = new CountTester(sut);

        // Exercise
        t1.start();
        t2.start();

        // 2つのスレッドが終わるまで待つ
        t1.join();
        t2.join();

        // Verify
        Assert.assertThat(sut.getNext() - 1, is(RESULT_NUM));

    }

    public static class CountTester extends Thread {

        private UnsafeSequence _unsafeSequence;

        public CountTester(UnsafeSequence unsafeSequence) {
            _unsafeSequence = unsafeSequence;
        }

        @Override
        public void run() {
            for (int i = 0; i < COUNT_NUM; i++) {
                _unsafeSequence.getNext();
            }
        }

    }
}
