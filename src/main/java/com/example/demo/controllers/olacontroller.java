package com.example.demo.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.example.demo.models.Teste;
import com.example.demo.repository.participanterepository;
@Controller
public class olacontroller {
    @Autowired
    participanterepository pr;

    @GetMapping("")
    public String index(){
        return "index";
    }

    @GetMapping("/participante")
    public ModelAndView participantes(){
        List<Teste> listap = new ArrayList<>();
        
        listap = pr.findAll();

        ModelAndView mv = new ModelAndView("/participante");
        mv.addObject("listap",listap);
        return mv;
    }
    @GetMapping("/novo")
    public String novo(){
        return "novo";
    }
    @PostMapping("/cadastro")
    public String cadastro(Teste teste){
        pr.save(teste);
        return "redirect:/participante";

    }
    @GetMapping("/detalhes/{id}")
    public ModelAndView detalhes(@PathVariable Long id){
        Optional<Teste> teste = pr.findById(id);
        if(teste.isPresent()){
            ModelAndView mv = new ModelAndView("/detalhes");
            mv.addObject("detalhe",teste.get());
            return mv;
        }
        else{
            return new ModelAndView("redirect:/participante");
        }
    }
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id){
        pr.deleteById(id);
        return "redirect:/participante";
    }
    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id){
        Optional<Teste> teste = pr.findById(id);
        if(teste.isPresent()){
            ModelAndView mv = new ModelAndView("/editar");
            mv.addObject("teste",teste.get());
            return mv;
        }
        else{
            return new ModelAndView("redirect:/participante");
        }
    }
    @PostMapping("/edita")
    public String editarparticipante(Teste teste){
        pr.save(teste);
        return "redirect:/participante";
    }
}