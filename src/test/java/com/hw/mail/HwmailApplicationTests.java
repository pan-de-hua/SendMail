package com.hw.mail;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HwmailApplicationTests {

	@Test
	public void contextLoads() throws IOException {
//		File file = new File("d:\\1.pdf");;
//		FileInputStream inputFile = new FileInputStream(file);
//		byte[] buffer = new byte[(int) file.length()];
//		inputFile.read(buffer);
//		inputFile.close();
//		String s= new BASE64Encoder().encode(buffer);
//		//System.out.println(s);
//		HttpClient httpClient = new DefaultHttpClient();
//		HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/api/sendMail");
//		String responseBody = null;
//		try {
//			MailData mail = new MailData();
//			mail.setMailFrom("41842867@qq.com");
//			mail.setMailTo("41842867@qq.com");
//			mail.setMailBody("测试41842867@qq.com");
//			mail.setMailSubject("测试");
//			ArrayList<Attachment> atts = new ArrayList<Attachment>();
//			Attachment att = new Attachment();
//			att.setName(file.getName());
//			att.setContentType("application/pdf");
//			att.setFilebase64string(s);
//			atts.add(att);
//			mail.setAttachments(atts);
//			String jsons =JSON.toJSONString(mail);
//			StringEntity stringEntity = new StringEntity(jsons);
//			httpPost.setHeader("Content-type", "application/json;charset=utf-8");
//			httpPost.setEntity(stringEntity);
//
//			ResponseHandler<String> responseHandler = new BasicResponseHandler();
//			responseBody = httpClient.execute(httpPost, responseHandler);
//		} catch (IOException e) {
//
//			throw e;
//		} finally {
//			httpClient.getConnectionManager().shutdown();
//		}
	}

}
