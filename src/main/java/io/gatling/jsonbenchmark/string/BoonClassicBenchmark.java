package io.gatling.jsonbenchmark.string;

import org.boon.json.JsonParser;
import org.boon.json.implementation.JsonParserCharArray;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OperationsPerInvocation;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.BlackHole;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.gatling.jsonbenchmark.bytes.Buffers.*;
import static io.gatling.jsonbenchmark.bytes.Buffers.STR_WIDGET_BYTES;


@State
public class BoonClassicBenchmark {

    private final JsonParser parser = new JsonParserCharArray (  );

    private Object parse(String str) throws Exception {
        return parser.parse ( str );
    }



    @GenerateMicroBenchmark
    @OutputTimeUnit ( TimeUnit.SECONDS)
    public void actionLabel(BlackHole bh) throws Exception {
        bh.consume(parse(STR_ACTION_LABEL_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void citmCatalog(BlackHole bh) throws Exception {
        bh.consume(parse(STR_CITM_CATALOG_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void medium(BlackHole bh) throws Exception {
        bh.consume(parse(STR_MEDIUM_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void menu(BlackHole bh) throws Exception {
        bh.consume(parse(STR_MENU_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void sgml(BlackHole bh) throws Exception {
        bh.consume(parse(STR_SGML_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void small(BlackHole bh) throws Exception {
        bh.consume(parse(STR_SMALL_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void webxml(BlackHole bh) throws Exception {
        bh.consume(parse(STR_WEBXML_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void widget(BlackHole bh) throws Exception {
        bh.consume(parse(STR_WIDGET_BYTES));
    }
}

