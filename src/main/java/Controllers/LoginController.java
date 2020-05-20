package Controllers;

import Entity.Login;
import Impl.LoginDAO;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class LoginController {


    private final LoginDAO loginDAO;

    public LoginController(LoginDAO loginDAO)
    {
        this.loginDAO = loginDAO;
    }

    @GetMapping("/getAdmin/{adminID}")
    public Login getAdmin(@PathVariable int adminId){
        Login item = loginDAO.getAdmin(adminId);
        if(item == null){
            throw new RuntimeException("Couldn't find an item in inventory with ID:" + adminId);
        }
        return item;
    }

    @PostMapping("/createAdmin")
    public Login createAdmin(@PathVariable Login admin){
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
