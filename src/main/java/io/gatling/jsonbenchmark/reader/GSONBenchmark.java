
package io.gatling.jsonbenchmark.reader;

import java.io.Reader;
import java.io.StringReader;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.gatling.jsonbenchmark.bytes.Buffers;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

import com.google.gson.Gson;

public class GSONBenchmark {

    private static final Gson GSON = new Gson();

    private Object parse(Reader reader) throws Exception {

            return GSON.fromJson(reader , Map.class);
    }



    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void actionLabel(BlackHole bh) throws Exception {
        bh.consume(parse(new StringReader(Buffers.STR_ACTION_LABEL_BYTES)));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void citmCatalog(BlackHole bh) throws Exception {
        bh.consume(parse(new StringReader(Buffers.STR_CITM_CATALOG_BYTES)));

    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void medium(BlackHole bh) throws Exception {

        bh.consume(parse(new StringReader(Buffers.STR_MEDIUM_BYTES)));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void menu(BlackHole bh) throws Exception {
        bh.consume(parse(new StringReader(Buffers.STR_MENU_BYTES)));

    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void sgml(BlackHole bh) throws Exception {
        bh.consume(parse(new StringReader(Buffers.STR_MENU_BYTES)));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void webxml(BlackHole bh) throws Exception {
        bh.consume(parse(new StringReader(Buffers.STR_WEBXML_BYTES)));

    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void widget(BlackHole bh) throws Exception {
        bh.consume(parse(new StringReader(Buffers.STR_WIDGET_BYTES)));

    }

}
