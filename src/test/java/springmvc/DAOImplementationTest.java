
package springmvc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
class DAOImplementationTest {

    @InjectMocks
    private DAOImplementation daoImplements;

    @Mock
    private Connection connection;

    @Mock
    private ResultSet resultSet;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ConnectionWrapper connectionWrapper;

    TodoItem todoItem;
    User user;

    @BeforeEach
    public void Setup() throws SQLException, ClassNotFoundException {
        MockitoAnnotations.openMocks(this);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(connectionWrapper.connect()).thenReturn(connection);
        todoItem =new TodoItem("Study","Today", "H");
        user = new User("Manvir", "Heer");
    }


    @Test
    void addUser() throws SQLException, ClassNotFoundException {
        when(connection.prepareStatement("INSERT INTO TodoItem VALUES ( ?, ? , ?)")).thenReturn(preparedStatement);
        daoImplements.addToDo(todoItem);
        verify(preparedStatement).executeUpdate();
    }

    @Test
    void verifyLogin() throws SQLException, ClassNotFoundException {
        when(connection.prepareStatement("Select * from User where username = ? and password = ? )")).thenReturn(preparedStatement);
        daoImplements.verifyLogin(user);
        verify(preparedStatement).executeUpdate();
    }

    @Test
    void addToDo() {
    }

    @Test
    void deleteTodo() {
    }

    @Test
    void getItems() {
    }
}

