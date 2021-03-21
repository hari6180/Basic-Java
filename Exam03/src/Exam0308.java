
public class Exam0308 {
	public static void main(String[] args) {
		int[] price = { 38000, 20000, 17900, 17900 };
		int[] qty = { 6, 4, 3, 5};
		int total = 0;
		
		for (int i = 0; i<price.length; i++) {
			total += price[i] * qty[i];
			}
		
		System.out.println("전체 결제 금액: " + total + "원");

	}
}
