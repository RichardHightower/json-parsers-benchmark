package io.gatling.jsonbenchmark.serialization;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;

public class JacksonByteArraySerializer {

    private static final ObjectMapper serializer = new ObjectMapper();

    private Object serialize(AllTypes allTypes) throws Exception {

        return serializer.writeValueAsBytes( allTypes );
    }



    private Object roundTrip(AllTypes alltype) throws Exception {
        byte[] bytes = serializer.writeValueAsBytes( alltype );
        return serializer.readValue (bytes,  AllTypes.class);
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
