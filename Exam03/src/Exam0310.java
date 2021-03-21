
public class Exam0310 {
	public static void main(String[] args) {
		int[] price = { 38000, 20000, 17900, 17900 };
		int[] qty = { 6, 4, 3, 5 };
		int free = 0;
		
		for (int i = 0; i<price.length; i++) {
			int tp = price[i] * qty[i];
			if (tp >= 80000) {
				free += 1;
			}		
		} 
		System.out.println("무료배송 항목: " + free + "건");
	} 
}
