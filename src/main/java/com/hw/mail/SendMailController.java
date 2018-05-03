package com.hw.mail;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import java.io.IOException;
import java.util.List;

/**
 * Created by pandehua on 2018/04/12.
 */
@RestController
public class SendMailController {
    Logger logger = Logger.getLogger(SendMailController.class);
    @Autowired
    private JavaMailSender mailSender;

     @PostMapping("/api/sendMail")
    public ResponseEntity<?> sendMail(@RequestBody MailData maildata) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            helper.setFrom(maildata.getMailFrom());
            if(!maildata.getMailTo().isEmpty()) {
                String mailTo = maildata.getMailTo().replaceAll(";",",");
                final String[] arrayOfTOAddress = mailTo.split(",");
                    helper.setTo(arrayOfTOAddress);
            }
            if(!maildata.getMailBcc().isEmpty()) {
                String mailBcc = maildata.getMailBcc().replaceAll(";",",");
                final String[] arrayOfBCCAddress = mailBcc.split(",");
                    helper.setBcc(arrayOfBCCAddress);
            }
            if(!maildata.getMailCc().isEmpty()){
                String mailCc = maildata.getMailCc().replaceAll(";",",");
                final String[] arrayOfCCAddress = mailCc.split(",");
                    helper.setCc(arrayOfCCAddress);
            }
            helper.setSubject(maildata.getMailSubject());
            String BodyType = maildata.getMailBodyType();
            if (BodyType.equalsIgnoreCase("html")){
                helper.setText(maildata.getMailBody(),true);
            }else{
                helper.setText(maildata.getMailBody());
            }
            //附件处理
            List<Attachment> attachments = maildata.getAttachments();
            if(attachments!=null) {
                for (int i = 0; i < attachments.size(); i++) {
                    BASE64Decoder decoder = new BASE64Decoder();
                    byte[] decodedBytes = decoder.decodeBuffer(attachments.get(i).getFilebase64string());

                    //AttachmentDataSource attsce=new AttachmentDataSource(attachments.get(i).getName(),attachments.get(i).getContentType(),attachments.get(i).getFilebase64string());
                    //final InputStreamSource attachmentSource = new ByteArrayResource(decodedBytes);
                    DataSource dataSource = new ByteArrayDataSource(decodedBytes, attachments.get(i).getContentType());
                    helper.addAttachment(attachments.get(i).getName(), dataSource);
                }
            }
            //发送邮件
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
         return new ResponseEntity("Successfully Send " , new HttpHeaders(), HttpStatus.OK);
    }
}
