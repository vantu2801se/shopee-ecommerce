package com.nh7.ecommerce.config;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Configuration
@Configurable
public class EmailConfig {
    @Value("${email.sender.host}")
    private String host;

    @Value("${email.sender.port}")
    private String port;

    @Value("${email.sender.username}")
    private String username;

    @Value("${email.sender.password}")
    private String password;

    @Value("${email.transport.protocol}")
    private String protocol;

    @Value("${email.smtp.auth}")
    private String auth;

    @Value("${email.smtp.starttls.enable}")
    private String ttlsEnable;

    @Value("${email.debug}")
    private String debug;


    @Bean
    public JavaMailSender getJavaMailSender(){

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(Integer.valueOf(port));

        mailSender.setUsername(username);
        mailSender.setPassword(password);

        mailSender.setJavaMailProperties(getMailSenderProperties());

        return mailSender;
    }

    private Properties getMailSenderProperties(){
        Properties props = new Properties();
        props.put("mail.transport.protocol", protocol);
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.starttls.enable", ttlsEnable);
        props.put("mail.debug", debug);
        return props;
    }
}