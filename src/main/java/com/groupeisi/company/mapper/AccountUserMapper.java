package com.groupeisi.company.mapper;

import com.groupeisi.company.dto.AccountUserDto;
import com.groupeisi.company.entities.AccountUserEntity;

public class AccountUserMapper {
	
	public AccountUserEntity toAccountUserEntity (AccountUserDto accountUserDto) {
	
		AccountUserEntity accountUserEntity = new AccountUserEntity();
		
		accountUserEntity.setId(accountUserDto.getId());
		accountUserEntity.setEmail(accountUserDto.getEmail());
		accountUserEntity.setPassword(accountUserDto.getPassword());
		accountUserEntity.setState(accountUserDto.isState());

		return accountUserEntity;
	}

	public AccountUserDto toAccountUserDto (AccountUserEntity accountUserEntity ) {
		
		AccountUserDto accountUserDto = new AccountUserDto();
		
		accountUserEntity.setId(accountUserEntity.getId());
		accountUserEntity.setEmail(accountUserEntity.getEmail());
		accountUserEntity.setPassword(accountUserEntity.getPassword());
		accountUserEntity.setState(accountUserEntity.isState());

		return accountUserDto;
	}
}
