package org.example.mvc_demo.controller;
import org.example.mvc_demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {

    @GetMapping("/user")
    public String user(Model model) {
        User user = new User("Jan");
        model.addAttribute("user", user);
        return "user";
    }

    // http://localhost:8080/helo?name=Imie
    @GetMapping("/hello")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(User user, Model model) {
        model.addAttribute("user", user);
        return "result";
    }
}
