package com.example.spboot.userController;

import com.example.spboot.model.User;
import com.example.spboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getAllUser(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all_user";
    }

    @GetMapping("/creat_user")
    public String getCreateUser(Model model) {
        model.addAttribute("user", new User());
        return "creat_user";
    }

    @PostMapping("/creat_user")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/update_user")
    public ModelAndView update(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView("update_user");
        User user = userService.getUser(id);
        modelAndView.addObject("userId", user);
        return modelAndView;
    }

    @PostMapping("/update_user")
    public String update(@RequestParam("id") int id, @ModelAttribute("userUp") User user) {
        user.setId(id);
        userService.updateUser(id, user);
        return "redirect:/";
    }

    @GetMapping("/delete_user")
    public String delete(Model model) {
        model.addAttribute("userId", new User());
        return "delete_user";
    }

    @PostMapping("/delete_user")
    public String delete(@ModelAttribute("userId") User user) {
        userService.deleteUser(user.getId());
        return "redirect:/";
    }
}
