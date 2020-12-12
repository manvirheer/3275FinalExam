package springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;

@Controller
@RequestMapping
@SessionAttributes("name")
public class LoginController {

    DAOImplementation daoImplementation ;

    ConnectionWrapper connectionWrapper = new ConnectionWrapper();

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
      return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String show() {
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String handleLoginAuthentication(ModelMap model, @RequestParam String username,
                                            @RequestParam String password) throws SQLException, ClassNotFoundException{
        daoImplementation = new DAOImplementation(connectionWrapper.connect());
        User user = new User(username, password);
        if(daoImplementation.verifyLogin(user)) {
            model.put("name", user.getUsername());
            model.put("password", user.getPassword());
            return "welcome";
        }
        else{

            return "login";
        }


    }







}
