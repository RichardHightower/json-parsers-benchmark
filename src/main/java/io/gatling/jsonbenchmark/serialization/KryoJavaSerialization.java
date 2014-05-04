package io.gatling.jsonbenchmark.serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.boon.Exceptions;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.BlackHole;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.TimeUnit;


@State
public class KryoJavaSerialization {

    /**
     * Kryo valueObjectConverter/valueSerializer
     */
    private final Kryo kryo = new Kryo();




    private Object serialize(AllTypes allTypes) throws Exception {


        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();


        Output streamOut = new Output(outputStream);
        this.kryo.writeObject(streamOut, allTypes);
        streamOut.close();

        return outputStream.toByteArray();
    }



    private Object roundTrip(AllTypes alltype) throws Exception {


        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();


        Output streamOut = new Output(outputStream);
        this.kryo.writeObject(streamOut, alltype);
        streamOut.close();


        final ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        Input input = new Input(inputStream);

        return kryo.readObject(input, AllTypes.class);
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
