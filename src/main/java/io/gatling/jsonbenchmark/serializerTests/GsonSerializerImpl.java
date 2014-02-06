package io.gatling.jsonbenchmark.serializerTests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonSerializerImpl implements DataSerializer {

    private Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();

    @Override
    public String serialize(Object data) {
        return gson.toJson(data);
    }

}
