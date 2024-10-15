package com.example.brinquedos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // O template de login que você já criou
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register"; // O template de registro que você já criou
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("confirmPassword") String confirmPassword,
                               @RequestParam("email") String email,
                               Model model) {
        // Verifica se as senhas coincidem
        if (!password.equals(confirmPassword)) {
            model.addAttribute("errorMessage", "As senhas não coincidem.");
            return "register";
        }

        // Verifica se o username já existe
        if (usuarioRepository.existsByUsername(username)) {
            model.addAttribute("errorMessage", "O nome de usuário já está em uso.");
            return "register";
        }

        // Verifica se o email já existe
        if (usuarioRepository.existsByEmail(email)) {
            model.addAttribute("errorMessage", "O e-mail já está em uso.");
            return "register";
        }

        // Cria o novo usuário
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setSenha(password); // Armazena a senha
        usuario.setEmail(email); // Define o e-mail
        usuarioRepository.save(usuario); // Salva o usuário

        return "redirect:/login?success"; // Redireciona para a tela de login com mensagem de sucesso
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            Model model) {
        // Lógica de autenticação
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario == null || !usuario.getSenha().equals(password)) {
            model.addAttribute("errorMessage", "Nome de usuário ou senha incorretos.");
            return "login"; // Retorna ao formulário de login com mensagem de erro
        }

        // Se a autenticação for bem-sucedida, redireciona para a página inicial ou para outra página
        return "redirect:/list"; // Ajuste conforme a sua aplicação
    }
}
