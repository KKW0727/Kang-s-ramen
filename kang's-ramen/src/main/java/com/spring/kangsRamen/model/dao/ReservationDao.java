package com.spring.kangsRamen.model.dao;

import java.util.List;

import com.spring.kangsRamen.model.json.PaymentVo;
import com.spring.kangsRamen.model.json.ReservationVo;

public interface ReservationDao {

	public int InsertReservationMst(ReservationVo reservationVo);
	public int InsertReservationDtl(ReservationVo reservationVo);
	public String getMaxReservationCode();
	public List<Integer> getCanceledAllReservationCode();
	public List<ReservationVo> getAllReservation(int id);
	public ReservationVo getOneReservation(int reservation_code);
	public int updateReservationMst(ReservationVo reservationVo);
	public int updateReservationDtl(ReservationVo reservationVo);
	public int deleteReservationDtl(int reservation_code);
	public int deleteReservationMst(int reservation_code);
	public int insertPayment(PaymentVo paymentVo);
	public int deletePayment(int reservation_code);
	public List<ReservationVo> getAllCanceledReservation(int id);
}
