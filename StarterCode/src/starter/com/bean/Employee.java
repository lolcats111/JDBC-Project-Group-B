package starter.com.bean;

public class Employee {
	long empNo;
	String name;
	double salary;
	
	public long getEmpNo() {
		return empNo;
	}
	public void setEmpNo(long empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Employee(long empNo, String name, double salary) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.salary = salary;
	}
	public Employee() {

	}
	
}
