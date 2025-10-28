package sqlQueriesLogics;

import java.util.Iterator;

public class EmployeeDB {
	private String userName;
	private String pass;
	private boolean isConnected;
	private int empCount = 0;
	private int index = 0;
	private Employee[] db = new Employee[10];
	
//	private EmployeeDB() {
//		// TODO Auto-generated constructor stub
//	}
	
//	To Create Database
	public EmployeeDB(String userName, String pass) {
		super();
		this.userName = userName;
		this.pass = pass;
		System.out.println("Database Created!");
		
	}
	
//	To Login the Database
	public void login(String userName, String pass) {
		if (this.userName.equals(userName) && this.pass.equals(pass)) {
			isConnected = true;
			
			System.out.println("Database Connected! :-)");
			System.err.println("-------------------------------------------------");

		}
		else {
			System.err.println("Invalid Credentials! :-(");
		}
	}
	
//	To add the Employee
	public boolean addEmployee(String name, int empID, int deptNo, int managerNo, 
			String jobRole,String hireDate, double sal, double comm) {
		if (isConnected && empCount < 0.75*db.length) {
		
			db[index] = new Employee(name, empID, deptNo, managerNo,jobRole,
					hireDate, sal, comm);
			
			empCount++;
			index++;
			
			System.out.println(name + " Employee Added!");
			return true;
		}
		else if(isConnected){
			Employee[] temp = new Employee[db.length*2];
			
			for (int i = 0; i < db.length; i++) {
				temp[i] = db[i];
			}
			
			db = temp;
			
			db[index] = new Employee(name, empID, deptNo, managerNo,jobRole, 
					hireDate, sal, comm);
			
			empCount++;
			index++;
			
			System.out.println(name + " Employee Added!");
			return true;
		}
		else {
			System.err.println("Login First :-(");
			return false;
		}
	}
	
	
//	SQL Queries Logics
	
//	Logic Behind show the Database Query
	public void showDB() {
		System.out.println();
		if (isConnected) {
			for (int i = 0; i < empCount; i++) {
				System.out.println(db[i]);
			}
		}
		else if(empCount==0){
			System.err.println("Add Employee in database First");
		}
		else {
			System.err.println("Invalid Credentials :-(");
		}
	}
	
	
//	Logic behind displayByJob Query
	public void searchByJob(String job) {
		if (isConnected) {
			System.out.println();
			System.out.println("Search By there Job Role: " + job);
			int cnt = 0;
			for (int i = 0; i < empCount; i++) {
				if (db[i].jobRole.equalsIgnoreCase(job)) {
					System.out.println(db[i]);
					cnt++;
				}
				else if(cnt==0 && i == empCount-1) {
					System.err.println("Value Not Found!");
				}
			}
		}
		else {
			System.err.println("Login First :-(");
		}
	}
	
//	Logic Behind searchByDeptNo Query
	public void searchByDeptNo(int deptNo) {
		if (isConnected) {
			System.out.println();
			System.out.println("Search By there Dept No. : " + deptNo);
			int cnt = 0;
			for (int i = 0; i < empCount; i++) {
				if (db[i].deptNo == deptNo) {
					System.out.println(db[i]);
					cnt++;
				}
				else if(cnt==0 && i == empCount-1) {
					System.err.println("Value Not Found!");
				}
			}
		}
		else {
			System.err.println("Login First :-(");
		}
	}
	
//	Logic Behind searchBySalEqualsTo Query
	public void searchBySalEqualsTo(int sal) {
		if (isConnected) {
			System.out.println();
			System.out.println("Search By there Salary is Equals to : " + sal);
			int cnt = 0;
			for (int i = 0; i < empCount; i++) {
				if (db[i].sal == sal) {
					System.out.println(db[i]);
					cnt++;
				}
				else if(cnt==0 && i == empCount-1) {
					System.err.println("Value Not Found!");
				}
			}
		}
		else {
			System.err.println("Login First :-(");
		}
	}
	
//	Logic Behind searchBySalLessThanEqualsTo Query
	public void searchBySalLessThanEqualsTo(int sal) {
		if (isConnected) {
			System.out.println();
			System.out.println("Search By there Salary is Less than : " + sal);
			int cnt = 0;
			for (int i = 0; i < empCount; i++) {
				if (db[i].sal <= sal) {
					System.out.println(db[i]);
					cnt++;
				}
				else if(cnt==0 && i == empCount-1) {
					System.err.println("Value Not Found!");
				}
			}
		}
		else {
			System.err.println("Login First :-(");
		}
	}
	
//	Logic Behind searchBySalGreaterThanEqualsTo Query
	public void searchBySalGreaterThanEqualsTo(int sal) {
		if (isConnected) {
			System.out.println();
			System.out.println("Search By there Salary is Greater than : " + sal);
			int cnt = 0;
			for (int i = 0; i < empCount; i++) {
				if (db[i].sal >= sal) {
					System.out.println(db[i]);
					cnt++;
				}
				else if(cnt==0 && i == empCount-1) {
					System.err.println("Value Not Found!");
				}
			}
		}
		else {
			System.err.println("Login First :-(");
		}
	}
	
	
	
//	Logic Behind empWorkingUnderManager Query
	private int empID(String name) {
		if (isConnected) {
			for (int i = 0; i < empCount; i++) {
				if (db[i].name.equalsIgnoreCase(name)) {
					return db[i].empID;
				}
			}
			System.out.println("Value not match!");
			return -1;
		}
		else {
			System.err.println("Login First :-(");
			return -1;
		}
	}
	
	public void empWorkingUnderManager(String name) {
		if (isConnected) {
			System.out.println();
			System.out.println("Employee Working Under Manager : " + name);
			if (empID(name) > 0) {
				int cnt = 0;
				for (int i = 0; i < empCount; i++) {
					if (empID(name) == db[i].managerNo) {
						System.out.println(db[i]);
						cnt++;
					}
					else if(cnt==0 && i == empCount-1) {
						System.err.println("No Employee Records!");
					}
				}
			}
		}
		else {
			System.err.println("Login First :-(");
		}
	}
	
//	Logic Behind showEmpCommEqualsTo Query
	public void showEmpCommEqualsTo(int comm) {
		if (isConnected) {
			System.out.println();
			System.out.println("Employee Whos Commission is Equals to : " + comm);
			int cnt = 0;
			for (int i = 0; i < empCount; i++) {
				if (db[i].comm == comm) {
					System.out.println(db[i]);
					cnt++;
				}
				else if(cnt==0 && i == empCount-1) {
					System.err.println("Value Not Found!");
				}
			}
		}
		else {
			System.err.println("Login First :-(");
		}
	}
	
//	Logic Behind showEmpCommLessEqualsTo Query
	public void showEmpCommLessEqualsTo(int comm) {
		if (isConnected) {
			System.out.println();
			System.out.println("Employee Whos Commission is Equals to : " + comm);
			int cnt = 0;
			for (int i = 0; i < empCount; i++) {
				if (db[i].comm <= comm) {
					System.out.println(db[i]);
					cnt++;
				}
				else if(cnt==0 && i == empCount-1) {
					System.err.println("Value Not Found!");
				}
			}
		}
		else {
			System.err.println("Login First :-(");
		}
	}
	
//	Logic Behind showEmpCommGreaterEqualsTo Query
	public void showEmpCommGreaterEqualsTo(int comm) {
		if (isConnected) {
			System.out.println();
			System.out.println("Employee Whos Commission is Equals to : " + comm);
			int cnt = 0;
			for (int i = 0; i < empCount; i++) {
				if (db[i].comm >= comm) {
					System.out.println(db[i]);
					cnt++;
				}
				else if(cnt==0 && i == empCount-1) {
					System.err.println("Value Not Found!");
				}
			}
		}
		else {
			System.err.println("Login First :-(");
		}
	}
	
//	Logic Behind empNotWorkingUnderManager Query
	public void empNotWorkingUnderManager(String name) {
		if (isConnected) {
			System.out.println();
				System.out.println("Employee Not Working Under Manager");
				int cnt = 0;
				for (int i = 0; i < empCount; i++) {
					if (db[i].managerNo == -1) {
						System.out.println(db[i]);
						cnt++;
					}
					else if(cnt==0 && i == empCount-1) {
						System.err.println("Value Not Found!");
					}
				}
		}
		else {
			System.err.println("Login First :-(");
		}
	}
	
//	Logic Behind the empMaxSal Query
	public void empMaxSal() { 
		if (isConnected) {
			if (empCount>0) {
				System.out.println("\nEmployee whos Max Sallary");
				double max = 0;
				int i = 0, index1 = -1;
				for (i = 0; i < empCount; i++) {
					if (db[i].sal > max) {
						max = db[i].sal;
						index1 = i;
					}
				}
				System.out.println(db[index1]);
			}
			else {
				System.out.println("Add Rows First");
			}
		}
		else {
			System.err.println("Login First :-(");
		}
	}
	
//	Logic Behind the empMinSal Query
	public void empMinSal() { 
		if (isConnected) {
			if (empCount>0) {
				System.out.println("\nEmployee whos Min Sallary");
				double min = Double.MAX_VALUE;
				int i = 0, index2 = -1;
				for (i = 0; i < empCount; i++) {
					if (db[i].sal < min) {
						min = db[i].sal;
						index2 = i;
					}
				}
				System.out.println(db[index2]);
			}
			else {
				System.out.println("Add Rows First");
			}
		}
		else {
			System.err.println("Login First :-(");
		}
	}
	
//	Logic Behind the empSecMaxSal Query
	public void empSecMaxSal() {
		if (isConnected) {
			if (empCount > 1) {
				System.out.println("\nEmployee whos Second Max Sallary");
				double max = 0, secMax = 0;
				int index3 = -1, index4 = -1;
				for (int i = 0; i < empCount; i++) {
					if (db[i].sal > max) {
						secMax = max;
						max = db[i].sal;
						index3 = index4;
						index4 = i;
					}
					else if(db[i].sal > secMax && max != db[i].sal) {
						secMax = db[i].sal;
						index3 = i;
					}
				}
				System.out.println(db[index3]);
			}
			else {
				System.out.println("\nAdd at least 2 Rows for 2nd Max");
			}
		}
		else {
			System.err.println("Login First :-(");
		}
	}
	
//	Logic Behind the empSecMinSal Query
	public void empSecMinSal() {
		if (isConnected) {
			if (empCount > 1) {
				System.out.println("\nEmployee whos Second Min Sallary");
				double min = 0, secMin = Double.MAX_VALUE;
				int index3 = -1, index4 = -1;
				for (int i = 0; i < empCount; i++) {
					if (db[i].sal < min) {
						secMin = min;
						min = db[i].sal;
						index3 = index4;
						index4 = i;
					}
					else if(db[i].sal < secMin && min != db[i].sal) {
						secMin = db[i].sal;
						index3 = i;
					}
				}
				System.out.println(db[index3]);
			}
			else {
				System.out.println("\nAdd at least 2 Rows for 2nd Min");
			}
		}
		else {
			System.err.println("Login First :-(");
		}
	}
	
//	To fetch the count of rows in database
	public void getCount() {
		if (isConnected) {
			System.out.println("\nCount is : " + empCount);
		}
		else {
			System.err.println("Login First :-(");
		}
	}
	
//	Sorting By Any Attribute
	
//	Check which number is Bigger
	private int checkSwap0(double n1, double n2) {
		if (n1 > n2) {
			return 1; // n1 is bigger
		}
		else if(n1 < n2) {
			return -1; // n2 is bigger
		}
		else {
			return 0; // both are same
		}
	}
	
	
	private int checkSwap(String attr, Employee e1, Employee e2) {
		switch (attr) {
		case "empID":
		{
			return checkSwap0(e1.empID, e2.empID);
		}
		case "sal":
		{
			return checkSwap0(e1.sal, e2.sal);
		}
		case "managerNo":
		{
			return checkSwap0(e1.managerNo, e2.managerNo);
		}
		case "deptNo":
		{
			return checkSwap0(e1.deptNo, e2.deptNo);
		}
		case "comm":
		{
			return checkSwap0(e1.comm, e2.comm);
		}
		case "name":
		{
			return e1.name.compareTo(e2.name);
		}
		case "jobRole":
		{
			return e1.jobRole.compareTo(e2.jobRole);
		}
			

		default:
			return -100;
		}
	}
	
//	Sort By Any Attribute
	public void sortBy(String attr) {
		if (attr == "empID" || attr == "sal" || attr == "deptNo" || attr == "managerNo"
				|| attr == "name" || attr == "jobRole" || attr == "comm") {
			
//			Bubble Sort
			for (int i = 0; i < empCount-1; i++) {
				for (int j = 0; j < empCount-1-i; j++) {
					if (checkSwap(attr, db[j], db[j+1]) > 0) {
						
						Employee temp = db[j];
						db[j] = db[j+1];
						db[j+1] = temp;
						
					}
				}
			}
		}
		else {
			System.out.println("Attribute is not Comparable!");
		}
	}
	
}
