package io.gatling.jsonbenchmark.serialization;

import org.boon.json.*;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;


@State
public class MainBoonSerializer {


    private final JsonSerializer serializer = new JsonSerializerFactory().useFieldsOnly().create();
    private final JsonParserAndMapper parser = new JsonParserFactory().create();



    private Object serialize(AllTypes alltype) throws Exception {
        alltype.setMyLong ( System.currentTimeMillis () );
        return serializer.serialize ( alltype );
    }

    private Object roundTrip(AllTypes alltype) throws Exception {
        return parser.parse ( AllTypes.class, serializer.serialize( alltype ).readForRecycle() );
    }


    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void serializeSmall(BlackHole bh) throws Exception {
        bh.consume(serialize(TestObjects.OBJECT));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void roundTriper(BlackHole bh) throws Exception {
        bh.consume(roundTrip ( TestObjects.OBJECT ));
    }





    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void serializeBig(BlackHole bh) throws Exception {
        bh.consume(serialize(TestObjects.BIG_OBJECT));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void roundTripBig(BlackHole bh) throws Exception {
        bh.consume(roundTrip ( TestObjects.BIG_OBJECT ));
    }

}
