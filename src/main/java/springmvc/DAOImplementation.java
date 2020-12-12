package springmvc;

import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAOImplementation implements DAOInterface {

    public Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public DAOImplementation(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean addUser(User user) throws SQLException, ClassNotFoundException {

        //Query
        String sql = "INSERT INTO user (username, password) Values (? , ?) ;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //Binding Values to the Prepared Statement
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());

        //True If record Inserted Successfully
        if(preparedStatement.executeUpdate() == 1){
            System.out.println("One record added successfully.");
            return true;
        }
        //False If error occurs
        else
            return false;

    }

    @Override
    public boolean verifyLogin(User user) throws SQLException, ClassNotFoundException {

        //Query
        String sql = "Select * from User WHERE username = ? and password = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //Binding Values to the Prepared Statement
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());

        ResultSet resultSet = preparedStatement.executeQuery();

        //Verifying by checking the result set
        if(!resultSet.first()){
            System.out.println("Wrong Username or Password");
            return false;
        }
        else
            return true;
    }

    @Override
    public boolean addToDo(TodoItem todoItem) throws SQLException, ClassNotFoundException {

        //Query
        String query = "Insert Into TodoItem (item, time, `priority`) Values ( ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        //Binding the variables to the prepared statement
        preparedStatement.setString(1, todoItem.getItem());
        preparedStatement.setString(2, todoItem.getTime());
        preparedStatement.setString(3, todoItem.getPriority());

        //True if one record added successfully
        if(preparedStatement.executeUpdate() == 1) {
            System.out.println("One record added successfully.");
            return true;
        }
        //False if unable to add the record
        else
            return false;
    }

    @Override
    public boolean deleteTodo(int id) throws SQLException, ClassNotFoundException {

        //Query
        String query = "DELETE FROM TodoItem Where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        //Binding the variables to the prepared statement
        preparedStatement.setInt(1,id);

        //True if one record added deleted
        if(preparedStatement.executeUpdate() == 1) {
            System.out.println("One record deleted successfully.");
            return true;
        }
        //False if unable to delete the record
        else
            return false;
    }

    @Override
    public List<TodoItem> getItems() throws SQLException, ClassNotFoundException {

        //Query
        String query = "SELECT * FROM TodoItem;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);


        //ResultSet will contain the result from the query execution
        ResultSet resultSet = preparedStatement.executeQuery();

        TodoItem todoItem;

        //List to return
        List<TodoItem> workLists = new ArrayList<TodoItem>();
        while(resultSet.next()){
            System.out.println("true");

            todoItem = new TodoItem(resultSet.getInt("id"), resultSet.getString("time"), resultSet.getString("item"), resultSet.getString("priority"));
            System.out.println("TodoItem -> " + todoItem.getItem() + "And values -> " +resultSet.getInt("id"));
            //Add the work list item into the list
            workLists.add(todoItem);
        }

        return workLists;
    }
}
