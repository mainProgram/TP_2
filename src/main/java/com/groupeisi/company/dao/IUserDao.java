package com.groupeisi.company.dao;

import java.util.Optional;

import com.groupeisi.company.entities.UserEntity;

public interface IUserDao extends IRepository<UserEntity>{

	public Optional<UserEntity> login (String email, String password);

}
