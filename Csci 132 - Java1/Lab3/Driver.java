
public class Driver {

	public static void main(String[] args) {
		Engineering r = new Engineering(6,7);
		Engineering c = new Engineering(6);
		//Test error message
		c.changeLength(4);
		int ans = c.circle();
		System.out.println(ans);
		c.changeLength(-11);
		ans = c.circle();
		System.out.println(ans);
		r.changeLength(-5);
		double ans2 = r.rectangle();
		System.out.println(ans2);
	
		
	}

}
