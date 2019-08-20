package com.ehss.springresth2template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleMvcController {

    @Autowired // do not make this a habit
    private SampleEntityRepository sampleEntityRepository;

    @RequestMapping("/samples.htm")
    public String samples(Model model){
        model.addAttribute("samples",this.sampleEntityRepository.findAll());
        return "samples"; // src/main/resources/templates/samples.html
    }
}
