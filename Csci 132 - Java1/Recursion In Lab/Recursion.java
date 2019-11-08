
public class Recursion {

	public static void main(String[] args) {
		System.out.println(testIfPalindrome("radar",0)); // true
		System.out.println(testIfPalindrome("goontnog",0)); // false
		System.out.println(testIfPalindrome("racecar",0)); // true
		System.out.println(testIfPalindrome("miloolim",0)); // true
		System.out.println(testIfPalindrome("moctycom",0)); //false
		
		System.out.println(gcd(14,48)); //2
		System.out.println(gcd(1600,136)); //8
		System.out.println(gcd(1000,75)); //25
		
	}

	public static boolean testIfPalindrome(String word,int position) {
		if(position == (word.length() - position - 1)){
			return true;
		}
		else if(position == (word.length() - position)) {
			return true;
		}
		if(word.charAt(position) != word.charAt(word.length() - position - 1)){
			return false;
		}
		else {
			return testIfPalindrome(word,++position);
		}
	}
	
	public static int gcd(int int1, int int2) {
		if(int1%int2 == 0) {
			return int2;
		}
		else 
			return gcd(int2,int1%int2);
	}
}
