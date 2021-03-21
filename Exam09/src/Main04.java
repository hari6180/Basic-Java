import org.apache.ibatis.session.SqlSession;

import study.java.helloWorld.MyBatisConnectionFactory;
import study.java.helloWorld.model.Users;

public class Main04 {
	public static void main(String[] args) {
		// 1) 데이터베이스 접속
		// --> import org.apache.ibatis.session.SqlSession;
		// --> import study.java.myschool.MyBatisConnectionFactory;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

		// 2) UPDATE를 수행할 데이터 생성
		Users model = new Users();
		model.setId(2);
		model.setRealname("전하리");
		model.setUsername("하리짱");
		model.setPassword("fff123");
		model.setEmail("aa@aaa.aa");
		model.setGender("1");
		model.setBirthdate("19991212");
		model.setTel("2222");
		model.setPostcode("234");
		model.setAddr1("서울시 좋은구");
		model.setAddr2("시흥시 산안");
		model.setIs_admin("N");
		model.setReg_date("2010-10-11");
		model.setEdit_date("2019-11-12");
		// 3) 데이터 수정
		// --> DepartmentMapper라는 namespace를 갖는 XML에서 
		//     edit_department라는 id값을 갖는 <update> 태그를 호출.
		int result = sqlSession.update(
				"UsersMapper.editUserInfo", model);

		// 4) 결과 판별
		System.out.println(result + "개의 데이터 수정됨");

		// 5) DB 접속 해제
		// 페이지 종료 전에 데이터의 변경사항을 저장(commit)하고
		// 데이터베이스 접속 해제하기
		sqlSession.commit();
		sqlSession.close();
	}
}
