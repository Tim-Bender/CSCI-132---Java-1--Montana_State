import java.util.Scanner;
	public class StackStringCounter {
	
	String s;
	Scanner sc = new Scanner(System.in);
	char array[] = new char[20];
	int index = 0;
	
	public void beginFun()
		{
		String input;
		do{
			System.out.println("Please input a String");
			input = sc.nextLine();
			for(int x = 0;x < input.length(); x++) {
				push(input.charAt(x));
			}
			
			if(array[0] == '\u0000') {
				System.out.println("Accepted");
			}
			else {
				System.out.println("Rejected");
			}
	
		}while(!input.equals("-1"));
		
		
		
		}
	private void pop(){
		array[index] = '\u0000';
		index --;
	
	}
	private void push(char toAdd){
		if(index != -1) {
			array[index] = toAdd;
			if(index != 0) {
				if(array[index] != array[index - 1]) {
					pop();
					pop();
				}
			}
			index ++;
		}
		
		
	}
	public static void main(String[] args) {
	
	
	new StackStringCounter().beginFun();
	
	
	}
	
	
}
