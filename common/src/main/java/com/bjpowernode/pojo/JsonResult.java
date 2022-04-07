package com.bjpowernode.pojo;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author hxsoft + jiangrenbao
 * @date 2021/11/20
 * @description ajax请求结果返回对象(hashmap对象)
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class JsonResult extends HashMap<String, Object> {

    //<editor-fold desc="静态变量(key值)">
    /**
     * 静态变量(创建JsonResult对象时不需要初始化),作为JsonResult参数的key值
     */
    public static final String RESULT = "result";
    public static final String MESSAGE = "message";
    /**
     * 成功时code返回"1",失败是code返回"0"
     */
    public static final String CODE = "code";
    public static final String DATA = "data";
    /* public static final String MESSAGE_OF_BEAN_VALIDATE = "INVALID_BEAN";*/
    //</editor-fold>

    //<editor-fold desc="返回JsonResult对象">
    /**
     return new JsonResult(true, "成功");
     返回数据的格式:
        {
            "result": true,
            "code": "1",
            "message": "成功"
        }
    */
    public JsonResult(boolean result, String message) {
        this.setResult(result);
        this.setMessage(message);
        this.setCode(result);
    }

    /**
     return new JsonResult(true, "成功", "这是数据");
     返回数据的格式:
        {
            "result": true,
            "code": "1",
            "data": "这是数据",
            "message": "成功"
        }
     */
    public JsonResult(boolean result, String message, Object data) {
        this.setResult(result);
        this.setMessage(message);
        this.setData(data);
        this.setCode(result);

    }
    //</editor-fold>

    //<editor-fold desc="setter/getter(put/get)">

    // get("code")
    public String getCode() {
        return (String) this.get(CODE);
    }

    // put("code",value)
    public JsonResult setCode(boolean result) {
        if (result == true) {
            this.put(CODE, "1");
        } else if (result == false) {
            this.put(CODE, "0");
        }
        return this;
    }

    // get("result")
    public boolean getResult() {
        return (Boolean) this.get(RESULT);
    }

    // put("result",value)
    public JsonResult setResult(boolean value) {
        this.put(RESULT, value);
        return this;
    }

    // get("message")
    public String getMessage() {
        return (String) this.get(MESSAGE);
    }

    // put("message",value)
    public JsonResult setMessage(String value) {
        this.put(MESSAGE, value);
        return this;
    }

    // get("data")
    public Object getData() {
        Object r = this.get(DATA);
        return r;
    }

    // put("data",value)
    public JsonResult setData(Object value) {
        this.put(DATA, value);
        return this;
    }
    //</editor-fold>

    //<editor-fold desc="暂时用不到">
    /*public JsonResult(Object data) {

        this.setResult(true);
        this.setData(data);
    }

    public JsonResult(Object data, int totalCount) {
        super();
        this.setResult(true);
        this.setData(data);
    }

    public JsonResult(Object data, int totalCount, int start, int limit) {
        this.setResult(true);
        this.setData(data);
    }*/




    /***
     * Serialize class, except for null values, into a Json string.
     *
     * @return String
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonGenerationException
     */
    public String toJson() throws JsonGenerationException, JsonMappingException, IOException {
        return this.toJson(true);
    }

    /**
     * 注意在PO上增加@JsonSerialize(include=Inclusion.NON_NULL)
     *
     * @param serializeNulls
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public String toJson(boolean serializeNulls) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return new String(mapper.writeValueAsBytes(this), "UTF-8");
    }

    public byte[] toJsonBytes() throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsBytes(this);
    }

    @Override
    public String toString() {
        String str = "";
        try {
            str = "JsonResult [getSuccess()=" + getResult() + ", getMessage()=" + getMessage() + ", toJson()=" + toJson() + "]";

        } catch (JsonGenerationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;
    }
    //</editor-fold>

    public JsonResult() {
    }
}

