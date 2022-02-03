package com.spring.kangsRamen.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.kangsRamen.model.dto.GameInfoDto;

@Repository
public class GameInfoDaoImpl implements GameInfoDao {

	private static final String NAME_SPACE = "com.spring.kangsRamen.model.dao.GameInfoDao.";

	@Autowired
	private SqlSession session;

	public GameInfoDto getGameInfo() {
		return session.selectOne(NAME_SPACE + "getGameInfo");
	}
}
