package com.example.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jerry on 2017/1/11.
 * Sample :
 * {"response":"hola","id":"32949118","result":100,"msg":"OK."}
 */
public class SimSimiResponse {
    private final String id;
    private final String response;
    private final int result;
    private final String msg;

    public SimSimiResponse(@JsonProperty("id") String id,
                           @JsonProperty("result") int result,
                           @JsonProperty("msg") String msg,
                           @JsonProperty("response") String response) {
        this.id = id;
        this.result = result;
        this.msg = msg;
        this.response = response;
    }
}
