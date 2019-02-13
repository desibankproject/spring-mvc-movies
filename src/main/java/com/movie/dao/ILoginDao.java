package com.movie.dao;

import com.movie.dao.entity.LoginEntity;

public interface ILoginDao {


	public LoginEntity authUser(LoginEntity entity);
}
