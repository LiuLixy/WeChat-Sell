package com.lwproject.wechatsell.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * @Author: LiuWang
 * @Created: 2018/8/26 14:09
 */
public class Date2LongUtil extends JsonSerializer<Date> {
    @Override
    public void serialize(Date value, JsonGenerator gen,
                          SerializerProvider serializers) throws IOException {
        gen.writeNumber(value.getTime() / 1000);
    }
}
