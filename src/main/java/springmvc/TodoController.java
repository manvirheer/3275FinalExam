package springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.SQLException;

@Controller
@RequestMapping
@SessionAttributes("name")
public class TodoController {

    DAOImplementation daoImplementation;
    ConnectionWrapper connectionWrapper = new ConnectionWrapper();

    @RequestMapping(value = "/listToDos", method = RequestMethod.GET)
    public String showToDos(ModelMap modelMap) throws SQLException, ClassNotFoundException {
        daoImplementation = new DAOImplementation(connectionWrapper.connect());
        modelMap.addAttribute("todos", daoImplementation.getItems());
        return "listToDos";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodos(ModelMap modelMap, @RequestParam int id) throws SQLException, ClassNotFoundException {
        daoImplementation = new DAOImplementation(connectionWrapper.connect());
        daoImplementation.deleteTodo(id);
        return "redirect:/listToDos";
    }

    @RequestMapping(value = "/addTodo", method = RequestMethod.GET)
    public String showAddForm(ModelMap modelMap) throws SQLException, ClassNotFoundException {
        daoImplementation = new DAOImplementation(connectionWrapper.connect());
        return "addTodo";
    }

    @RequestMapping(value = "/addTodo", method = RequestMethod.POST)
    public String deleteTodos(ModelMap modelMap, @RequestParam String item, @RequestParam String priority, @RequestParam String time) throws SQLException, ClassNotFoundException {
        daoImplementation = new DAOImplementation(connectionWrapper.connect());
        TodoItem todoItem = new TodoItem(item , time, priority);
        daoImplementation.addToDo(todoItem);
        return "redirect:/listToDos";
    }





}
