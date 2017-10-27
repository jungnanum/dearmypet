package net.dearmypet.webapp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@Override
	public LoginVO selectLoginByEmailAndPassword(String strEmail, String strPassword) {
		Map<String, Object> mapParam = new HashMap<String, Object>();
		mapParam.put("lg_email", strEmail);
		mapParam.put("lg_password", strPassword);
		LoginVO loginVO = session.selectOne("loginMapper.selectLoginByEmailAndPassword", mapParam);
		return loginVO;
	}

	
}
