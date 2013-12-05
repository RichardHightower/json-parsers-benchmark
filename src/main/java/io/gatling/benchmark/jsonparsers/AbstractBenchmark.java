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
    public void actionLabel(BlackHole bh) throws Exception {
        bh.consume(parse(ACTION_LABEL_BYTES));
    }

    @GenerateMicroBenchmark
    public void citmCatalog(BlackHole bh) throws Exception {
        bh.consume(parse(CITM_CATALOG_BYTES));
    }

    @GenerateMicroBenchmark
    public void medium(BlackHole bh) throws Exception {
        bh.consume(parse(MEDIUM_BYTES));
    }

    @GenerateMicroBenchmark
    public void menu(BlackHole bh) throws Exception {
        bh.consume(parse(MENU_BYTES));
    }

    @GenerateMicroBenchmark
    public void sgml(BlackHole bh) throws Exception {
        bh.consume(parse(SGML_BYTES));
    }

    @GenerateMicroBenchmark
    public void small(BlackHole bh) throws Exception {
        bh.consume(parse(SMALL_BYTES));
    }

    @GenerateMicroBenchmark
    public void webxml(BlackHole bh) throws Exception {
        bh.consume(parse(WEBXML_BYTES));
    }

    @GenerateMicroBenchmark
    public void widget(BlackHole bh) throws Exception {
        bh.consume(parse(WIDGET_BYTES));
    }

    @GenerateMicroBenchmark
    public void roundRobin(ThreadState state, BlackHole bh) throws Exception {
        byte[] bytes = ALL_BYTES[state.next()];
        bh.consume(parse(bytes));
    }
}
