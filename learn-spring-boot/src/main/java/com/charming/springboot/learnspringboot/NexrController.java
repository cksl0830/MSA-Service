package com.charming.springboot.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class NexrController {

    @Autowired
    private Nexr nexr;

    @RequestMapping (value = "/nexr",method = RequestMethod.GET)
    public Nexr retrieveAllCourses(){
        return nexr;
    }
}
