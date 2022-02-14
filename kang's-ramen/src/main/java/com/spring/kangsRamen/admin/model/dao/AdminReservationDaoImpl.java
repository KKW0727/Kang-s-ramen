package com.spring.kangsRamen.admin.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.kangsRamen.admin.model.dto.ReservationDto;
import com.spring.kangsRamen.admin.model.dto.SearchDto;

@Repository
public class AdminReservationDaoImpl implements AdminReservationDao {

	private static final String NAME_SPACE = "com.spring.kangsRamen.admin.model.dao.AdminReservationDao.";

	@Autowired
	private SqlSession session;

	@Override
	public List<ReservationDto> getReservation(SearchDto searchDto) {
		return session.selectList(NAME_SPACE + "getReservation", searchDto);
	}

	@Override
	public List<ReservationDto> getCanceledReservation(SearchDto searchDto) {
		return session.selectList(NAME_SPACE + "getCanceledReservation", searchDto);
	}

}
