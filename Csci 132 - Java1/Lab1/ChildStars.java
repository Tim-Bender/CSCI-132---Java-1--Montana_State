
public class ChildStars {
	
	//Instance fields
	//Note that the averageFine will need to be edited to be a local variable.
	private String name;
	private int moneyEarned;
	private int numberOfArrests;
	
	//Constructor 
	ChildStars(String starname,int money,int arrests){
		name = starname;
		moneyEarned = money;
		numberOfArrests = arrests;
	}
	//Method for determining how much money is left. 
	public int moneyLeft(int x) {
		return (moneyEarned - (numberOfArrests * x));
	}
	//The summary method will print out the description of our child star.
	public void summary(int x) {
		System.out.println(name +" has been arrested " + numberOfArrests +" times and has $" + moneyLeft(x));
	}
}