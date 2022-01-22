package com.spring.kangsRamen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kangsRamen.model.dao.ReservationDao;
import com.spring.kangsRamen.model.json.ReservationVo;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDao reservationDao;

	@Override
	public int InsertReservation(ReservationVo reservationVo) {

		String MaxReservationCode = reservationDao.getMaxReservationCode();
		if (MaxReservationCode == null) {
			reservationVo.setReservation_code(1);
		} else {
			reservationVo.setReservation_code(Integer.parseInt(MaxReservationCode) + 1);
		}

		int InsertDtlResult = 0;

		int InsertMstResult = reservationDao.InsertReservationMst(reservationVo);
		if (InsertMstResult == 1) {
			InsertDtlResult = reservationDao.InsertReservationDtl(reservationVo);
			if (InsertDtlResult == 1) {
				return InsertDtlResult;
			}
		}
		return InsertDtlResult;
	}

	@Override
	public List<ReservationVo> getAllReservation(int id) {
		return reservationDao.getAllReservation(id);
	}

	@Override
	public int updatePayment(int id) {
		return reservationDao.updatePayment(id);
	}

	@Override
	public ReservationVo getOneReservation(int reservation_code) {
		return reservationDao.getOneReservation(reservation_code);
	}

	@Override
	public int updateReservation(ReservationVo reservationVo) {
		int updateDtlResult = 0;
		int updateMstResult = reservationDao.updateReservationMst(reservationVo);
		if (updateMstResult == 1) {
			updateDtlResult = reservationDao.updateReservationDtl(reservationVo);
			if (updateDtlResult == 1) {
				return updateDtlResult;
			}
		}
		return updateDtlResult;
	}

	@Override
	public int deleteReservation(int reservation_code) {

		int deleteMstResult = 0;
		int deleteDtlResult = reservationDao.deleteReservationDtl(reservation_code);
		if (deleteDtlResult == 1) {
			deleteMstResult = reservationDao.deleteReservationMst(reservation_code);
			if (deleteMstResult == 1) {
				return deleteMstResult;
			}
		}
		return deleteMstResult;
	}

}
