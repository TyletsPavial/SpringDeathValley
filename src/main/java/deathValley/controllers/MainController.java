package deathValley.controllers;
import deathValley.domain.Account;
import deathValley.domain.User;
import deathValley.views.UserTotal;
import deathValley.views.UserTotalCollection;
import deathValley.repos.AccountRepo;
import deathValley.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AccountRepo accountRepo;

    @GetMapping
    public String main(Model model){
        UserTotalCollection userCollection = new UserTotalCollection();
        userCollection.completeUserCollection(userRepo.findAll(),accountRepo.findAll());
        model.addAttribute("users", userRepo.findAll());
        model.addAttribute("accounts", accountRepo.findAll());
        return "main";
    }

    @GetMapping("getRichest")
    public String getRichest(Model model){
        UserTotalCollection userCollection = new UserTotalCollection();
        userCollection.completeUserCollection(userRepo.findAll(),accountRepo.findAll());
        Iterable<UserTotal> richestUsers = userCollection.getRichestUsers();
        model.addAttribute("users", userRepo.findAll());
        model.addAttribute("accounts", accountRepo.findAll());
        model.addAttribute("richests", richestUsers);
        return "richest";
    }

    @PostMapping("addUser")
    public String addUser(@RequestParam String name, @RequestParam String sureName, Model model){
        userRepo.save(new User(name, sureName));
        model.addAttribute("users", userRepo.findAll());
        model.addAttribute("accounts", accountRepo.findAll());
        return "main";
    }

    @PostMapping("addAccount")
    public String addAccount(@RequestParam Integer userId, @RequestParam Integer account, Model model){
        accountRepo.save(new Account(account, userId));
        model.addAttribute("users", userRepo.findAll());
        model.addAttribute("accounts", accountRepo.findAll());
        return "main";
    }
}
