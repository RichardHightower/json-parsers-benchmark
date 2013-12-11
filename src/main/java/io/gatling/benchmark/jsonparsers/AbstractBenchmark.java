package io.gatling.benchmark.jsonparsers;

import static io.gatling.benchmark.jsonparsers.Bytes.*;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.BlackHole;

@OutputTimeUnit(TimeUnit.SECONDS)
public abstract class AbstractBenchmark {

    @State(Scope.Thread)
    public static class ThreadState {
        private int i = -1;

        public int next() {
            i++;
            if (i == ALL_BYTES.length)
                i = 0;
            return i;
        }
    }

    protected abstract Object parse(byte[] bytes) throws Exception;

    @GenerateMicroBenchmark
    public void roundRobin(ThreadState state, BlackHole bh) throws Exception {
        byte[] bytes = ALL_BYTES[state.next()];
        bh.consume(parse(bytes));
    }
}
