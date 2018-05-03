package com.hw.mail;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import sun.misc.BASE64Decoder;

import javax.activation.DataSource;
import java.io.*;

/**
 * Created by pandehua on 2018/04/12.
 */
public class Attachment {

    @JsonProperty("filebase64string")
    private String filebase64string;
    @JsonProperty("contenttype")
    private String contentType="application/txt";
    @JsonProperty("name")
    private String name;

    public String getFilebase64string() {
        return filebase64string;
    }

    public void setFilebase64string(String filebase64string) {
        this.filebase64string = filebase64string;
    }
    @JSONField(name="contenttype")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JSONField(name="contenttype")
    public String getContentType() {
        return contentType;
    }


    public String getName() {
        return name;
    }


}
