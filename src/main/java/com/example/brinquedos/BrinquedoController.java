package com.example.brinquedos;

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
        return "list"; // Template Thymeleaf para lista
    }

    // Formulário para criar um novo brinquedo
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("brinquedo", new Brinquedo());
        return "form"; // Template Thymeleaf para formulário
    }

    // Criar um novo brinquedo
    @PostMapping
    public String create(@ModelAttribute Brinquedo brinquedo) {
        brinquedoRepository.save(brinquedo);
        return "redirect:/brinquedos"; // Redireciona para a lista após criar
    }

    // Editar um brinquedo existente
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Brinquedo brinquedo = brinquedoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Brinquedo Id:" + id));
        model.addAttribute("brinquedo", brinquedo);
        return "form"; // Template Thymeleaf para formulário
    }

    // Atualizar um brinquedo existente
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Brinquedo brinquedo) {
        brinquedo.setId(id); // Certifique-se de definir o ID
        brinquedoRepository.save(brinquedo);
        return "redirect:/brinquedos"; // Redireciona para a lista após atualizar
    }

    // Deletar um brinquedo
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        brinquedoRepository.deleteById(id);
        return "redirect:/brinquedos"; // Redireciona para a lista após deletar
    }
}
