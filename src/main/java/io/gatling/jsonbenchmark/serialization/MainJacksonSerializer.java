package io.gatling.jsonbenchmark.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.media.MediaContent;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

import java.io.StringWriter;
import java.util.concurrent.TimeUnit;

import static org.boon.Boon.puts;

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


}
