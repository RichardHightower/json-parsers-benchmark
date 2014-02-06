package io.gatling.jsonbenchmark.serializerTests;
import groovy.json.JsonOutput;

import java.util.Map;

public class GroovySerializerImpl implements DataSerializer {

    @Override
    public String serialize(Object data) {
        if (data instanceof Map) {
            return JsonOutput.toJson((Map<?, ?>) data);
        } else {
            return JsonOutput.toJson(data);
        }
    }

}
