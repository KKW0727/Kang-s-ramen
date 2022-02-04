package com.spring.kangsRamen.admin.service;

import com.spring.kangsRamen.admin.model.dto.GameInfoDto;

public interface GameInfoService {

	public GameInfoDto getGameInfo();
	public int updateGameInfo(GameInfoDto gameInfoDto);
}
