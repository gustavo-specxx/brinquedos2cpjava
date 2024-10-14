package com.example.brinquedos;

import com.example.brinquedos.Brinquedo;
import com.example.brinquedos.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoRepository brinquedoRepository;

    // Listar todos os brinquedos
    @GetMapping
    public String list(Model model) {
        model.addAttribute("brinquedos", brinquedoRepository.findAll());
        return "brinquedo/list"; // Thymeleaf template for list
    }

    // Formulário para criar um novo brinquedo
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("brinquedo", new Brinquedo());
        return "brinquedo/form"; // Thymeleaf template for form
    }

    // Criar um novo brinquedo
    @PostMapping
    public String create(@ModelAttribute Brinquedo brinquedo) {
        brinquedoRepository.save(brinquedo);
        return "redirect:/brinquedos";
    }

    // Editar um brinquedo existente
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Brinquedo brinquedo = brinquedoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Brinquedo Id:" + id));
        model.addAttribute("brinquedo", brinquedo);
        return "brinquedo/form"; // Thymeleaf template for form
    }

    // Atualizar um brinquedo existente
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Brinquedo brinquedo) {
        brinquedoRepository.save(brinquedo);
        return "redirect:/brinquedos";
    }

    // Deletar um brinquedo
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        brinquedoRepository.deleteById(id);
        return "redirect:/brinquedos";
    }
}
