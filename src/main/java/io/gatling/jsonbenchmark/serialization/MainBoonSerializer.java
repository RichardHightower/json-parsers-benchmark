package io.gatling.jsonbenchmark.serialization;

import data.media.MediaContent;
import io.gatling.jsonbenchmark.serialization.model.StringPerformance;
import org.boon.core.Sys;
import org.boon.json.*;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;


@State
public class MainBoonSerializer {


    private final JsonSerializer serializer = new JsonSerializerFactory()
            .setSerializeAsSupport(false).useFieldsOnly().create();
    private final JsonParserAndMapper parser = new JsonParserFactory().create();

    private static Object object = Sys.contextToHold();



    private Object serialize(AllTypes alltype) throws Exception {
        return serializer.serialize ( alltype );
    }

    private Object roundTrip(AllTypes alltype) throws Exception {
        return parser.parse ( AllTypes.class, serializer.serialize( alltype ).readForRecycle() );
    }



    private Object roundTrip(Class<?> cls, Object object) throws Exception {
        return parser.parse ( cls, serializer.serialize( object ).toString() );
    }

    private Object mediaContentRoundTrip(MediaContent mediaContent) throws Exception {
        return parser.parse ( MediaContent.class, serializer.serialize( mediaContent ).readForRecycle() );
    }


    private Object parseOnly(String json) throws Exception {

        return parser.parse( json );
    }



    private Object serializeOnly(Object object) throws Exception {

        return serializer.serialize( object );
    }


    private Object mediaContentOutput(MediaContent mediaContent) throws Exception {
        return serializer.serialize( mediaContent );
    }



    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void mediaContentRoundTrip(BlackHole bh) throws Exception {
        bh.consume(mediaContentRoundTrip ( TestObjects.MEDIA_CONTENT ));
    }


    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void mediaContentOutput(BlackHole bh) throws Exception {
        bh.consume(mediaContentOutput ( TestObjects.MEDIA_CONTENT ));
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



    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void stringPerf(BlackHole bh) throws Exception {
        bh.consume(roundTrip (StringPerformance.class, TestObjects.STRING_PERF ));
    }


    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void stringPerfParser(BlackHole bh) throws Exception {
        bh.consume(parseOnly (TestObjects.STRING_PERF_STRING ));
    }


    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void stringPerfSerializer(BlackHole bh) throws Exception {
        bh.consume(serializeOnly (TestObjects.STRING_PERF));
    }

}
