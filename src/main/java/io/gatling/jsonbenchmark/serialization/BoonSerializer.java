package io.gatling.jsonbenchmark.serialization;

import org.boon.json.JsonSerializer;
import org.boon.json.JsonSerializerFactory;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;


@State
public class BoonSerializer {

    JsonSerializer serializer = new JsonSerializerFactory( )
            .setUseAnnotations ( false ).includeEmpty ()
            .setHandleSimpleBackReference ( false ).create();


    private Object serialize(AllTypes alltype) throws Exception {
        alltype.setMyLong ( System.currentTimeMillis () );
        return serializer.serialize ( alltype );
    }



    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void serializeSmall(BlackHole bh) throws Exception {
        bh.consume(serialize(TestObjects.OBJECT));
    }

}
