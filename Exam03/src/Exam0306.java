
public class Exam0306 {
	public static void main(String[] args) {
		// 일한 시간
		int[] workTime = { 7, 5, 5, 5, 5, 10, 7 };
		// 총 급여
		int pay = 0;
		for (int i=0; i<workTime.length; i++) {
			if (i>3) {
				int money = workTime[i] * 4500;
				pay += money;
			} else {
				int moneyup = workTime[i] * 5200;
				pay += moneyup;
			}
		}
		System.out.println("일주일 간의 총 급여: " + pay + "원");

	}
}
