import org.apache.ibatis.session.SqlSession;

import study.java.myschool.MyBatisConnectionFactory;
import study.java.myschool.model.Student;

public class Main13 {

	public static void main(String[] args) {
		// 1) 데이터베이스 접속
		// --> import org.apache.ibatis.session.SqlSession;
		// --> import study.java.myschool.MyBatisConnectionFactory;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		
		// 2) UPDATE를 수행할 데이터 생성
		Student model = new Student();
		model.setStudno(20107);
		model.setName("전하리1");
		model.setUserid("hari123");
		model.setGrade(2);
		model.setIdnum("33345883");
		model.setBirthdate("1997-06-18");
		model.setTel("010-8888-0000");
		model.setHeight(190);
		model.setWeight(100);
		model.setDeptno(101);
		model.setProfno(9908);
		
		// 3) 데이터 수정
		// --> DepartmentMapper라는 namespace를 갖는 XML에서
		//	   edit_department라는 id값을 갖는 <update> 태그를 호출.
		int result = sqlSession.update(
				"StudentMapper.edit_student", model);
		
		// 4) 결과 판별
		System.out.println(result + "개의 데이터 수정됨");
		
		// 5) DB 접속 해제
		// 페이지 종료 전에 데이터의 변경사항을 저장(commit)하고
		// 데이터베이스 접속 해제하기
		sqlSession.commit();
		sqlSession.close();

	}

}
