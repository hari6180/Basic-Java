


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import study.java.helper.DBHelper;

public class Main07 {

	public static void main(String[] args) {
		// 학과목록 조회하기
		String sql = "SELECT deptno, dname, loc FROM department ORDER BY deptno ASC";

		/** DBHelper를 통한 DB 접속 처리 */
		DBHelper db = DBHelper.getInstance();
		// 나중에 close 해줘야 해서 메서드 체인을 안쓰고 나눠서 쓴다.
		Connection conn = db.open();

		/** SQL 구문 실행하기 */
		// SELECT 결과를 저장할 객체
		// --> import java.sql.ResultSet; (커서를 이동해주는 클래스)
		ResultSet rs = null;
		Statement stmt = null;
		// 결과값 (저장된 데이터의 수)

		try {
			stmt = conn.createStatement();

			// SELECT 구문을 실행한 후, 결과셋을 리턴받는다.
			rs = stmt.executeQuery(sql);
			
			// 한 줄씩 스캔하는 반복문 구성
			while (rs.next()) {
				int deptNo = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				
				System.out.printf("학과번호: %d\n", deptNo);
				System.out.printf("학과이름: %s\n", dname);
				System.out.printf("위치: %s\n", loc);
				System.out.println();
			}



		} catch (SQLException e) {
			System.out.println("MySQL SQL Fail : " + e.getMessage());
		} finally {

			// resultset 닫기 --> 생성된 순서의 역순으로 객체를 닫는다.
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
		}

		/** DB 접속 해제 */
		db.close();

	}

}
