public class Exam0701 {
	public static void main(String[] args) {
		for (int i=2; i<10; i++) {
			MyMathHelper.getInstance().gugu(i);
			
			if (i+1<10) {
				System.out.println("--------------");
			}
		}

	}

}