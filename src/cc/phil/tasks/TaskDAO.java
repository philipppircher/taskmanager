package cc.phil.tasks;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    // Methodes
    //
    public List<TaskVO> getAllTasks() {

        List<TaskVO> tasks = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tasks", "root", "");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from tasks");

            while (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("id");

                TaskVO taskVO = new TaskVO(id, name);
                tasks.add(taskVO);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tasks;
    }

    public void insertTask(TaskVO task){
        String sql = "insert into tasks (name) VALUES ('" + task.getName() + "')";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tasks", "root", "");

            Statement stmt = con.createStatement();
            stmt.execute(sql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(int idNumber){
        String sql = "DELETE FROM tasks WHERE id = "+ idNumber;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tasks", "root", "");

            Statement stmt = con.createStatement();
            stmt.execute(sql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTask(int idNumber, String newName){
        String sql = "UPDATE tasks SET name = '" + newName + "' Where id = "+ idNumber;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tasks", "root", "");

            Statement stmt = con.createStatement();
            stmt.execute(sql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getter
    //
    public int getDataCounter() {
        int dataCounter = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tasks", "root", "");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM `tasks`");

            while (rs.next()) {
                dataCounter = rs.getInt("COUNT(*)");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataCounter;
    }
}
