package io.gatling.jsonbenchmark.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;

/**
 * Created by Richard on 4/18/14.
 */
public class MainJavaSerialization {


    private Object serialize(AllTypes allTypes) throws Exception {

        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream serializer = new ObjectOutputStream(outputStream);

        allTypes.setMyLong ( System.currentTimeMillis () );

        serializer.writeObject(allTypes);
        return outputStream.toByteArray();
    }



    private Object roundTrip(AllTypes alltype) throws Exception {


        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream serializer = new ObjectOutputStream(outputStream);



        serializer.writeObject(alltype);


        final ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        ObjectInputStream inputSerializer = new ObjectInputStream(inputStream);
        return inputSerializer.readObject ();
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
