package com.tengfei.algo.demo.command;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CommandContext implements Serializable {

    private Map<String, Object> parameters = new HashMap<>();


    public Map<String, Object> getParameters() {
        return parameters;
    }

    public Object getParameter(String key) {
       return parameters.get(key);
    }

    public void setParameter(String key, Object obj) {
        parameters.put(key, obj);
    }
}
