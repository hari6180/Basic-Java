
public class Exam0309 {
	public static void main(String[] args) {
		int[] price = { 38000, 20000, 17900, 17900 };
		int[] qty = { 6, 4, 3, 5 };
		int[] a = new int[4];
		int max = 0;
		
		for (int i = 0; i<price.length; i++) {
			a[i] = price[i] * qty[i];
			}
		
		for (int j = 0; j<a.length; j++) {
			if(max <= a[j] ) {
				max = a[j];
			}
		} System.out.println("가장 높은 상품 금액: " + max + "원");

	}
}
