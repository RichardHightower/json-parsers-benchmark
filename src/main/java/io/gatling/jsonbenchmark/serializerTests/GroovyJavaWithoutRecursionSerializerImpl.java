package io.gatling.jsonbenchmark.serializerTests;

public class GroovyJavaWithoutRecursionSerializerImpl implements DataSerializer {

    @Override
    public String serialize(Object data) {
        return MyJsonOutput.toJsonWithoutRecursion(data);
    }

}
