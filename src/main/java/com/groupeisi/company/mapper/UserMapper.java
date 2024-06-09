package com.groupeisi.company.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.groupeisi.company.dto.UserDto;
import com.groupeisi.company.entities.UserEntity;

public class UserMapper {

	public static List<UserDto> listUserEntityToListUserDto(List<UserEntity> users) {
		
		return users.stream()
				.map(user -> toUserDto(user))
				.collect(Collectors.toList());
	}
	
	
	public static UserDto toUserDto(UserEntity user) {
		
		return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
	}
	
	public static UserEntity toUserEntity(UserDto user) {
		
		return new UserEntity(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
	}
}