package com.spring.kangsRamen.admin.service;

import java.util.List;

import com.spring.kangsRamen.admin.model.dto.SearchDto;
import com.spring.kangsRamen.admin.model.dto.UserDto;

public interface AdminUserService {

	public List<UserDto> getUser(SearchDto searchDto);
	public List<UserDto> getWithdrawalUser(SearchDto searchDto);
}
