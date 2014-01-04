package io.gatling.jsonbenchmark.serialization;

import org.boon.json.JsonParser;
import org.boon.json.JsonParserFactory;
import org.boon.json.JsonSerializer;
import org.boon.json.JsonSerializerFactory;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;




@State
public class BoonPropertySerializer {

    private final JsonSerializer serializer = new JsonSerializerFactory().usePropertyOnly().create();
    private final JsonParser parser = new JsonParserFactory().create();



    private Object serialize(AllTypes alltype) throws Exception {
        alltype.setMyLong ( System.currentTimeMillis () );
        return serializer.serialize ( alltype );
    }

    private Object roundTrip(AllTypes alltype) throws Exception {
        return parser.parse ( AllTypes.class, serializer.serialize ( alltype ).readForRecycle () );
    }


    @GenerateMicroBenchmark
    @OutputTimeUnit ( TimeUnit.SECONDS)
    public void serializeSmall(BlackHole bh) throws Exception {
        bh.consume(serialize(TestObjects.OBJECT));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void roundTriper(BlackHole bh) throws Exception {
        bh.consume(roundTrip ( TestObjects.OBJECT ));
    }

}
