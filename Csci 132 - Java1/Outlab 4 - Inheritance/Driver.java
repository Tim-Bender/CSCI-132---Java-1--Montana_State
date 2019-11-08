/*
 * Author: Timothy Bender -02515767
 * Outlab - Inheritance
 * 11/01/2019
 */
import java.util.Scanner;
public class Driver {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int userinput;
		Scanner sc = new Scanner(System.in);
		
		//Four arrays will be used to store the employees. Note: It is possible to add an employee with only their first and last name.
		Employee[] employees = new Employee[100];
		ComissionEmployee[] comissionEmployees = new ComissionEmployee[100];
		HourlyEmployee[] hourlyEmployees = new HourlyEmployee[100];
		ComissionandBase[] cAndBemployees = new ComissionandBase[100];
		
		Employee em = new Employee("","",0);
		
		//MASTER DO WHILE LOOP
		do {
			printMenu();
			userinput = sc.nextInt();
			//MASTER SWITCH
			switch (userinput) {
				case 0: System.out.println("Exiting..."); break;
				case 1: 
					employees[em.getNumEmployees()] = new Employee(); ;
					break;
				case 2:
					hourlyEmployees[em.getNumEmployees()] = new HourlyEmployee();
					break;
				case 3:
					comissionEmployees[em.getNumEmployees()] = new ComissionEmployee();
					break;	
				case 4:
					cAndBemployees[em.getNumEmployees()] = new ComissionandBase();
					break;
				case 5:
					searchEmployee(employees,comissionEmployees,hourlyEmployees,cAndBemployees,0);
					break;	
				case 6:
					searchEmployee(employees,comissionEmployees,hourlyEmployees,cAndBemployees,1);
					break;	
				case 7:
					printSales(comissionEmployees,cAndBemployees); 
					break;	
				case 8:
					searchEmployee(employees,comissionEmployees,hourlyEmployees,cAndBemployees,2);
					break;	
				default: System.out.println("Please choose from the menu");
					
			}
			
		} while(userinput != 0);
		sc.close();

	}
	
	public static void printMenu() {
		System.out.println("\nMain Menu\n");
		System.out.println("(1) Add an employee");
		System.out.println("(2) Add an hourly employee");
		System.out.println("(3) Add a comission employee");
		System.out.println("(4) Add a comission and salary employee");
		System.out.println("(5) Edit employee info");
		System.out.println("(6) Lookup Employee info");
		System.out.println("(7) Print Sales Report -Per Employee-");
		System.out.println("(8) Print Employees");
		System.out.println("(0) Exit");
		System.out.println("Make a Selection: ");
	}
	/*
	Search employee (the method below) is designed to condense 3 of the options above into one function. namely options #5,6,8
	It will be used to search for employees through the four different arrays. As such it is divided into four while loops. 
	
	If we are looking to edit an employee, an integer 0 will be passed in letting the method know we are in edit mode, it will then
	loop through, find the employee and call .editEmployee(); a boolean value will then be changed so that none of the other arrays are searched
	
	If we are looking to print employee information, an integer of 1 will be passed; setting the method to print mode. like above we will search
	for the employee, and then print their information.
	
	Finally this method will be used to print the entire list of employees if desired. It will loop through each array and print each employee 
	it finds. In this case it will be passed an integer of 2. 
	
	Each while loop is identicle, except for the array they search.
	
	*/
	public static void searchEmployee(Employee[] employees,ComissionEmployee[] comissionEmployees,HourlyEmployee[] hourlyEmployees,ComissionandBase[] cAndBemployees,int editOrView) {
		Scanner sc = new Scanner(System.in);
		int employeeToEdit = 0;
		if(editOrView != 2) {
			System.out.println("Enter employee id: ");
			employeeToEdit = sc.nextInt();;
		}
		int iter = 0;
		boolean done = false;
		
		while(iter != employees.length && done == false) {
			if(employees[iter] != null) {//check its not null
				if(editOrView != 2) { //if we are printing the list of employees we skip this block
					if(employees[iter].getId() == employeeToEdit && employees[iter] != null) { //final test to see if the id's match, 
						if(editOrView == 0)  									//if we are looking to edit or print a specific employee's info
						employees[iter].editEmployee();
						else if(editOrView == 1)
							employees[iter].printEmployee();
						done = true;
						break;
					}
				}
				else {	//this will print out the employee's name and id if we are printing the list of employees
					System.out.println(employees[iter].toStringEmployee());
				}
			}
			iter ++;
		}
		iter = 0;
		
		while(iter != hourlyEmployees.length && done == false) {
			if(hourlyEmployees[iter] != null) {
				if(editOrView != 2) {
					if(hourlyEmployees[iter].getId() == employeeToEdit && hourlyEmployees[iter] != null) {
						if(editOrView == 0)
							hourlyEmployees[iter].editEmployee();
						else if(editOrView == 1)
							hourlyEmployees[iter].printEmployee();
						done = true;
						break;
					}
				}
				else {
					System.out.println(hourlyEmployees[iter].toStringEmployee());
				}
			}
			iter ++;
		}
		iter = 0;
		
		while(iter != comissionEmployees.length && done == false) {
			if(comissionEmployees[iter] != null) {
				if(editOrView != 2) {
					if(comissionEmployees[iter].getId() == employeeToEdit && comissionEmployees[iter] != null) {
						if(editOrView == 0)
							comissionEmployees[iter].editEmployee();
						else if(editOrView == 1)
							comissionEmployees[iter].printEmployee();
						done = true;
						break;
					}
				}
				else {
					System.out.println(comissionEmployees[iter].toStringEmployee());
				}
			}
			iter ++;
		}
		iter = 0;
		
		while(iter != cAndBemployees.length && done == false) {
			if(cAndBemployees[iter] != null) {
				if(editOrView != 2) {
					if(cAndBemployees[iter].getId() == employeeToEdit && cAndBemployees[iter] != null) {
						if(editOrView == 0)
							cAndBemployees[iter].editEmployee();
						else if(editOrView == 1)
							cAndBemployees[iter].printEmployee();
						done = true;
						break;
					}
				}
				else {
					System.out.println(cAndBemployees[iter].toStringEmployee());
				}
			}
			iter ++;
		}
	}
	
	/*
	 * below printSales is used when someone wants a detailed report of total sales by comission employee. It will also display the total sales for all 
	 * comission employees
	 * If there are no employees, and therefore no sales it will let you know.
	 */
	
	public static void printSales(ComissionEmployee[] comissionEmployees,ComissionandBase[] cAndBemployees) {
		boolean empty = true;
		boolean firstEmployee = true;
		ComissionandBase temp1 = null;
		ComissionEmployee temp2 = null;
		for(int x = 0; x < comissionEmployees.length;x++) {
			if(comissionEmployees[x] != null) {
				if(firstEmployee == true) {
					temp2 = comissionEmployees[x];
					firstEmployee = false;
					empty = false;
				}
				System.out.println(comissionEmployees[x].getFirstName() + " " + comissionEmployees[x].getLastName() + " Employee Id: " + comissionEmployees[x].getId());
				System.out.println("Personal sales total to: $" + comissionEmployees[x].getTotalSales() + "\n");
			}
		}
		for(int x = 0; x < cAndBemployees.length;x++) {
			if(cAndBemployees[x] != null) {
				if(firstEmployee == true) {
					temp1 = cAndBemployees[x];
					firstEmployee = false;
					empty = false;
				}
				System.out.println(cAndBemployees[x].getFirstName() + " " + cAndBemployees[x].getLastName() + " Employee Id: " + cAndBemployees[x].getId());
				System.out.println("Personal sales total to: $" + cAndBemployees[x].getTotalSales());
			}
		}
		if(empty == true) {
			System.out.println("No employees!");
		}
		else {
			if(temp1 != null) {
				System.out.println("Total Sales Between Employees is: $" + temp1.getSalesForAll());
			}
			else if(temp2 != null) {
				System.out.println("Total Sales Between Employees is: $" + temp2.getSalesForAll());
			}
		}
		
	}
	
}
