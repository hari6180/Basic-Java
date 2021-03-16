import org.apache.ibatis.session.SqlSession;

import study.java.myschool.MyBatisConnectionFactory;
import study.java.myschool.model.Professor;

public class Main08 {

	public static void main(String[] args) {
		// 1) 데이터베이스 접속
		// --> import org.apache.ibatis.session.SqlSession;
		// --> import study.java.myschool.MyBatisConnectionFactory;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		
		// 2) UPDATE를 수행할 데이터 생성
		Professor model = new Professor();
		model.setProfno(9909);
		model.setName("전하리");
		model.setUserid("hari123");
		model.setPosition("척척박사");
		model.setSal(9999);
		model.setHiredate("2020-01-01");
		model.setComm(777);
		model.setDeptno(101);
		
		// 3) 데이터 수정
		// --> DepartmentMapper라는 namespace를 갖는 XML에서
		//	   edit_department라는 id값을 갖는 <update> 태그를 호출.
		int result = sqlSession.update(
				"ProfessorMapper.edit_professor", model);
		
		// 4) 결과 판별
		System.out.println(result + "개의 데이터 수정됨");
		
		// 5) DB 접속 해제
		// 페이지 종료 전에 데이터의 변경사항을 저장(commit)하고
		// 데이터베이스 접속 해제하기
		sqlSession.commit();
		sqlSession.close();

	}

}
