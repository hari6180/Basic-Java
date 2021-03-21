import org.apache.ibatis.session.SqlSession;

import study.java.helloWorld.MyBatisConnectionFactory;
import study.java.helloWorld.model.Users;

// 회원가입
public class Main01 {

	public static void main(String[] args) {
		
		// 1) 데이터베이스 접속
		// --> import study.java.myschool.MyBatisConnectionFactory;
		// --> import org.apache.ibatis.session.SqlSession;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

		// 2) INSERT를 수행할 데이터 생성
		// --> Beans에 생성자를 정의하지 않으면 필요한 
		//     데이터만 setter로 추가할 수 있다.
		// --> import study.java.myschool.model.Department;
		Users model = new Users();
		model.setRealname("김철수");
		model.setUsername("찰스찰스");
		model.setPassword("ddd123");
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
		

		// 3) 데이터 저장
		// DepartmentMapper라는 namespace를 갖는 XML에서
		// id값이 add_department인 <insert> 태그를 호출한다.
		sqlSession.insert("UsersMapper.join", model);
		// 이 때, 저장할 데이터를 담고 있는 Beans를 파라미터로 전달하고,
		// 자동으로 생성된 PK는 Beans에 저장된다.
		int result = model.getId();

		// 4) 결과 판별
		// --> 리턴값이 0이라면 내부적으로 예외가 발생된 상황으로 
		//     간주해야 한다.
		System.out.println(result + "번째 고객님, 회원가입이 완료되었습니다.");

		// 5) DB 접속 해제
		// 페이지 종료 전에 데이터의 변경사항을 저장(commit)하고
		// 데이터베이스 접속 해제하기
		sqlSession.commit();
		sqlSession.close();
	}
}
