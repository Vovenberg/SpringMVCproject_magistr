package com.web.controllers;

import com.web.entities.ClientsEntity;
import com.web.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Vladimir on 16.10.2016.
 */
@Controller
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    ClientsService clientsService;

    @GetMapping()
    String getClients (Model model){
        model.addAttribute("clients",clientsService.getAll());

        return "clients";
    }

    @GetMapping("/addForm")
    String addJsp (Model model){
        model.addAttribute("client",new ClientsEntity());
        return "/forms/addClients";
    }

    @PostMapping("/add")
    String addClient (@ModelAttribute("client") ClientsEntity clientsEntity,BindingResult result){
        clientsService.add(clientsEntity);
        return "redirect:/clients";
    }

    @GetMapping("/delete")
    String delete (@RequestParam("id") Long id){
        clientsService.delete(id);
        return "redirect:/clients";
    }


}