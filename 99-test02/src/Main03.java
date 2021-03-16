import java.sql.Connection;

import study.java.daoex.dao.ProfessorDao;
import study.java.daoex.dao.impl.ProfessorDaoImpl;
import study.java.daoex.model.Professor;
import study.java.helper.DBHelper;

public class Main03 {
	public static void main(String[] args) {
		// 1) 데이터베이스 접속
		Connection conn = DBHelper.getInstance().open();

		if (conn == null) {
			System.out.println("데이터베이스 접속 실패");
			return;
		}

		// 2) UPDATE를 수행할 데이터 생성
		Professor model = new Professor(9909,"김영희","cheol123","교수",600,"2020-10-29",
				533,201);
		
		// 3) 데이터 수정
		ProfessorDao dao = new ProfessorDaoImpl(conn);
		int result = dao.update(model);

		// 4) 결과 판별
		System.out.println(result + "개의 데이터 수정됨");

		// 5) DB 접속 해제
		DBHelper.getInstance().close();

	}

}
