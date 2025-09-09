package noSqlTable;

public class Employee {
	
	String name ;
	int empid ;
	int deptNo ;
	int manageNo ;
	String hireDate ;
	double salary ;
	double comm ;
	String job ;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, int empid, int deptNo, int manageNo, String hireDate,
			double salary, double comm, String job) {
		super();
		this.name = name;
		this.empid = empid;
		this.deptNo = deptNo;
		this.manageNo = manageNo;
		this.hireDate = hireDate;
		this.salary = salary;
		this.comm = comm;
		this.job = job;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empid=" + empid + ", deptNo=" + deptNo + ", manageNo=" + manageNo
				+ ", hireDate=" + hireDate + ", salary=" + salary + ", comm=" + comm + ", job=" + job + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
