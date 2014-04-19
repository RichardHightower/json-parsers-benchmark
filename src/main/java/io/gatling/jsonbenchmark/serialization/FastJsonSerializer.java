package io.gatling.jsonbenchmark.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;
import com.alibaba.fastjson.JSON;

/**
 * Created by Richard on 4/18/14.
 */
public class FastJsonSerializer {


    private Object serialize(AllTypes allTypes) throws Exception {
        allTypes.setMyLong ( System.currentTimeMillis () );
        return  JSON.toJSONString(allTypes);
    }



    private Object roundTrip(AllTypes alltype) throws Exception {
        String string = JSON.toJSONString(alltype);
        return JSON.parseObject(string,  AllTypes.class);
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
