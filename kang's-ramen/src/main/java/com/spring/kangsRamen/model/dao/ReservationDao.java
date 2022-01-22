package com.spring.kangsRamen.model.dao;

import java.util.List;

import com.spring.kangsRamen.model.json.ReservationVo;

public interface ReservationDao {

	public int InsertReservationMst(ReservationVo reservationVo);
	public int InsertReservationDtl(ReservationVo reservationVo);
	public String getMaxReservationCode();
	public List<ReservationVo> getAllReservation(int id);
	public ReservationVo getOneReservation(int reservation_code);
	public int updatePayment(int id);
	public int updateReservationMst(ReservationVo reservationVo);
	public int updateReservationDtl(ReservationVo reservationVo);
	public int deleteReservationDtl(int reservation_code);
	public int deleteReservationMst(int reservation_code);
}
