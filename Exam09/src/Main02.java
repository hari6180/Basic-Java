import org.apache.ibatis.session.SqlSession;

import study.java.helloWorld.MyBatisConnectionFactory;
import study.java.helloWorld.model.Users;

public class Main02 {
	public static void main(String[] args) {
		// 1) 데이터베이스 접속
		// --> import org.apache.ibatis.session.SqlSession;
		// --> import study.java.myschool.MyBatisConnectionFactory;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		
		// 2) 조회할 데이터
		// 생성자를 정의할 경우는 사용하지 않는 값들을 null이나 0으로 
		// 설정해야 하지만, 기본생성자만 사용하는 경우는 필요한 값만
		// 정의할 수 있다.
		Users model = new Users();
		model.setId(4);
		model.setPassword("ddd123");
		
		// 3) 데이터 조회
		Users result = sqlSession.selectOne(
				"UsersMapper.login", model);
		
		// 4) 결과 판별
		if (result == null) {
			System.out.println("로그인에 실패했습니다.");
		} else {
			System.out.println(result.toString());
		}
		
		// 5) DB 접속 해제
		sqlSession.close();
	}
}
