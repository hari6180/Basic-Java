import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import study.java.helloWorld.MyBatisConnectionFactory;
import study.java.helloWorld.model.Users;
import study.java.helloWorld.service.UsersService;
import study.java.helloWorld.service.impl.UsersServiceImpl;

// 회원가입
public class Main01 {

	public static void main(String[] args) {
		
		Logger logger = LogManager.getFormatterLogger(Main01.class.getName());

		

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
		

		SqlSession session = MyBatisConnectionFactory.getSqlSession();


		UsersService usersService = new UsersServiceImpl(session);
		Users result = null;
		
		
		try {

			result = usersService.join(model);

			session.commit();

			logger.debug("로그인 완료 >> " + result.toString());
		} catch (NullPointerException e) {
			logger.error("가입된 정보가 없습니다.");
		} catch (Exception e) {

			logger.error("로그인에 실패했습니다." + e.getMessage());
		}
		

		session.commit();
		session.close();
		

	}
}
