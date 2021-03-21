package study.java.helloWorld.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import study.java.helloWorld.model.Users;
import study.java.helloWorld.service.UsersService;

public class UsersServiceImpl implements UsersService {
	
	private SqlSession session;
	
	public UsersServiceImpl(SqlSession session) {
		this.session = session;
	}

	@Override
	// 회원가입 
	public Users join(Users params) throws NullPointerException, Exception {
		int row_count = session.insert("UsersMapper.join", params);

		if (row_count == 0) {
			throw new NullPointerException();
		}

		return session.selectOne("UsersMapper.getUserInfo", params);
	}
		


	@Override
	// 로그인 기능 
	public Users login(Users params) throws NullPointerException, Exception {
		Users item = session.selectOne(
				"UsersMapper.login", params);
		
		if (item == null) {
			throw new NullPointerException();
		}
		
		return item;
	}

	@Override
	// 회원정보 조회
	public Users getUserInfo(Users params) throws NullPointerException, Exception {
		Users item = session.selectOne(
				"UsersMapper.getUserInfo", params);
		
		if (item == null) {
			throw new NullPointerException();
		}
		
		return item;
	}

	@Override
	// 회원정보 수정
	public Users editUserInfo(Users params) throws NullPointerException, Exception {
	int row_count = session.update("UsersMapper.editUserInfo", params);
		
		if (row_count == 0) {
			throw new NullPointerException();
		}

		return session.selectOne("UsersMapper.getUserInfo", params);
	}


	@Override
	public List<Users> getUserList() throws NullPointerException, Exception {
		List<Users> list = session.selectList(
				"UsersMapper.getUserList", null);
		
		if (list == null) {
			throw new NullPointerException();
		}
		
		return list;
	}

	@Override
	public void out(Users params) throws NullPointerException, Exception {
		int row_count = session.delete(
				"UsersMapper.out", params);
		
		// ���������� ������ ���� ���� ��� ������ ���ܸ� �߻���Ų��.
		if (row_count == 0) {
			throw new NullPointerException();
		}
		
	}

}
