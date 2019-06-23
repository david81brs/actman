package com.deltal.actman.controllers;

import com.deltal.actman.model.Macrochallenge;
import com.deltal.actman.repository.MacroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    private MacroRepository mr;

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Macrochallenge> macros = mr.findAll();
        mv.addObject("macros", macros);
        return mv;
    }
}
