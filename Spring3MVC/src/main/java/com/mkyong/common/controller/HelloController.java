package com.mkyong.common.controller;

import com.mkyong.common.config.ApplicationConfig;
import com.mkyong.common.gateway.EmailServicesGateway;
import com.mkyong.common.user.EmailServiceTokenModel;
import com.mkyong.common.user.domain.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mkyong.common.user.domain.*;

@Controller
@RequestMapping("/welcome")
public class HelloController {

    @Autowired
    ApplicationConfig config;

    @Autowired
    private EmailServicesGateway emailServicesGateway;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        System.out.println("config " + config.getHostNameUrl());
        System.out.println("emailServicesGateway > " + emailServicesGateway);
        
        sendMailOperation();
        
        model.addAttribute("message", "Spring Security Hello World");
        return "hello";

    }

    private void sendMailOperation() {
        User user = new User();
        user.setEmailAddress("kaleeswaran14@gmail.com");
        user.setFirstName("Kaless");
         VerificationToken token = new VerificationToken(user, VerificationToken.VerificationTokenType.emailVerification,
                config.getEmailVerificationTokenExpiryTimeInMinutes());
        user.addVerificationToken(token);
        emailServicesGateway.sendVerificationToken(new EmailServiceTokenModel(user, token, getConfig().getHostNameUrl()));
    }
    
    public ApplicationConfig getConfig() {
        return config;
    }

    public void setConfig(ApplicationConfig config) {
        this.config = config;
    }

    public EmailServicesGateway getEmailServicesGateway() {
        return emailServicesGateway;
    }

    public void setEmailServicesGateway(EmailServicesGateway emailServicesGateway) {
        this.emailServicesGateway = emailServicesGateway;
    }

}
