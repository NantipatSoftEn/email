package com.example.email.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
@Service
@Log4j2
public class EmailService {
    @Value("${spring.mail.username}")
    private String form;
    private final JavaMailSender mailSender;
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(String to,String subject , String html){
        System.out.println("MockSendEmail");
        MimeMessagePreparator message = mimeMessage -> {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
            helper.setFrom(form);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(html,true);
        };
        mailSender.send(message);
        log.info("MockSendEmail");
    }
}
