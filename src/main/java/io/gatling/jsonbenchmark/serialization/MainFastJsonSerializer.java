package io.gatling.jsonbenchmark.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.media.MediaContent;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;
import com.alibaba.fastjson.JSON;

/**
 * Created by Richard on 4/18/14.
 */
public class MainFastJsonSerializer {


    private Object serialize(AllTypes allTypes) throws Exception {
        allTypes.setMyLong ( System.currentTimeMillis () );
        return  JSON.toJSONString(allTypes);
    }



    private Object roundTrip(AllTypes alltype) throws Exception {
        String string = JSON.toJSONString(alltype);
        return JSON.parseObject(string,  AllTypes.class);
    }


    private Object mediaContentRoundTrip(MediaContent mediaContent) throws Exception {
        String string = JSON.toJSONString(mediaContent);
        return JSON.parseObject(string,  MediaContent.class);
    }


    private Object mediaContentOutput(MediaContent mediaContent) throws Exception {
        return JSON.toJSONString(mediaContent);
    }

    //@GenerateMicroBenchmark
    //@OutputTimeUnit(TimeUnit.SECONDS)
    public void mediaContentOutput(BlackHole bh) throws Exception {
        bh.consume(mediaContentOutput ( TestObjects.MEDIA_CONTENT ));
    }


    //@GenerateMicroBenchmark
    //@OutputTimeUnit(TimeUnit.SECONDS)
    public void mediaContentRoundTrip(BlackHole bh) throws Exception {
        bh.consume(mediaContentRoundTrip ( TestObjects.MEDIA_CONTENT ));
    }



    //@GenerateMicroBenchmark
    //@OutputTimeUnit( TimeUnit.SECONDS)
    public void serializeSmall(BlackHole bh) throws Exception {
        bh.consume(serialize(TestObjects.OBJECT));
    }

    //@GenerateMicroBenchmark
    //@OutputTimeUnit(TimeUnit.SECONDS)
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
