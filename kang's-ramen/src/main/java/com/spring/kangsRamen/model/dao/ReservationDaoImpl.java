package com.spring.kangsRamen.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.kangsRamen.model.json.ReservationVo;

@Repository
public class ReservationDaoImpl implements ReservationDao {

	private static final String NAME_SPACE = "com.spring.kangsRamen.model.dao.ReservationDao.";

	@Autowired
	private SqlSession session;

	@Override
	public int InsertReservationMst(ReservationVo reservationVo) {
		return session.insert(NAME_SPACE + "InsertReservationMst", reservationVo);
	}

	@Override
	public int InsertReservationDtl(ReservationVo reservationVo) {
		return session.insert(NAME_SPACE + "InsertReservationDtl", reservationVo);
	}

	@Override
	public String getMaxReservationCode() {
		return session.selectOne(NAME_SPACE + "getMaxReservationCode");
	}

	@Override
	public List<ReservationVo> getAllReservation(int id) {
		return session.selectList(NAME_SPACE + "getAllReservation", id);
	}

	@Override
	public int updatePayment(int id) {
		return session.update(NAME_SPACE + "updatePayment", id);
	}
}
