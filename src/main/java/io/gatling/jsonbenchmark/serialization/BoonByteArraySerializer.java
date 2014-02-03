package io.gatling.jsonbenchmark.serialization;


import org.boon.json.*;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.BlackHole;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

@State
public class BoonByteArraySerializer {

    private final JsonSerializer serializer = new JsonSerializerFactory().useFieldsOnly().create ();
    private final JsonParserAndMapper parser = new JsonParserFactory().create();



    private Object serialize(AllTypes alltype) throws Exception {
        alltype.setMyLong ( System.currentTimeMillis () );
        return serializer.serialize ( alltype ).toString ().getBytes ( StandardCharsets.UTF_8 );
    }

    private Object roundTrip(AllTypes alltype) throws Exception {
        return parser.parse ( AllTypes.class, serializer.serialize( alltype ).toString().getBytes(StandardCharsets.UTF_8) );
    }


    @GenerateMicroBenchmark
    @OutputTimeUnit( TimeUnit.SECONDS)
    public void serializeSmall(BlackHole bh) throws Exception {
        bh.consume(serialize(TestObjects.OBJECT));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void roundTriper(BlackHole bh) throws Exception {
        bh.consume(roundTrip ( TestObjects.OBJECT ));
    }


}
