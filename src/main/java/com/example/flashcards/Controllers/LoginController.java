package com.example.flashcards.Controllers;

import com.example.flashcards.Entity.Login;
import com.example.flashcards.Impl.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController

public class LoginController {
    private final LoginDAO loginDAO;
    @Autowired
    public LoginController(LoginDAO loginDAO)
    {
        this.loginDAO = loginDAO;
    }

    @GetMapping("/ddd")
    public String test()
    {
        return "test";
    }
    @PostMapping("/addAdmin")
    public Login createAdmin(@RequestBody Login admin){
        Login item = loginDAO.saveAdmin(admin);
        return item;
    }
    @PostMapping("/checkAdmin")
        public String checker(@RequestBody Login admin)
        {
            if(loginDAO.checkAdmin(admin))
            {
                return "Success";
            }
            else
            {
                return "Failure";
            }


        }

}
