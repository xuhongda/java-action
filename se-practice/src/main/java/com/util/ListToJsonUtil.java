package com.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;

/**
 * jackson 集合转String
 *
 * @author xuhongda on 2019/1/7
 * com.util
 * java-action
 */
public class ListToJsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    public static String listToJson(Collection collection) throws IOException {
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, collection);
        return writer.toString();
    }
}
