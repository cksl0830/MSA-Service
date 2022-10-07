package com.rest.webservices.restfulwebservices.internationalization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloController {
    private final MessageSource messageSource;

    public HelloController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/hello-internationalized")
    public String helloInternationalized(
            @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("greeting.message", null, locale);
    }
}
