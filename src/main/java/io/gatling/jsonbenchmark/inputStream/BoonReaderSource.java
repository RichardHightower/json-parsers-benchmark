
package io.gatling.jsonbenchmark.inputStream;

import java.nio.file.Files;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.boon.IO;
import org.boon.json.JsonParser;
import org.boon.json.JsonParserFactory;
import org.boon.json.implementation.JsonParserUsingCharacterSource;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.BlackHole;

@State
public class BoonReaderSource {

    public static final String STR_ACTION_LABEL_BYTES = ( "data/actionLabel.json" );
    public static final String STR_CITM_CATALOG_BYTES = ( "data/citm_catalog.json" );
    public static final String STR_MEDIUM_BYTES = ( "data/medium.json" );
    public static final String STR_MENU_BYTES = ( "data/menu.json" );
    public static final String STR_SGML_BYTES = ( "data/sgml.json" );
    public static final String  STR_SMALL_BYTES = ( "data/small.json" );
    public static final String STR_WEBXML_BYTES = ( "data/webxml.json" );
    public static final String STR_WIDGET_BYTES = ( "data/widget.json" );



    private final JsonParser parser = new JsonParserUsingCharacterSource(  );

    private Object parse(String str) throws Exception {
        return parser.parse (  Files.newInputStream ( IO.path (str) ) );
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
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
    public void webxml(BlackHole bh) throws Exception {
        bh.consume(parse(STR_WEBXML_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void widget(BlackHole bh) throws Exception {
        bh.consume(parse(STR_WIDGET_BYTES));
    }
}
