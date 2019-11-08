import java.util.Scanner;
import java.util.Random;
public class Employee {

	protected String firstName;
	protected String lastName;
	protected int id;
	protected Scanner sc;
	private int type = 1;
	protected static int[] takenIds  = new int[50];
	protected Random rd;
	protected static int numberOfEmployees = 0;
	
	Employee(){
		sc = new Scanner(System.in);
		rd = new Random();
		this.setFirstName();
		this.setLastName();
		this.id = this.getRandomId();
		numberOfEmployees ++;
		System.out.println("Employee added: " + this.firstName + " " + this.lastName + " ");
		System.out.println("Employee ID: " + this.id);
	}
	Employee(String name,String lstname,int idnum){
		this.firstName = name;
		this.lastName = lstname;
		this.id = idnum;
		numberOfEmployees++;
		sc = new Scanner(System.in);
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
				case 0: break;
				default: break;
			}
		} while(userchoice != 0);	
	}
	public void setFirstName(){
		System.out.println("First Name: ");
		firstName = sc.next();
	}
	public void setLastName() {
		System.out.println("Last Name: ");
		lastName = sc.next();	
	}
	public void setId() {
		while(true) {
			System.out.println("Please input a new Employee ID");
			id = sc.nextInt();
			if(id > 9999) {
				System.out.println("Please enter an integer between 1000 and 9999");
			}
			else {
				break;
			}
		}
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getId() {
		return id;
	}
	public int getNumEmployees(){
		return numberOfEmployees;
	}
	
	public void printEmployee() {
		System.out.println("\n" + this.firstName + " " + this.lastName);
		System.out.println("Employee Id: " + this.id);
	}
	
	public static void printEditMenu(String firstName, String lastName, int type) {
		System.out.println("\nEditing " + firstName + " " + lastName);
		System.out.println("What would you like to edit?");
		System.out.println("(1) First Name");
		System.out.println("(2) Last Name");
		System.out.println("(3) Employee id");
		if(type == 2) {
		System.out.println("(4) Hourly Wage");
		System.out.println("(5) Add Hours");
		System.out.println("(6) Set Hours");
		}
		if(type == 3) {
		System.out.println("(4) Comission rate");
		System.out.println("(5) Add Sales");
		System.out.println("(6) Set Sales");
		}
		if(type == 4) {
		System.out.println("(4) Comission rate");
		System.out.println("(5) Add Sales");
		System.out.println("(6) Set Sales");
		System.out.println("(7) Set Salary");
		}
		System.out.println("(0) Exit");
		System.out.println("Make a Selection: ");
	}
	public int getType() {
		return this.type;
	}
	
	public int getRandomId() {
		boolean getOut = false;
		int newID = 0;
		while(getOut == false) {
			newID = rd.nextInt(8999) + 1000;
			for(int x = 0; x < takenIds.length; x++) {
				if(takenIds[x] == newID) {
					break;
				}
				else if(x == takenIds.length  - 1) {
					getOut = true;
				}
			}
		}
		return newID;
	}
	public String toStringEmployee() {
		return this.getFirstName() + " " + this.getLastName() + " Id: " + this.id ;
	}
}
