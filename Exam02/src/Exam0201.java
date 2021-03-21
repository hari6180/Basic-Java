
public class Exam0201 {
	public static void main(String[] args) {
		// 자신의 키
		double myHeight = 160;
		// 자신의 몸무게
		double myWeight = 100;
		// 표준체중
		double standardWeight = 0;
		// 비만도
		double obesity = 0;
		
		standardWeight = (myHeight - 110) * 0.9;
		obesity = (myWeight - standardWeight) / standardWeight * 100;
		
		if (obesity <= 20) {
			System.out.println("정상(안심)");
		} else if (obesity <= 30) {
			System.out.println("경도비만(주의)");
		} else if (obesity <= 50) {
			System.out.println("중등도 비만(위험)");
		} else 
			System.out.println("고도비만(매우위험)");
	}
}
