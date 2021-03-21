import java.util.Calendar;

import javax.swing.JOptionPane;

import study.java.Helper.RegexHelper;

public class Exam0801 {
	public static void main(String[] args) {
		// 현재 년도
		int now_year = Calendar.getInstance().get(Calendar.YEAR);
		
		// 다이얼로그에서 입력값 받기
		String jumin = JOptionPane.showInputDialog(
				"당신의 주민번호를 '-' 없이 입력해 주세요.");
		
		// 값 출력하기
		System.out.println("년도: " + now_year + " / 입력값: " + jumin);
		
		/** 1) 주민번호 형식 검사.
		 * 형식에 맞지 않을 경우 return 처리
		 * --> main 메서드 종료
		 * --> 프로그램 종료 */
		
		if (!RegexHelper.getInstance().isJumin(jumin)) {
			System.out.println ("주민번호가 형식에 맞지 않습니다.");
			return;
		}
		
		
		/** 2) 주민번호를 사용하여 나이 계산하기 */
		String yy = jumin.substring(0,2);
		String gender_code = jumin.substring(6,7);
		
		if (gender_code.equals("1") || gender_code.equals("2")) {
			yy = "19" + yy;
		}	else {
			yy = "20" + yy;
		}
		
		int age = now_year - Integer.parseInt(yy) + 1;
		System.out.println("당신은 " + age + "살 입니다.");	
	}
}