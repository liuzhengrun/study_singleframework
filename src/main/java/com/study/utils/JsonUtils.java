package com.study.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletRequest;
import java.io.BufferedReader;
import java.io.IOException;


@Log4j2
public class JsonUtils {

    public static ObjectMapper objectMapper = new ObjectMapper();

    public static String Object2json(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public static <T> T json2Object(String json, Class<T> valueType) throws IOException {
        return objectMapper.readValue(json, valueType);
    }

}