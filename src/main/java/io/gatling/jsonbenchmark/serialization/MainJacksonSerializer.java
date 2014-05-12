package io.gatling.jsonbenchmark.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.media.MediaContent;
import io.gatling.jsonbenchmark.serialization.model.StringPerformance;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * Created by rick on 12/27/13.
 */
public class MainJacksonSerializer {

    private static final ObjectMapper serializer = new ObjectMapper();

    private Object serialize(AllTypes allTypes) throws Exception {

        return serializer.writeValueAsString( allTypes );
    }



    private Object roundTrip(AllTypes alltype) throws Exception {
        String string = serializer.writeValueAsString( alltype );
        return serializer.readValue (string,  AllTypes.class);
    }

    private Object mediaContentRoundTrip(MediaContent mediaContent) throws Exception {
        String string = serializer.writeValueAsString( mediaContent );
        return serializer.readValue (string,  MediaContent.class);

    }

    private Object mediaContentOutput(MediaContent mediaContent) throws Exception {
        return serializer.writeValueAsString( mediaContent );
    }


    private Object roundTrip(Class<?> cls, Object object) throws Exception {
        String string = serializer.writeValueAsString( object );
        return serializer.readValue (string,  cls);
    }


    private Object parseOnly(String json) throws Exception {

        return serializer.readValue(json, StringPerformance.class);
    }



    private Object serializeOnly(Object object) throws Exception {

        return serializer.writeValueAsString( object );
    }


    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void mediaContentOutput(BlackHole bh) throws Exception {
        bh.consume(mediaContentOutput ( TestObjects.MEDIA_CONTENT ));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void mediaContentRoundTrip(BlackHole bh) throws Exception {
        bh.consume(mediaContentRoundTrip ( TestObjects.MEDIA_CONTENT ));
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
