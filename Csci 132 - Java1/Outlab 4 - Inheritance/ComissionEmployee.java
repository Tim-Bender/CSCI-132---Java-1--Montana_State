public class ComissionEmployee extends Employee {
	
	protected double comissionRate;
	protected double totalSales;
	protected int type = 3;
	protected double incomeFromSales;
	protected static double salesForAllEmployees = 0;
	
	ComissionEmployee(){
		this.setComissionRate();
		this.totalSales = 0;
		this.incomeFromSales = 0;
	}
	
	public void printEmployee() {
		super.printEmployee();
		System.out.println("Comission rate: " + this.comissionRate);
		System.out.println("Total sales: " + this.totalSales);
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
				case 0: break;
				default: break;
			}
		} while(userchoice != 0);
		
	}
	public void setComissionRate() {
		System.out.println("Comission Rate: ");
		comissionRate = sc.nextDouble();
	}
	public void setSales() {
		salesForAllEmployees -= this.totalSales;
		System.out.println("Set Sales: ");
		totalSales = sc.nextInt();
		salesForAllEmployees += totalSales;
		
		incomeFromSales = totalSales * comissionRate;
	}
	public void addSales() {
		salesForAllEmployees -= this.totalSales;
		System.out.println("Sales: ");
		totalSales += sc.nextInt();
		incomeFromSales += totalSales * comissionRate;
		salesForAllEmployees += totalSales;
	}
	public double getComissionRate() {
		return comissionRate;
	}
	public double getTotalSales() {
		return totalSales;
	}
	public double getIncomeFromSales() {
		return incomeFromSales;
	}
	public int getType() {
		return this.type;
	}
	public double getSalesForAll() {
		return salesForAllEmployees;
	}
}
