package io.gatling.jsonbenchmark.bufferofchoice;

import org.boon.json.JsonParser;
import org.boon.json.JsonParserFactory;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.BlackHole;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.gatling.jsonbenchmark.bytes.Buffers.*;
import static io.gatling.jsonbenchmark.bytes.Buffers.CHR_WIDGET_BYTES;

/**
 * Created by rick on 12/12/13.
 */
@State
public class BoonBenchMarkLax {

        private final JsonParser parser = new JsonParserFactory ()
                .lax().create ();

        private Object parse(char[] chars) throws Exception {
            return parser.parse ( Map.class, chars );
        }

        @GenerateMicroBenchmark
        @OutputTimeUnit ( TimeUnit.SECONDS)
        public void actionLabel(BlackHole bh) throws Exception {
            bh.consume(parse(CHR_ACTION_LABEL_BYTES));
        }

        @GenerateMicroBenchmark
        @OutputTimeUnit(TimeUnit.SECONDS)
        public void citmCatalog(BlackHole bh) throws Exception {
            bh.consume(parse(CHR_CITM_CATALOG_BYTES));
        }

        @GenerateMicroBenchmark
        @OutputTimeUnit(TimeUnit.SECONDS)
        public void medium(BlackHole bh) throws Exception {
            bh.consume(parse(CHR_MEDIUM_BYTES));
        }

        @GenerateMicroBenchmark
        @OutputTimeUnit(TimeUnit.SECONDS)
        public void menu(BlackHole bh) throws Exception {
            bh.consume(parse(CHR_MENU_BYTES));
        }

        @GenerateMicroBenchmark
        @OutputTimeUnit(TimeUnit.SECONDS)
        public void sgml(BlackHole bh) throws Exception {
            bh.consume(parse(CHR_SGML_BYTES));
        }

        @GenerateMicroBenchmark
        @OutputTimeUnit(TimeUnit.SECONDS)
        public void small(BlackHole bh) throws Exception {
            bh.consume(parse(CHR_SMALL_BYTES));
        }

        @GenerateMicroBenchmark
        @OutputTimeUnit(TimeUnit.SECONDS)
        public void webxml(BlackHole bh) throws Exception {
            bh.consume(parse(CHR_WEBXML_BYTES));
        }

        @GenerateMicroBenchmark
        @OutputTimeUnit(TimeUnit.SECONDS)
        public void widget(BlackHole bh) throws Exception {
            bh.consume(parse(CHR_WIDGET_BYTES));
        }
    }
