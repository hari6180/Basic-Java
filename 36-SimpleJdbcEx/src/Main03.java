import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import study.java.helper.DBHelper;

public class Main03 {
	public static void main(String[] args) {
		// 'department' 테이블에 `컴퓨터정보과`의 위치를 6호관으로 수정하기
		String sql = "UPDATE department SET loc='6호관' WHERE deptno=300";

		/** DBHelper를 통한 DB 접속 처리 */
		DBHelper db = DBHelper.getInstance();
		// 나중에 close 해줘야 해서 메서드 체인을 안쓰고 나눠서 쓴다.
		Connection conn = db.open();

		/** SQL 구문 실행하기 */
		// SQL문을 실행할 수 있는 객체
		Statement stmt = null;
		// 결과값 (저장된 데이터의 수)
		int result = 0;

		try {

			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("MySQL SQL Fail : " + e.getMessage());
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
		}

		System.out.println(result + " Record Update");

		/** DB 접속 해제 */
		db.close();

	}

}
