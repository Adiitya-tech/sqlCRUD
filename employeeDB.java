package noSqlTable;

import java.util.Iterator;

public class employeeDB {
	private String userName ;
	private String pass ;
	private boolean connect ;
	int index ;
	
	Employee[] db = new Employee[10];

	public employeeDB() {
		super();
		// TODO Auto-generated constructor stub
	}

	public employeeDB(String userName, String pass) {
		super();
		this.userName = userName;
		this.pass = pass;
		
		connect = true ;
		System.out.println("Database Connected");
	}
	public void login(String userName , String pass) {
		
		if (this.userName.equals(userName) && this.pass.equals(pass)) {
			
			connect = true ;
			 System.out.println("Login Successfull");
		}
		else {
			System.out.println("Incorrect Details");
		}		
	}
      public boolean addEmplpoyee(String name, int empid, int deptNo, int manageNo, String hireDate,
			double salary, double comm, String job) {
		if (connect && index<7.5*db.length) {
			db[index]= new Employee(name, empid, deptNo, manageNo, hireDate, salary, comm, job);
			index ++;
			return true ;
		}
		else if (connect) {
			Employee[] temp = new Employee[db.length*2];
			
			for (int i = 0; i < db.length; i++) {
				temp[i]=db[i];
			}
			db=temp;
			db[index]=new Employee(name, empid, deptNo, manageNo, hireDate, salary, comm, job);
			index++;
			return true;
		}
		else {
			System.out.println("Could not resolve");
			return false ;
		}
	}
      public void showDb() {
    	  if (connect) {
			for (int i = 0; i < index; i++) {
				System.out.println(db[i]);
			}
		}
    	  else {
			System.out.println("Could not resolve");
		}
      }
      public void searchByJob(String job) 
      {
    	  if (connect) {
			for (int i = 0; i < index; i++) {
				if (db[i].job.equalsIgnoreCase(job)) {
					System.out.println(db[i]);
				}
			}
		}
      }
     public void showSalary(double sal , double comm) {
    	 if (connect) {
			for (int i = 0; i < index; i++) {
				if (db[i].salary == 1500.0 && db[i].comm==500.0) {
					System.out.println(db[i]);
				}
			}
		}
     }
     public void showCommission(double comm) {
    	 if (connect) {
			for (int i = 0; i < index; i++) {
				if (db[i].comm>100.0) {
					System.out.println(db[i]);
				}
			}
		}
     }
     public void employeWithoutMang(int deptNo) {
    	 if (connect) {
			for (int i = 0; i < index; i++) {
				if (db[i].deptNo != 20 ) {
				   System.out.println(db[i]);
				}
			}
		}
     }
     public void mangeId(int managerNo) {
    	 if (connect) {
    		 int cnt=0;
			for (int i = 0; i < index; i++) {
				if (db[i].manageNo == managerNo) {
					
					System.out.println(db[i]);
					cnt++;
				}
				else if(index-1==i && cnt==0) {
					System.out.println("not found");
				}
			}
		}
     }
     public void maxSalOfEmployee() {
    	 if (connect) {
    		 double max = 0;
    		 int maxIndex =0;
    		
			for ( int i = 0; i < index; i++) {
				if (db[i].salary > max) {
				maxIndex = i ;
					max = db[i].salary ;
				}
			}
			System.out.println(db[maxIndex]);
//			for (int i = 0; i < index; i++) {
//				if (db[i].salary == max) {
//					System.out.println(db[i]);
//				}
//			}
		}
     }
     public void secondMaxSalOfEmployee() {
    	 if (connect) {
    		 double max =0;
			double secondMax = 0;
			
			for ( int i = 0; i < index; i++) {
				if (db[i].salary > max) {
					secondMax= max;
					max = db[i].salary ;
				}
				else if (db[i].salary>secondMax && db[i].salary!=max) {
					
					
					secondMax = db[i].salary;
				}
			}
	       for (int i = 0; i < index; i++) {
			if (db[i].salary == secondMax) {
				System.out.println(db[i]);
			}
		}
			
	}
     }
     public void searchByCommison(double comm , char condi) {
    	 if (connect) {
			switch (condi) {
				case '<': {
					
					for (int i = 0; i < index; i++) {
						if (db[i].comm<comm) {
							System.out.println(db[i]);
						}
					}
					break;
				}
				case '>': {
					
					for (int i = 0; i < index; i++) {
						if (db[i].comm>comm) {
							System.out.println(db[i]);
						}
					}
					break;
				}
				case '=': {
		
					for (int i = 0; i < index; i++) {
						if (db[i].comm==comm) {
							System.out.println(db[i]);
						}
					}
					break;
				}
			default:
				throw new IllegalArgumentException("Unexpected value: " + condi);
			}
		}
     }
     public void sortBy(String attri) {
    	 if (attri == "empid" || attri == "deptNo" || attri == "manageNo"
    			 || attri=="salary") {
    		 for (int i = 0; i < index-1; i++) {
				for (int j = i+1; j < index-1-i; j++) {
					if (checkSwap(db[j], db[j+1], attri)>0) {
						Employee temp = db[j];
						db[j]=db[j+1];
						db[j+1]=temp;
						
					}
				}
			}
    		 
			
		}
    	 else {
			System.out.println("Attribute did Not Match");
		}
     }
     public int checkSwap(Employee e1 , Employee e2 , String Attri) {
    	 switch (Attri) {
		case "empid":  {
				return checkSwap0(e1.empid, e2.empid);
			}
		case "deptNo":  {
			return checkSwap0(e1.deptNo, e2.deptNo);
		}
		
		case "manageNo":  {
			return checkSwap0(e1.manageNo, e2.manageNo);
		}
		
		default:
			return -100;
		}
     }
     public static int checkSwap0(int n1 , int n2) {
    	 if (n1>n2) {
			return -1 ;
		}
    	 else if (n1<n2) {
			return 1;
		}
    	 else if (n1==n2) {
			return 0;
		}
    	   return -1000;
     }   
}

