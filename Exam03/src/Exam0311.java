
public class Exam0311 {
	public static void main(String[] args) {
		int[] money = { 209000, 109000, 119000, 109000, 94000 };
		System.out.print("상품가격 --> ");
		for (int i = 0; i < money.length; i++) {
			if (i == money.length - 1) {
				System.out.print(money[i]);
			} else {
				System.out.print(money[i] + ",");
			}
		}
		System.out.println();
		System.out.print("낮은가격순 --> ");


		for (int i = 0; i < money.length; i++) {
			for (int j = i+1; j < money.length; j++) {
				if (money[i] > money[j]) {
					int temp = money[i];
					money[i] = money[j];
					money[j] = temp;
					
				}
			}
		}

		for (int i = 0; i < money.length; i++) {
			if (i == money.length - 1) {
				System.out.print(money[i]);
			} else {
				System.out.print(money[i] + ",");
			}
		}

	}
}
