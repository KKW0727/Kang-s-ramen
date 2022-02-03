package com.spring.kangsRamen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kangsRamen.model.dao.GameInfoDao;
import com.spring.kangsRamen.model.dto.GameInfoDto;

@Service
public class GameInfoServiceImpl implements GameInfoService {

	@Autowired
	private GameInfoDao gameInfoDao;

	@Override
	public GameInfoDto getGameInfo() {
		return gameInfoDao.getGameInfo();
	}

}
