package com.hw.mail;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.http.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by pandehua on 2020/7/6.
 */
@RestController
public class cxfKpServer {
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    Logger logger = LoggerFactory.getLogger(this.getClass());

//@Value("${demo.name}")
//private String name;

    /**
     * 开票结果查询
     * form-data
     * url:提交地址
     * order:报文
     */
    @PostMapping("/api/queryElectricKp")
    public ResponseEntity<?> queryElectricKp(@RequestParam("url") String url,@RequestParam("order") String str_order){
        OkHttpClient client = new OkHttpClient();
        //String url = "http://nnfpbox.nuonuocs.cn/shop/buyer/allow/ecOd/queryElectricKp.action";
        String str= DESDZFP.encrypt(str_order);
        okhttp3.FormBody formBody = new okhttp3.FormBody.Builder()
                                    .add("order",str)
                                    .build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        Response response = null;
        String resstr = "";
        try {
            response = client.newCall(request).execute();
            resstr = response.body().string();
//            logger.error("返回body:"+resstr);
        } catch (IOException e) {
            logger.error(e.getMessage());
            return new ResponseEntity(e.getMessage() ,HttpStatus.EXPECTATION_FAILED);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", response.header("Content-Type"));
        if(response.isSuccessful()){
            return new ResponseEntity(resstr ,headers,HttpStatus.OK);
        }else{
            String resBody =  "错误码："+response.code()+"-"+response.message()+resstr;
            return new ResponseEntity(resBody ,headers,HttpStatus.EXPECTATION_FAILED);
        }


    }
}
