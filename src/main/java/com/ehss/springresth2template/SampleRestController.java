package com.ehss.springresth2template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.util.Collection;

@RestController
public class SampleRestController {

    //Never use Field injection. Why? because unit test dies.
    private SampleEntityRepository sampleEntityRepository;

    @Autowired
    public SampleRestController(SampleEntityRepository sampleEntityRepository){
        this.sampleEntityRepository=sampleEntityRepository;
    }


    @RequestMapping(value = "/samples",method = RequestMethod.GET)
    Collection<SampleEntity> samples(){
        return this.sampleEntityRepository.findAll();
    }
}
