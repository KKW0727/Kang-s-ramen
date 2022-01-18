package com.spring.kangsRamen.model.dao;

import com.spring.kangsRamen.model.json.ReservationVo;

public interface ReservationDao {

	public int InsertReservationMst(ReservationVo reservationVo);
	public int InsertReservationDtl(ReservationVo reservationVo);
	public String getMaxReservationCode();
}
