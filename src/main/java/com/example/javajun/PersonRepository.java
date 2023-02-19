package com.example.javajun;

import com.example.javajun.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/person";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123";

    private static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Person getPersonForId(int personID) {

        Person person = new Person();

        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person WHERE person.\"personId\"="+personID);
            resultSet.next();
            person.setPersonId(resultSet.getInt("personId"));
            person.setBirthday(resultSet.getDate("birthday"));
            person.setTown(resultSet.getString("town"));
            person.setFio(resultSet.getString("fio"));
            person.setAlive(resultSet.getBoolean("isAlive"));
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
        return person;
    }

    public List<Person> getPersonAll() {
        List<Person> people = new ArrayList<>();

        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person");

            while(resultSet.next()) {
                Person person = new Person();

                person.setPersonId(resultSet.getInt("personId"));
                person.setBirthday(resultSet.getDate("birthday"));
                person.setTown(resultSet.getString("town"));
                person.setFio(resultSet.getString("fio"));
                person.setAlive(resultSet.getBoolean("isAlive"));

                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }
}
