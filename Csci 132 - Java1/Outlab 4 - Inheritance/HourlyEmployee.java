public class HourlyEmployee extends Employee{

	private int wage;
	private int hoursWorked;
	private static int numHourlyEmployees = 0;
	private int type = 2;
	
	HourlyEmployee(){
		numHourlyEmployees++;
		this.setWage();
		this.hoursWorked = 0;
	}
	
	public void printEmployee() {
		super.printEmployee();
		System.out.println("Wage: " + this.wage + " /hr");
		System.out.println("Hours: " + this.hoursWorked );
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
				case 4: this.setWage(); break;
				case 5: this.addHours(); break;
				case 6: this.setHours(); break;
				case 0: break;
				default: break;
			}
		} while(userchoice != 0);
		
	}
	
	public void setWage() {
		System.out.println("Wage: ");
		wage = sc.nextInt();
	}
	public void setHours() {
		System.out.println("Hours: ");
		hoursWorked = sc.nextInt();
	}
	public void addHours() {
		System.out.println("Number of hours to add");
		hoursWorked += sc.nextInt();
	}
	public int getWage() {
		return wage;
	}
	public int getHours() {
		return hoursWorked;
	}
	public int getnumHourlyEmployees() {
		return numHourlyEmployees;
	}
	public int getType() {
		return this.type;
	}
}
