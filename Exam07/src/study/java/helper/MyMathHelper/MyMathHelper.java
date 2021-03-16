package study.java.helper.MyMathHelper;

public class MyMathHelper {
	// ------ 싱글톤 객체 생성 시작 ------
	private static MyMathHelper current;

	public static MyMathHelper getInstance() {
		if (current == null) {
			current = new MyMathHelper();
		}
		return current;
	}

	public static void freeInstance() {
		// 객체에 null을 대입하면 메모리에서 삭제된다.
		current = null;
	}

	// 기본 생성자를 private으로 은닉하게 되면 new를 통한 객체 생성이 금지된다.
	private MyMathHelper() {
		super();
	}
	// ------ 싱글톤 객체 생성 끝 ------
	
	public void gugu(int i) {
		for (int j = 1; j<10; j++) {
		System.out.println(i + " x " + j + " = " + i*j);
		}
		
	}

}
