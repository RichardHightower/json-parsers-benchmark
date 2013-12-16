package io.gatling.jsonbenchmark.bufferofchoice;

import org.boon.json.JsonParser;
import org.boon.json.implementation.JsonParserCharArray;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.BlackHole;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.gatling.jsonbenchmark.bytes.Buffers.*;

@State
public class BoonCharDoingBytes {



    private final JsonParser parser = new JsonParserCharArray ();

    private Object parse( byte[] bytes ) throws Exception {
        return parser.parse ( Map.class, bytes );
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit ( TimeUnit.SECONDS )
    public void actionLabel( BlackHole bh ) throws Exception {
        bh.consume ( parse ( ACTION_LABEL_BYTES ) );
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit( TimeUnit.SECONDS )
    public void citmCatalog( BlackHole bh ) throws Exception {
        bh.consume ( parse ( CITM_CATALOG_BYTES ) );
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit( TimeUnit.SECONDS )
    public void medium( BlackHole bh ) throws Exception {
        bh.consume ( parse ( MEDIUM_BYTES ) );
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit( TimeUnit.SECONDS )
    public void menu( BlackHole bh ) throws Exception {
        bh.consume ( parse ( MENU_BYTES ) );
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit( TimeUnit.SECONDS )
    public void sgml( BlackHole bh ) throws Exception {
        bh.consume ( parse ( SGML_BYTES ) );
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit( TimeUnit.SECONDS )
    public void small( BlackHole bh ) throws Exception {
        bh.consume ( parse ( SMALL_BYTES ) );
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit( TimeUnit.SECONDS )
    public void webxml( BlackHole bh ) throws Exception {
        bh.consume ( parse ( WEBXML_BYTES ) );
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit( TimeUnit.SECONDS )
    public void widget( BlackHole bh ) throws Exception {
        bh.consume ( parse ( WIDGET_BYTES ) );
    }
}

