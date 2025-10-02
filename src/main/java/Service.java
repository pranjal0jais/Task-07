import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Service {

    public void addEmployee(String name, String department, Double salary){
        String query = "INSERT INTO employee(name, department, salary) VALUES(?, ?, ?)";
        try(
            Connection conn = DatabaseConfig.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ){
            Employee emp = Employee.builder()
                    .name(name)
                    .department(department)
                    .salary(salary)
                    .build();
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getDepartment());
            stmt.setDouble(3, emp.getSalary());
            stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteEmployee(int id){
        String query = "DELETE FROM employee WHERE id = ?";
        try(
            Connection conn = DatabaseConfig.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void getAllEmployees(){
        String query = "SELECT * FROM employee";
        try(
            Connection conn = DatabaseConfig.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Employee emp = Employee.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .department(rs.getString("department"))
                        .salary(rs.getDouble("salary"))
                        .build();
                System.out.println(emp);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void updateEmployee(int id, String name, String department, Double salary){
        String query = "UPDATE employee SET name=?, department=?, salary=? WHERE id=?";
        try(
            Connection conn = DatabaseConfig.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ){
            stmt.setString(1, name);
            stmt.setString(2, department);
            stmt.setDouble(3, salary);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void getEmployeeById(int id){
        String query = "SELECT * FROM employee WHERE id=?";
        try(
                Connection conn = DatabaseConfig.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)
        ){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Employee emp = Employee.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .department(rs.getString("department"))
                        .salary(rs.getDouble("salary"))
                        .build();
                System.out.println(emp);
            } else{
                System.out.println("Employee not found");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
