package starter.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import starter.com.bean.Employee;
import starter.com.util.DBUtil;

public class EmployeeDao {

	public Employee[] getAllEmployees() {

		Employee[] empArray = new Employee[10];

		try {

			// Step 2: Create a Connection object
			Connection cn = DBUtil.createConnection();

			System.out.println("Connection established ");
			// Step 3: Create a PreparedStatement object using the Connection
			PreparedStatement ps = cn
					.prepareStatement("SELECT * FROM EMPLOYEE_111");

			// Step 4: Execute the query and store the result.
			ResultSet rs = ps.executeQuery();

			// Step 5: Iterate the resultset and extract the information.
			if (rs != null) {
				int c = 0;
				while (rs.next()) {
					long empNo = rs.getLong("EMP_NO");
					String name = rs.getString("NAME");
					double salary = rs.getDouble("SALARY");
					empArray[c] = new Employee(empNo, name, salary);
					c++;
				}
			}

			// Step 6: Close all the objects in the reverse order of its
			// creation.
			DBUtil.closeAllConnection(cn, ps, rs);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return empArray;
	}

	public Employee getEmployeeDetails(long empNo) {
		Employee emp = null;
		try {
			// Step 2: Create a Connection object
			Connection cn = DBUtil.createConnection();

			// Step 3: Create a PreparedStatement object using the Connection
			PreparedStatement ps = cn
					.prepareStatement("SELECT * FROM EMPLOYEE_111 WHERE EMP_NO=?");

			ps.setLong(1, empNo);

			// Step 4: Execute the query and store the result.
			ResultSet rs = ps.executeQuery();

			// Step 5: Iterate the resultset and extract the information.
			if (rs != null) {
				while (rs.next()) {
					long empno = rs.getLong("EMP_NO");
					String name = rs.getString("NAME");
					double salary = rs.getDouble("SALARY");
					emp = new Employee(empno, name, salary);
				}
			}

			// Step 6: Close all the objects in the reverse order of its
			// creation.
			DBUtil.closeAllConnection(cn, ps, rs);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return emp;
	}

	public boolean addEmployee(Employee emp) {

		boolean result = false;

		try {
			// Step 2: Create a Connection object
			Connection cn = DBUtil.createConnection();

			// Step 3: Create a PreparedStatement object using the Connection
			PreparedStatement ps = cn
					.prepareStatement("INSERT INTO EMPLOYEE_111 VALUES(?,?,?)");

			ps.setLong(1, emp.getEmpNo());
			ps.setString(2, emp.getName());
			ps.setDouble(3, emp.getSalary());

			// Step 4: Execute the query and store the result.
			int n = ps.executeUpdate();

			// Step 5: Check the query is success or fail.
			if (n > 0) {
				result = true;
			}

			// Step 6: Close all the objects in the reverse order of its
			// creation.
			DBUtil.closeAllConnection(cn, ps, null);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public boolean deleteEmployee(long empNo) {

		boolean result = false;

		try {
			// Step 2: Create a Connection object
			Connection cn = DBUtil.createConnection();

			// Step 3: Create a PreparedStatement object using the Connection
			PreparedStatement ps = cn
					.prepareStatement("DELETE FROM EMPLOYEE_111 WHERE EMP_NO=?");

			ps.setLong(1, empNo);

			// Step 4: Execute the query and store the result.
			int n = ps.executeUpdate();

			// Step 5: Check the query is success or fail.
			if (n > 0) {
				result = true;
			}

			// Step 6: Close all the objects in the reverse order of its
			// creation.
			DBUtil.closeAllConnection(cn, ps, null);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public boolean updateEmployeeSalary(long empNo, double increment) {

		boolean result = false;

		try {

			// Step 2: Create a Connection object
			Connection cn = DBUtil.createConnection();

			// Step 3: Create a PreparedStatement object using the Connection
			PreparedStatement ps = cn
					.prepareStatement("UPDATE EMPLOYEE_111 SET SALARY=SALARY + ? WHERE EMP_NO=?");

			ps.setDouble(1, increment);
			ps.setLong(2, empNo);

			// Step 4: Execute the query and store the result.
			int n = ps.executeUpdate();

			// Step 5: Check the query is success or fail.
			if (n > 0) {
				result = true;
			}

			// Step 6: Close all the objects in the reverse order of its
			// creation.
			DBUtil.closeAllConnection(cn, ps, null);

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return result;
	}

}
