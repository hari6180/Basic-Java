
public class Exam0305 {
	public static void main(String[] args) {
		boolean[] checkList = { true, false, false, true, false };
		
		System.out.println("----- before -----");
		printArray(checkList);
		
		for (int j=0; j < checkList.length; j++ ) {
			if (checkList[j] == true) {
				checkList[j] = false;
			} else {
				checkList[j] = true;
			}
		}
		
		System.out.println("----- after ------");
		printArray(checkList);
	}
	
	public static void printArray(boolean[] data) { // 여기서의 data 값은 대체 무엇인가..
		for (int i=0; i < data.length; i++) {
			System.out.print(data[i]);
			
			if (i+ 1 < data.length) {
				System.out.print(", ");
			}
		}
		
		System.out.println();
	}
}
