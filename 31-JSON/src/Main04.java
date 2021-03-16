import org.json.JSONObject;

import study.java.helper.FileHelper;
import study.java.model.News;

public class Main04 {
	public static void main(String[] args) {
		// 파일로부터 JSONObject객체 생성
		String source = FileHelper.getInstance().readString(
				"res/04.json", "utf-8");
		// 데이터에 계층적으로 접근한다.
		JSONObject json = new JSONObject(source);
		JSONObject rss = json.getJSONObject("rss");
		JSONObject item = rss.getJSONObject("item");
		
		// 데이터 추출
		String title = item.getString("title");
		String description = item.getString("description");
		String pubDate = item.getString("pubDate");
		
		// 추출한 데이터를 Beans의 객체로 재구성 
		// -> 외부 데이터를 Java의 데이터 규격으로 변환
		News news = new News(title, description, pubDate);
		System.out.println(news.toString());

	}

}
