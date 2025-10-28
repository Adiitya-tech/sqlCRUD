package sqlQueriesLogics;

public class EmployeeDBDriver {
	public static void main(String[] args) {
		
		EmployeeDB db = new EmployeeDB("Oracle", "Oracle@47");
		
		db.login("Oracle", "Oracle@47");
		
		System.out.println();
		db.addEmployee("Smith", 7369, 20, 7902, "Clerk", "17/12/1980", 800.0, 0.0);
		db.addEmployee("Allen", 7499, 30, 7698, "Salesman", "20/02/1981", 1600.0, 300.0);
		db.addEmployee("Ward", 7521, 30, 7698, "Salesman", "22/20/1981", 1600.0, 300.0);
		db.addEmployee("Jones", 7566, 20, 7839, "Manager", "02/04/1981", 2975.0, 0.0);
		db.addEmployee("Martin", 7654, 30, 7698, "Salesman", "28/09/1981", 1250.0, 1400.0);
		db.addEmployee("Blake", 7698, 30, 7839, "Manager", "01/05/1981", 2850.0, 0.0);
		db.addEmployee("Clark", 7782, 10, 7839, "Manager", "09/06/1981", 2450.0, 0.0);
		db.addEmployee("Scott", 7788, 20, 7566, "Analyst", "19/04/1987", 3000.0, 0.0);
		db.addEmployee("King", 7839, 10, -1, "President", "17/11/1981", 5000.0, 0.0);
		db.addEmployee("Turner", 744, 30, 7698, "Salesman", "08/09/1981", 1500.0, 0.0);
		db.addEmployee("Adams", 7876, 20, 7788, "Clerk", "23/05/1987", 1100.0, 0.0);
		db.addEmployee("James", 7900, 30, 7698, "Clerk", "03/12/1981", 950.0, 0.0);
		db.addEmployee("Ford", 7902, 20, 7566, "Analyst", "03/12/1981", 3000.0, 0.0);
		db.addEmployee("Miller", 7934, 10, 7782, "Clerk", "23/01/1982", 1300.0, 0.0);
		
//		db.showDB();
		
//		db.searchByJob("manager");
//		
//		db.searchByDeptNo(20);
//		
//		db.searchBySalEqualsTo(1600);
//		
//		db.searchBySalLessThanEqualsTo(1000);
//		
//		db.searchBySalGreaterThanEqualsTo(3000);
//		
//		db.empWorkingUnderManager("blake");
//		
//		db.showEmpCommEqualsTo(300);
//		
//		db.showEmpCommGreaterEqualsTo(500);
//		
//		db.showEmpCommLessEqualsTo(300);
//		
//		db.empNotWorkingUnderManager("jones");
//		
//		db.empMaxSal();
//		
//		db.empMinSal();
//		
//		db.empSecMaxSal();
//		
//		db.empSecMinSal();
		
//		db.getCount();
		
		db.sortBy("name");
		db.showDB();
	}
}
