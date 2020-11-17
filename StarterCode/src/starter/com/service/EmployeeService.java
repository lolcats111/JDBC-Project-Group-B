package starter.com.service;

import starter.com.bean.Employee;
import starter.com.dao.EmployeeDao;

public class EmployeeService {
	
	//Get all employees
	public Employee[] getAllEmployees() {
		EmployeeDao dao=new EmployeeDao();
		return dao.getAllEmployees();
	}
	
	//Get employee details based on the empno passed as parameter
	public Employee getEmployeeDetails(long empNo) {
		EmployeeDao dao=new EmployeeDao();
		return dao.getEmployeeDetails(empNo);
	}
	
	//Add new employee to the application
	public boolean addEmployee(Employee e) {
		EmployeeDao dao=new EmployeeDao();
		return dao.addEmployee(e);
	}
	
	//Delete the employee which is passed as parameter
	public boolean deleteEmployee(long empNo) {
		EmployeeDao dao=new EmployeeDao();
		return dao.deleteEmployee(empNo);
	}
	
	//Update salary for the employee passed in the parameter
	public double updateEmployeeSalary(long empNo, double increment) {
		double newSalary=0;
		EmployeeDao dao=new EmployeeDao();
		boolean t=dao.updateEmployeeSalary(empNo, increment);
		if(t==true) {
			Employee e=getEmployeeDetails(empNo);
			newSalary=e.getSalary();
		}
		return newSalary;
	}
}
