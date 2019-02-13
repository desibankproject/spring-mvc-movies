package com.movie.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.movie.dao.ILoginDao;
import com.movie.dao.entity.LoginEntity;
import com.movie.model.Login;

@Service("LoginService")
public class LoginService implements ILoginService {

	@Autowired
	@Qualifier("LoginDao")
	private ILoginDao loginDao;
	
	@Override
	public Login authUser(Login login){
		LoginEntity pentity=new LoginEntity();
		BeanUtils.copyProperties( login, pentity);
		LoginEntity dloginEntity  =loginDao.authUser(pentity);
		Login dlogin=new Login();
		BeanUtils.copyProperties( dloginEntity, dlogin);
		return dlogin;
	}

}
