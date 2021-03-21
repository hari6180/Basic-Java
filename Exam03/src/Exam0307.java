
public class Exam0307 {
	public static void main(String[] args) {
		int[][] inven = {
				{500, 291}, {320,586}, {100, 460}, {120, 558}, {92, 18}, {30,72}
		};
	
		int total = 0; // 아이템 판매 금액의 총 합
		
		for (int i=0; i<inven.length; i++) {
			for (int j=1; j<inven[i].length; j++) {
				double money = inven[i][0];
				double earn = money * 0.9;
				double b = inven[i][j];
				total += earn*b;		
			}
		}
		System.out.println("총 골드의 합: " + total + "G");
	}
}
