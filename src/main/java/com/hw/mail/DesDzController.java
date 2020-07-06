package com.hw.mail;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pandehua on 2020/7/4.
 */
@RestController
public class DesDzController {
    Logger logger = Logger.getLogger(SendMailController.class);

    @PostMapping("/api/encryptfp")
    public ResponseEntity<?> encrypt(@RequestBody String str_body) {
        String str=DESDZFP.encrypt(str_body);

        return new ResponseEntity(str , new HttpHeaders(), HttpStatus.OK);
    }
    @PostMapping("/api/decryptfp")
    public ResponseEntity<?> decrypt(@RequestBody String str_body) {
        String str= null;
        try {
            str = DESDZFP.decrypt(str_body);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(str , new HttpHeaders(), HttpStatus.OK);
    }
}
