package springmvc;



import java.sql.SQLException;
import java.util.List;

public interface DAOInterface {

    public boolean addUser(User user) throws SQLException, ClassNotFoundException;
    public boolean verifyLogin(User user) throws SQLException, ClassNotFoundException;
    public boolean addToDo(TodoItem todoItem) throws SQLException, ClassNotFoundException;
    public boolean deleteTodo(int id) throws  SQLException, ClassNotFoundException;
    public List<TodoItem> getItems() throws SQLException, ClassNotFoundException;

}
