package sqlQueriesLogics;

/*
 * PROGRAM 48:
 * To design the Logics of SQL Queries in Java.
 * */
public class Employee {
	String name;
	int empID;
	int deptNo;
	int managerNo;
	String jobRole;
	String hireDate;
	double sal;
	double comm;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int empID, int deptNo, int managerNo, 
			String jobRole, String hireDate, double sal, double comm) {
		super();
		this.name = name;
		this.empID = empID;
		this.deptNo = deptNo;
		this.managerNo = managerNo;
		this.jobRole = jobRole;
		this.hireDate = hireDate;
		this.sal = sal;
		this.comm = comm;
	}
	
	@Override
	public String toString() {
		return "[name= "+name+", empID= "+empID+", deptNo= "+deptNo+", managerNo= "
				+managerNo+", jobRole= "+jobRole+", hireDate= "+hireDate+", sal="+sal+", "
				+ "comm= "+comm+"]";
	}
	
	
}
