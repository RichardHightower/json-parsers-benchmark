package org.boon.json.serializer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.boon.Boon;
import org.boon.json.JsonFactory;
import org.boon.json.JsonSerializerFactory;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.BlackHole;

import org.boon.json.serializers.impl.JsonSimpleSerializerImpl;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@State
public class SerializerBasics {

    static ObjectMapper mapper = new ObjectMapper();
    //JsonSimpleSerializerImpl json2 = new JsonSimpleSerializerImpl(false, 30);
    JsonSimpleSerializerImpl json = new JsonSimpleSerializerImpl();

    static Map<String, String> hello = Collections.singletonMap("message", "Hello, world!");

    public String serializerBasicBoon() {
        return json.serialize(hello).toString();
    }


    //public String serializerBasicBoon2() {
    //    return json2.serialize(hello).toString();
    //}

    public String serializerBasicJackson() {
        try {
            return mapper.writeValueAsString(hello);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void serializerBasicBoonBench(BlackHole bh) throws Exception {
        bh.consume(serializerBasicBoon());
    }

//    @GenerateMicroBenchmark
//    @OutputTimeUnit(TimeUnit.SECONDS)
//    public void serializerBasicBoonBench2(BlackHole bh) throws Exception {
//        bh.consume(serializerBasicBoon2());
//    }


    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void serializerBasicJackBench(BlackHole bh) throws Exception {
        bh.consume(serializerBasicJackson());
    }


}
