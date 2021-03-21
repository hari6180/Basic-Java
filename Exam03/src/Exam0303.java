
public class Exam0303 {
	public static void printArray(int[] arr) { 
		for (int j=0; j<arr.length; j++) { 
			System.out.println("arr[" + j + "]=" + arr[j]);
		} 
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 9, 4, 2, 5}; 
		
		for (int i=0; i<(arr.length)/2; i++) { 
			int a = 0; 
			a = arr[i]; 
			arr[i] = arr[arr.length-i-1];  
			arr[arr.length-i-1] = a; 
		} printArray(arr); 
	}
}
