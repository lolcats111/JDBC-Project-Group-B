package starter.com.test;

import starter.com.bean.Employee;
import starter.com.service.EmployeeService;

public class EmployeeTeseter {
	public static void main(String[] args) {
		
		EmployeeService service=new EmployeeService();
		
		/*Employee[] arr=service.getAllEmployees();
		
		if(arr!=null) {
			System.out.println("================ Employee List ================");
			
			for(Employee employee:arr) {
				if(employee!=null) {
					System.out.println(employee.getEmpNo()+":"+employee.getName()+":"+employee.getSalary());
				}
			}
		}
		
		System.out.println("================ Employee Search Result ================");
		Employee e=service.getEmployeeDetails(10009);
		if(e!=null) {
			System.out.println(e.getEmpNo()+":"+e.getName()+":"+e.getSalary());
		} else {
			System.out.println("Employee not found!!!");
		}
		
		System.out.println("================ Employee Insertion ================");
		Employee emp=new Employee(10006,"Cherry",2900.00);
		boolean t=service.addEmployee(emp);
		if(t==true) {
			System.out.println("Employee inserted successfully...");
		} else {
			System.out.println("Employee insertion failed...");
		}
		
		
		System.out.println("================ Employee Deletion ================");
		boolean flag=true;
		
		flag=service.deleteEmployee(10009);
		if(flag==true) {
			System.out.println("Employee deleted successfully...");
		} else {
			System.out.println("Employee deletion failed...");
		}*/
		
		System.out.println("================ Employee Updation ================");
		double salary=service.updateEmployeeSalary(10003, 10000.00);
		System.out.println("New Salary:"+salary);
		
	}
}
