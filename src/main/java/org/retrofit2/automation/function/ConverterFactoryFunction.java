package org.retrofit2.automation.function;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ConverterFactoryFunction {


    public static final Function<String, Converter.Factory> GSON_FACTORY = (String s) -> {
        return GsonConverterFactory.create(new Gson());
    };

    public static final Function<String, Converter.Factory> JACKSON_FACTORY = (String s) -> {
        return JacksonConverterFactory.create(new ObjectMapper());
    };


    static final Map<String, Function<String, Converter.Factory>> MAP = new HashMap() {{
        put("gson", GSON_FACTORY);
        put("jackson", JACKSON_FACTORY);
    }};

    public static Converter.Factory getConverterAdapterFactory(final String converter) {
        return MAP.get(converter).apply(converter);
    }
}
