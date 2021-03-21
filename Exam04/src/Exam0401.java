
public class Exam0401 {
	public static void main(String[] args) {
		// 사각형의 가로, 세로 길이를 생성자에 전달한다.
		Square s = new Square(3, 2);
		
		// 넓이를 구해서 리턴하는 메서드 호출
		System.out.println("사각형의 넓이 -> " + s.getArea() + "제곱cm");
		// 둘레의 길이를 구해서 리턴하는 메서드 호출
		System.out.println("사각형의 둘레 -> " + s.getRound() + "cm");

	}
}
