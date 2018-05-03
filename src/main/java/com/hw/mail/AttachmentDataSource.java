package com.hw.mail;

import sun.misc.BASE64Decoder;

import javax.activation.DataSource;
import java.io.*;

/**
 * Created by pandehua on 2018/04/12.
 */
public class AttachmentDataSource implements DataSource {

    private String filebase64string;
    private String contentType;
    private String name;


    public AttachmentDataSource(String name, String contentType, String filebase64string ) {
        this.name = name;
        this.filebase64string = filebase64string;
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

    public InputStream getInputStream() throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] decodedBytes = decoder.decodeBuffer(filebase64string);
        return new ByteArrayInputStream(decodedBytes);
    }

    public String getName() {
        return name;
    }

    public OutputStream getOutputStream() throws IOException {
        throw new FileNotFoundException();
    }
}
