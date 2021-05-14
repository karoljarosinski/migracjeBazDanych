package pl.kj.migracjebazdanych;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kj.migracjebazdanych.user.User;
import pl.kj.migracjebazdanych.user.UserRepository;

@Controller
public class MainController {

    private UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String homepage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userRepository.findAll());
        return "home";
    }

    @PostMapping("/")
    public String addUser(User user) {
        userRepository.save(user);
        return "redirect:/";
    }
}
