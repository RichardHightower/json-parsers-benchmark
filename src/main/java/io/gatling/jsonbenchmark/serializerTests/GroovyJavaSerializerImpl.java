package io.gatling.jsonbenchmark.serializerTests;

public class GroovyJavaSerializerImpl implements DataSerializer {

    @Override
    public String serialize(Object data) {
        return MyJsonOutput.toJson(data);
    }

}
