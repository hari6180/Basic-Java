public class MyMathHelper {
	public static MyMathHelper current;
	public static MyMathHelper getInstance() {
		if (current == null) {
			current = new MyMathHelper();
		}
		return current;
	}
	
	public static void freeInstance() {
		current = null;
	}
	
	private MyMathHelper() {
		super();
	}
	
	public void gugu(int i) {
		for (int j=1; j<10; j++) {
			System.out.println(i + " x " + j + " = " + i*j);
		}

	}
	
}