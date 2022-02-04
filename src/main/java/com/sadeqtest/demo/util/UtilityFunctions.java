package com.sadeqtest.demo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public final class UtilityFunctions {
    private static final ObjectMapper OBJECT_MAPPER=new ObjectMapper();
    public static String toJSON(Serializable obj){
        try {
            return OBJECT_MAPPER.writeValueAsString((Object) obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
