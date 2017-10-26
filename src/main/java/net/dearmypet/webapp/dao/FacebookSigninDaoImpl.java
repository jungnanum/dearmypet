package net.dearmypet.webapp.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import net.dearmypet.webapp.vo.FacebookSigninVO;

@Repository("facebookSigninDao")
public class FacebookSigninDaoImpl implements FacebookSigninDao {

	@Autowired
	private SqlSessionTemplate session;

	public FacebookSigninDaoImpl() {}

	public FacebookSigninDaoImpl(SqlSessionTemplate session) {
		this.session = session;
	}

	@Override
	public FacebookSigninVO selectFBId(String facebookUserId) {
		FacebookSigninVO facebookSigninVO = session.selectOne("facebookSigninMapper.selectLoginFBById", facebookUserId);
		return facebookSigninVO;
	}

	@Override
	public int insertNewFacebookUser(FacebookSigninVO facebookSigninVO) {
		int nRet = session.insert("facebookSigninMapper.insertFacebookVO", facebookSigninVO);
		return nRet;
	}

}
