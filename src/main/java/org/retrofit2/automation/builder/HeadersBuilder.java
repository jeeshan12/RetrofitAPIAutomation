package org.retrofit2.automation.builder;

import okhttp3.Headers;

import java.time.Instant;
import java.util.Date;

public class HeadersBuilder {

    private HeadersBuilder() {
    }

    private static Headers.Builder headerBuilder;


    public static HeadersBuilder builder() {
        headerBuilder = new Headers.Builder();
        return new HeadersBuilder();
    }

    public HeadersBuilder setHeaders(final String key, final String value) {
        headerBuilder.add(key, value);
        return this;
    }

    public HeadersBuilder setHeaders(final String key, final Date value) {
        headerBuilder.add(key, value);
        return this;
    }

    public HeadersBuilder setHeaders(final String key, final Instant value) {
        headerBuilder.add(key, value);
        return this;
    }

    public Headers build(){
        return headerBuilder.build();
    }
}
