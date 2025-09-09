package noSqlTable;

public class employeedbDriver {
	
	public static void main(String[] args) {
		employeeDB e1 = new employeeDB("Aditya", "Boss");
		e1.login("Aditya","Boss");
		e1.addEmplpoyee("Smith", 7369, 20, 7902, "17/12/1980", 800.0, 100.0, "clerk");
		e1.addEmplpoyee("Allen", 7499, 30, 7698, "10/06/1981", 1600.0, 110.0, "salesman");
		e1.addEmplpoyee("ward", 7521, 30, 7698, "10/06/1981", 1250.0, 100.0, "salesman");
		e1.addEmplpoyee("Jones", 7566, 20, 7839, "10/06/1981", 2975.0, 100.0, "Manager");
		e1.addEmplpoyee("Martin", 7654, 30, 7698, "10/06/1981", 1250.0, 100.0, "salesman");
		e1.addEmplpoyee("Blake", 7698, 30, 7839, "10/06/1981", 2850.0, 200.0, "Manager");
		e1.addEmplpoyee("Clark", 7782, 10, 7839, "10/06/1981", 2450.0, 300.0, "Manager");
		e1.addEmplpoyee("Scott", 7788, 20, 7566, "10/06/1987", 3000.0, 100.0, "Analyst");
		e1.addEmplpoyee("King", 7839, 10, -1, "10/06/1981", 5000.0, 100.0, "President");
		e1.addEmplpoyee("Turner", 744, 30, 7698, "10/06/1981", 1500.0, 500.0, "salesman");
		e1.addEmplpoyee("Adams", 7876, 20, 7788, "10/06/1987", 1100.0, 100.0, "clerk");
		e1.addEmplpoyee("James", 7900, 30, 7698, "10/06/1981", 950.0, 600.0, "clerk");
		e1.addEmplpoyee("ford", 7902, 20, 7566, "10/06/1981", 3000.0, 100.0, "Analyst");
		e1.addEmplpoyee("Miller", 7934, 10, 7782, "10/06/1982", 1300.0, 90.0, "clerk");
		
//	    e1.secondMaxSalOfEmployee();
//		e1.searchByCommison(100.0,'=');
		e1.sortBy("empid");
	    

	
		
	}
}
