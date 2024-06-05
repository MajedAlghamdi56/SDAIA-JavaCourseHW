package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private Connection connect() {
        
        String url = "jdbc:sqlite:C:\\Users\\Ahmed\\Documents\\JAVA PROJECTS\\demo\\src\\main\\java\\com\\example\\hr.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertEmployee(Employee employee) {
        String sql = "INSERT INTO employees(name, position, salary) VALUES(?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getPosition());
            pstmt.setDouble(3, employee.getSalary());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Employee selectEmployee(int id) {
        String sql = "SELECT id, name, position, salary FROM employees WHERE id = ?";
        Employee employee = null;

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            
            if (rs.next()) {
                employee = new Employee(rs.getInt("id"),
                                        rs.getString("name"),
                                        rs.getString("position"),
                                        rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return employee;
    }

    public List<Employee> selectAllEmployees() {
        String sql = "SELECT id, name, position, salary FROM employees";
        List<Employee> employees = new ArrayList<>();

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),
                                                 rs.getString("name"),
                                                 rs.getString("position"),
                                                 rs.getDouble("salary"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return employees;
    }

    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET name = ?, position = ?, salary = ? WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getPosition());
            pstmt.setDouble(3, employee.getSalary());
            pstmt.setInt(4, employee.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

