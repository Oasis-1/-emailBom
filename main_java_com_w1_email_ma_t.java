package com.w1.email.ma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author W1
 * @date 2021-12-13 10:58
 */
@Component
public class t {

    @Autowired
    JavaMailSenderImpl javaMailSender;
    @Scheduled(cron = "0/2 * * * * ? ")
    public void test1() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("易德涛别摸鱼了");
        simpleMailMessage.setText("四级考试剩五天了");
        simpleMailMessage.setTo("1939212190@qq.com");
        simpleMailMessage.setFrom("1939212190@qq.com");

        javaMailSender.send(simpleMailMessage);
    }

    @Scheduled(cron = "0/2 * * * * ? ")
    public void test2() {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            helper.setTo("2524856217@qq.com");
            helper.setFrom("1939212190@qq.com");
            helper.setSubject("易德涛别摸鱼了");
            helper.setText("<p style='color:red'>怎么保存表情包到电脑上。</p>",true);
            helper.addAttachment("1.png",new File("D:\\work\\1.png"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }
}
