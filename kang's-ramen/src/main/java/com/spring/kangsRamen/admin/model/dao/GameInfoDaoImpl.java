package com.spring.kangsRamen.admin.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.kangsRamen.admin.model.dto.GameInfoDto;

@Repository
public class GameInfoDaoImpl implements GameInfoDao {

	private static final String NAME_SPACE = "com.spring.kangsRamen.admin.model.dao.GameInfoDao.";

	@Autowired
	private SqlSession session;

	public GameInfoDto getGameInfo() {
		return session.selectOne(NAME_SPACE + "getGameInfo");
	}

	@Override
	public int updateGameInfo(GameInfoDto gameInfoDto) {
		return session.update(NAME_SPACE + "updateGameInfo", gameInfoDto);
	}
}
