package study.java.helper;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main01 {
	public static void main(String[] args) {
		String source = FileHelper.getInstance().readString(
				"res/score.json", "utf-8");
		JSONObject json = new JSONObject(source);
		JSONArray item = json.getJSONArray("score");
		int a = 0;
		int b = 0;
		for (int i = 0; i<item.length(); i++) {
			int sum = 0;
			int avg = 0;
			
			JSONObject temp = item.getJSONObject(i);
			String name = temp.getString("name");
			int kor = temp.getInt("kor");
			int eng = temp.getInt("eng");
			int mat = temp.getInt("mat");
			
			sum += kor + eng + mat;
			avg = sum / (temp.length() - 1);
			a += sum;
			b += (temp.length() - 1);
			System.out.println("학생이름 : " + name + " 평균 : " + avg + "점" );

		}
		int all = a / b ;
		System.out.println("전체 평균 : " +  all  + "점" );
	}
}
