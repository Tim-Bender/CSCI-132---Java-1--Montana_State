import java.util.Random;
public class Main {

	public static void main(String[] args) {
		int intarray[];
		intarray = new int[10];
		Random rad = new Random();
		for (int i = 0; i<intarray.length; i++) {
			intarray[i] = rad.nextInt(10)+1;
		}	
		printthearray(intarray);
		printbackwards(intarray);
		secondlargest(intarray);
		average(intarray);
		histogram(intarray);
		frequency(intarray);

	}

	private static void printthearray(int[] numbers) {
		for(int x = 0; x < numbers.length; x++) {
			System.out.print(numbers[x]);
		}
	}
	private static void printbackwards(int[] numbers) {
		System.out.println(" ");
		for(int x = numbers.length - 1; x >= 0; x-- ) {
			System.out.print(numbers[x]);
		}
	}
	private static void secondlargest(int[] numbers) {
		System.out.println("");
		int min = numbers[0];
		int min2 = numbers[1];
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] < min) {
				min2 = min;
				min = numbers[i];
			}
			else if (numbers[i] < min2 && numbers[i] > min) {
				min2 = numbers[i];
			}
		}
		System.out.println(min2);	
	}
	private static void average(int[] numbers) {
		double sum = 0;
		for(int x = 0; x <numbers.length;x++) {
			sum = sum + numbers[x];
		}
		System.out.println(sum/numbers.length);
		
	}
	
	private static void histogram(int[] numbers) {
		String asterik = "*";
		for(int x = 0; x < numbers.length;x++) {
			System.out.println("");
			for(int i = 0; i <= numbers[x];i++) {
				System.out.print(asterik);
			}
		}
	}

	private static void frequency(int[] numbers) {
		int count[];
		System.out.println("");
		count = new int[] {0,0,0,0,0,0,0,0,0,0};
		for (int i = 0; i < numbers.length; i++) {
			count[numbers[i]-1] ++;
		}
		for (int x = 0; x < count.length;x++) {
			if (count[x] > 0) System.out.println(count[x] + " " + (x+1) + "'s");
			
		}
	}

}
