public class Engineering {
	private int length;
	private int width;
	
	Engineering(int x, int y){
		length = x;
		width = y;
	}
	Engineering(int x){
		length = x;
		width = 0;
	}
	public int circle() {
		if(length > 0) {
			
		int ans = (int)(3.14 * (length*length));
		return ans;
		}
		else {
			System.out.println("Error");
			return -1;
		}
		
	}
	
	public double rectangle() {
		if(length > 0 && width > 0)
		return(length * width);
		
		else {
			System.out.println("Error");
			return -1.0;
			}
	}
	
	public void changeLength(int x) {length += x;}
}
