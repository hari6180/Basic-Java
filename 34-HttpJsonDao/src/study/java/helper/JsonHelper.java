package study.java.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonHelper {
	// ------ 싱글톤 객체 생성 시작 ------
	private static JsonHelper current;

	public static JsonHelper getInstance() {
		if (current == null) {
			current = new JsonHelper();
		}
		return current;
	}

	public static void freeInstance() {
		// 객체에 null을 대입하면 메모리에서 삭제된다.
		current = null;
	}

	// 기본 생성자를 private으로 은닉하게 되면 new를 통한 객체 생성이 금지된다.
	private JsonHelper() {
		super();
	}
	// ------ 싱글톤 객체 생성 끝 ------
	
	/**
	 * InputStream객체를 JSONObject객체로 변환하여 리턴한다.
	 * @param is - InputStream 객체
	 * @param encType - InputStream이 읽어들인 Xml의 인코딩 형식
	 * @return JSONObject
	 */
	public JSONObject getJSONObject(InputStream is, String encType) {
		JSONObject json = null;
		
		// InputStream의 내용을 저장할 문자열
		String source = null;
		
		BufferedReader reader = null;
		try {
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			reader = new BufferedReader(new InputStreamReader(is, encType));
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n"); // 임시로 붙여주는 값
			}
			source = sb.toString(); // 단단히 문자열로 고정해서 똰
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 닫아줄 땐 나중에 쓴 것부터 닫아준다.
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} // end try ~ catch ~ finally
		
		try {
			json = new JSONObject(source);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}

}
