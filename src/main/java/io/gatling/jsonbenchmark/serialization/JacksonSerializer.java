package io.gatling.jsonbenchmark.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

import java.io.StringWriter;
import java.util.concurrent.TimeUnit;

import static org.boon.Boon.puts;

/**
 * Created by rick on 12/27/13.
 */
public class JacksonSerializer {

    private static final ObjectMapper serializer = new ObjectMapper();

    private Object serialize(AllTypes allTypes) throws Exception {
        allTypes.setMyLong ( System.currentTimeMillis () );

        StringWriter stringWriter = new StringWriter (  );

        serializer.writeValue (stringWriter,  allTypes );
        return stringWriter.toString ();
    }



    private Object roundTrip(AllTypes alltype) throws Exception {
        StringWriter stringWriter = new StringWriter (  );
        serializer.writeValue ( stringWriter, alltype );
        return serializer.readValue (stringWriter.toString (),  AllTypes.class);
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
