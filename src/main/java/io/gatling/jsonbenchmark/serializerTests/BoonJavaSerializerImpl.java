package io.gatling.jsonbenchmark.serializerTests;


import org.boon.json.JsonSerializer;
import org.boon.json.JsonSerializerFactory;
import org.boon.json.serializers.impl.JsonSimpleSerializerImpl;
import org.boon.primitive.CharBuf;

/**
 * Created by rick on 12/29/13.
 */
public class BoonJavaSerializerImpl implements DataSerializer {


    JsonSimpleSerializerImpl serializer = new JsonSimpleSerializerImpl();

    private ThreadLocal<CharBuf> charBufThreadLocal = new ThreadLocal<>();

    @Override
    public Object serialize ( Object data ) {

        CharBuf buf = charBufThreadLocal.get();

        if (buf == null) {
            buf = CharBuf.create(1024*4);
            charBufThreadLocal.set(buf);
        } else {
            buf.readForRecycle();
        }


        serializer.serializeObject ( data, buf );

        return buf.toString();
    }
}
