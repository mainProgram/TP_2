package com.groupeisi.company.service;

import java.util.List;
import java.util.Optional;

import com.groupeisi.company.dao.IUserDao;
import com.groupeisi.company.dao.UserDao;
import com.groupeisi.company.dto.UserDto;
import com.groupeisi.company.entities.UserEntity;
import com.groupeisi.company.mapper.UserMapper;

public class UserService implements IUserService{

private IUserDao userDao = new UserDao();
	
	@Override
	public List<UserDto> getAll() {
	
		return UserMapper.listUserEntityToListUserDto(userDao.list(new UserEntity()));
	}

	@Override
	public boolean save(UserDto userDto) {
		
		return userDao.save(UserMapper.toUserEntity(userDto));
	}

	@Override
	public Optional<UserDto> login(String email, String password) {
		Optional<UserEntity> userEntity = userDao.login(email, password);
		
		if (userEntity.isPresent()) {
			UserEntity user = userEntity.get();
			return Optional.of(UserMapper.toUserDto(user));
		} else {
			return Optional.empty();
		}
	}
}
