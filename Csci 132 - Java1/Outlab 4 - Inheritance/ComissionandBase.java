public class ComissionandBase extends ComissionEmployee {
	
	private int salary;
	private int type = 4;
	private static int numberofCBEmployees = 0;
	ComissionandBase(){
		this.setSalary();
		numberofCBEmployees ++;
	}
	
	public void printEmployee() {
		super.printEmployee();
		System.out.println("Salary: $" + this.salary);
	}
	
	public void editEmployee() {
		int userchoice;
		do {
			printEditMenu(this.firstName, this.lastName,this.type);
			userchoice = sc.nextInt();
			
			switch(userchoice) {
				case 1: this.setFirstName(); break;
				case 2: this.setLastName(); break;
				case 3: this.setId(); break; 
				case 4: this.setComissionRate(); break;
				case 5: this.addSales(); break;
				case 6: this.setSales(); break;
				case 7: this.setSalary(); break;
				case 0: break;
				default: break;
			}
		} while(userchoice != 0);
		
	}
	
	public void setSalary() {
		System.out.println("Salary: ");
		salary = sc.nextInt();
	}
	public void addToSalary() {
		System.out.println("Add to Salary: ");
		salary += sc.nextInt();
	}
	public int getSalary() {
		return salary;
	}
	public int getType() {
		return this.type;
	}
}
