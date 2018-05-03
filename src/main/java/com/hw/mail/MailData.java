package com.hw.mail;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by pandehua on 2018/04/12.
 */
public class MailData {
    @JsonProperty("mailfrom")
    private String mailFrom="";
    @JsonProperty("mailto")
    private String mailTo="";
    @JsonProperty("mailcc")
    private String mailCc="";
    @JsonProperty("mailbcc")
    private String mailBcc = "";
    @JsonProperty("mailbody")
    private String mailBody="";
    @JsonProperty("mailbodytype")
    private String mailBodyType = "text";
    @JsonProperty("mailsubject")
    private String mailSubject="";
    @JsonProperty("attachments")
    private List<Attachment> attachments;

    @JSONField(name="mailcc")
    public String getMailCc() {
        return mailCc;
    }
    @JSONField(name="mailcc")
    public void setMailCc(String mailCc) {
        this.mailCc = mailCc;
    }
    @JSONField(name="mailbcc")
    public String getMailBcc() {
        return mailBcc;
    }
    @JSONField(name="mailbcc")
    public void setMailBcc(String mailBcc) {
        this.mailBcc = mailBcc;
    }

    @JSONField(name="mailbodytype")
    public String getMailBodyType() {
        return mailBodyType;
    }

    @JSONField(name="mailbodytype")
    public void setMailBodyType(String mailBodyType) {
        this.mailBodyType = mailBodyType;
    }

    //@JSONField(name="attachments")
    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
    @JSONField(name="mailfrom")
    public String getMailFrom() {
        return mailFrom;
    }

    @JSONField(name="mailfrom")
    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    @JSONField(name="mailto")
    public String getMailTo() {
        return mailTo;
    }

    @JSONField(name="mailto")
    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    @JSONField(name="mailbody")
    public String getMailBody() {
        return mailBody;
    }

    @JSONField(name="mailbody")
    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }

    @JSONField(name="mailsubject")
    public String getMailSubject() {
        return mailSubject;
    }

    @JSONField(name="mailsubject")
    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

}
