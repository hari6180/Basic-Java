import java.util.List;

import org.apache.ibatis.session.SqlSession;

import study.java.helloWorld.MyBatisConnectionFactory;
import study.java.helloWorld.model.Users;

public class Main05 {
	public static void main(String[] args) {
		// 1) 데이터베이스 접속
		// --> import org.apache.ibatis.session.SqlSession;
		// --> import study.java.myschool.MyBatisConnectionFactory;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

		// 2) 데이터 목록 조회 : 파라미터가 필요 없다면 생략 가능.
		// --> import java.util.List;
		// --> import study.java.myschool.model.Department;
		List<Users> result = sqlSession.selectList(
							"UsersMapper.getUserList");

		// 3) 결과 판별
		if (result == null) {
			System.out.println("조회결과 없음");
		} else {
			for (int i = 0; i < result.size(); i++) {
				Users item = result.get(i);
				System.out.println(item.toString());
			}
		}

		// 4) DB 접속 해제
		sqlSession.close();
	}
}
