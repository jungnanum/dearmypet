package net.dearmypet.webapp.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.dearmypet.webapp.vo.LoginVO;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SqlSessionTemplate session;
	
	public LoginDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	public LoginDaoImpl(SqlSessionTemplate session) {
		this.session = session;
	}

	@Override
	public List<LoginVO> selectAllLogin() {
		return session.selectList("loginMapper.selectAllLogin");
	}
	
	@Override
	public int insertLoginVO(LoginVO loginVO) {
		int nRet = session.insert("loginMapper.insertLoginVO", loginVO);
		return nRet;
	}

	
}
