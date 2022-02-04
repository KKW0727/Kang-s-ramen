package com.spring.kangsRamen.admin.model.dao;

import com.spring.kangsRamen.admin.model.dto.GameInfoDto;

public interface GameInfoDao {
	
	public GameInfoDto getGameInfo();
	public int updateGameInfo(GameInfoDto gameInfoDto);

}
