package io.gatling.jsonbenchmark.inputStream;

import io.gatling.jsonbenchmark.bytes.Buffers;
import org.boon.json.JsonParser;
import org.boon.json.implementation.JsonUTF8Parser;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.BlackHole;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * Created by Richard on 5/9/14.
 */
@State
public class BoonUTF8BenchMark {

    private final JsonParser parser = new JsonUTF8Parser();


    private Object parse(InputStream stream) throws Exception {
        return parser.parse (  stream  );
    }



    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void actionLabel(BlackHole bh) throws Exception {
        bh.consume(parse(new ByteArrayInputStream(Buffers.ACTION_LABEL_BYTES)));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void citmCatalog(BlackHole bh) throws Exception {

        bh.consume(parse(new ByteArrayInputStream(Buffers.CITM_CATALOG_BYTES)));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void medium(BlackHole bh) throws Exception {
        bh.consume(parse(new ByteArrayInputStream(Buffers.MEDIUM_BYTES)));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void menu(BlackHole bh) throws Exception {

        bh.consume(parse(new ByteArrayInputStream(Buffers.MENU_BYTES)));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void sgml(BlackHole bh) throws Exception {

        bh.consume(parse(new ByteArrayInputStream(Buffers.SGML_BYTES)));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void webxml(BlackHole bh) throws Exception {

        bh.consume(parse(new ByteArrayInputStream(Buffers.WEBXML_BYTES)));

    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void widget(BlackHole bh) throws Exception {
        bh.consume(parse(new ByteArrayInputStream(Buffers.WIDGET_BYTES)));

    }



}
