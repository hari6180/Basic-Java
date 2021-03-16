import java.sql.Connection;

import study.java.daoex.dao.StudentDao;
import study.java.daoex.dao.impl.StudentDaoImpl;
import study.java.daoex.model.Student;
import study.java.helper.DBHelper;

public class Main13 {
	public static void main(String[] args) {
		// 1) 데이터베이스 접속
		Connection conn = DBHelper.getInstance().open();

		if (conn == null) {
			System.out.println("데이터베이스 접속 실패");
			return;
		}

		// 2) UPDATE를 수행할 데이터 생성
		Student model = new Student(20106,"김영희","cheol123",4,"4444888","2020-10-29",
				"99933",180,11,101,9908);
		
		// 3) 데이터 수정
		StudentDao dao = new StudentDaoImpl(conn);
		int result = dao.update(model);

		// 4) 결과 판별
		System.out.println(result + "개의 데이터 수정됨");

		// 5) DB 접속 해제
		DBHelper.getInstance().close();


	}

}
