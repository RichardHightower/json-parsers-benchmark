package io.gatling.jsonbenchmark.serializerTests;


import org.boon.json.JsonSerializer;
import org.boon.json.JsonSerializerFactory;

/**
 * Created by rick on 12/29/13.
 */
public class BoonJavaSerializerImpl implements DataSerializer {
    JsonSerializer serializer = new JsonSerializerFactory().useAnnotations ().create ();

    @Override
    public Object serialize ( Object data ) {
        return serializer.serialize ( data );
    }
}
