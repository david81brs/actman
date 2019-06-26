package com.deltal.actman.controllers;

import com.deltal.actman.model.Macrochallenge;
import com.deltal.actman.repository.MacroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MacroController {

    @Autowired
    private MacroRepository mr;

    @RequestMapping(value="/addmacro", method=RequestMethod.GET)
    public String form(){
        return "macro/macroForm";
    }

    @RequestMapping(value="/addmacro", method=RequestMethod.POST)
    public String formpost(Macrochallenge macro){
        mr.save(macro);
        return "redirect:/macros";
    }

    @RequestMapping("/macros")
    public ModelAndView listaMacro(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Macrochallenge> macros = mr.findAll();
        mv.addObject("macros", macros);
        return mv;
    }

    @RequestMapping("/deletar")
    public String deletarMacro(long macroid){
        Macrochallenge mc = mr.findByMacroid(macroid);
        mr.delete(mc);
        return "redirect:/macros";
    }

    @RequestMapping(value="/edit/{macroid}")
    public String edit(@PathVariable int macroid, ModelMap model){
        Macrochallenge mc = mr.findByMacroid(macroid);
        model.addAttribute("macro", mc);
        return "macro/editForm";
    }

    @RequestMapping(value="/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("macro") Macrochallenge mc){
        Macrochallenge mce = mr.findByMacroid(mc.getMacroid());
        mce.setMacrotitle(mc.getMacrotitle());
        mce.setMacrocoordinator(mc.getMacrocoordinator());
        mce.setMacrodescription(mc.getMacrodescription());
        mr.save(mce);
        return new ModelAndView("redirect:/macros");
    }

    @RequestMapping("/{macroid}")
    public ModelAndView detalheMacro(@PathVariable("macroid") long macroid){
        Macrochallenge macro = mr.findByMacroid(macroid);
        ModelAndView mv = new ModelAndView("macroForm");
        mv.addObject("macro", macro);
        return mv;
    }


}
