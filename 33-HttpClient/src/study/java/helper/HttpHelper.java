package study.java.helper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class HttpHelper {
	// ------ 싱글톤 객체 생성 시작 ------
	private static HttpHelper current;

	public static HttpHelper getInstance() {
		if (current == null) {
			current = new HttpHelper();
		}
		return current;
	}

	public static void freeInstance() {
		// 객체에 null을 대입하면 메모리에서 삭제된다.
		current = null;
	}

	// 기본 생성자를 private으로 은닉하게 되면 new를 통한 객체 생성이 금지된다.
	private HttpHelper() {
		super();
	}
	// ------ 싱글톤 객체 생성 끝 ------

	public InputStream getWebData(String url, String encType) {
		// 접속 대기에 대한 제한시간 --> 밀리세컨드 단위
		int timeout = 30000;

		// 통신객체
		HttpClient client = null;
		// 접속을 하기 위한 기본 환경설정 객체
		HttpParams params = new BasicHttpParams();
		// 프로토콜 버전 설정
		params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		// 요청 제한 시간
		HttpConnectionParams.setConnectionTimeout(params, timeout);
		// 응답 제한 시간
		HttpConnectionParams.setSoTimeout(params, timeout);
		// 통신에 사용할 인코딩 값 설정
		HttpProtocolParams.setContentCharset(params, encType);
		// 접속 기능을 하는 객체 생성
		client = new DefaultHttpClient(params);

		/********** (3) 접속하기 **********/
		// 응답 결과가 저장될 객체
		InputStream is = null;

		// 통신에 필요한 요청 정보 설정 --> URL을 주소표시줄에 입력하기
		HttpGet httpget = new HttpGet(url);
		try {
			// 요청을 보낸 후, 응답 받기
			HttpResponse response = client.execute(httpget);

			// 웹 서버의 응답결과 코드 받기
			// 404 : Page Not Found (주소 오타, 파일 없음)
			// 500 : Server Error, 200 : OK
			int resultCode = response.getStatusLine().getStatusCode();

			// 서버 응답이 정상일 경우에만 처리
			if (resultCode == HttpURLConnection.HTTP_OK) {
				// 수신된 응답에서 실 데이터 추출
				HttpEntity entity = response.getEntity();
				BufferedHttpEntity buffer = new BufferedHttpEntity(entity);

				// 추출한 데이터를 InputStream으로 변환
				is = buffer.getContent();
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 통신 해제
			client.getConnectionManager().shutdown();
		}
		
		// 통신결과 리턴
		return is;
	}
}