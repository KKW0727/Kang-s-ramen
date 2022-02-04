package com.spring.kangsRamen.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kangsRamen.admin.model.dao.GameInfoDao;
import com.spring.kangsRamen.admin.model.dto.GameInfoDto;

@Service
public class GameInfoServiceImpl implements GameInfoService {

	@Autowired
	private GameInfoDao gameInfoDao;

	@Override
	public GameInfoDto getGameInfo() {
		return gameInfoDao.getGameInfo();
	}

	@Override
	public int updateGameInfo(GameInfoDto gameInfoDto) {
		return gameInfoDao.updateGameInfo(gameInfoDto);
	}

}
