package org.emamotor.java.jcip.chap01;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.*;

/**
 * Sequence のテスト
 *
 * @author emag
 */
public class SequenceTest {

    private static final int THREAD_NUM = 2;
    private static final int COUNT_NUM  = 1_000;
    private static final int RESULT_NUM = COUNT_NUM * THREAD_NUM - 1;

    @Test
    public void スレッド2つからgetNextを呼び出しても値が重複しない() throws Exception {

        // SetUp
        Sequence sut = new Sequence();
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

        private Sequence _sequence;

        public CountTester(Sequence sequence) {
            _sequence = sequence;
        }

        @Override
        public void run() {
            for (int i = 0; i < COUNT_NUM; i++) {
                _sequence.getNext();
            }
        }

    }

}
