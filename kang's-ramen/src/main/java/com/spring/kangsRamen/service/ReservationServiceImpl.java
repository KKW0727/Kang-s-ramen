package com.spring.kangsRamen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kangsRamen.model.dao.ReservationDao;
import com.spring.kangsRamen.model.json.PaymentVo;
import com.spring.kangsRamen.model.json.ReservationVo;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDao reservationDao;

	@Override
	public int InsertReservation(ReservationVo reservationVo) {

		String tempMaxReservationCode = reservationDao.getMaxReservationCode();
		List<Integer> canceledReservationCodeList = reservationDao.getCanceledAllReservationCode();
		int maxReservationCode = 0;
		if (tempMaxReservationCode == null) {
			maxReservationCode = 1;
		} else {
			maxReservationCode = Integer.parseInt(tempMaxReservationCode) + 1;
		}
		for (int canceledReservationCode : canceledReservationCodeList) {
			if (canceledReservationCode == maxReservationCode) {
				maxReservationCode++;
			}
		}
		System.out.println("maxReservationCode:" + maxReservationCode);
		reservationVo.setReservation_code(maxReservationCode);

		int insertDtlResult = 0;

		int insertMstResult = reservationDao.InsertReservationMst(reservationVo);
		if (insertMstResult == 1) {
			insertDtlResult = reservationDao.InsertReservationDtl(reservationVo);
			if (insertDtlResult == 1) {
				return reservationVo.getReservation_code();
			}
		}
		return insertDtlResult;
	}

	@Override
	public List<ReservationVo> getAllReservation(int id) {
		return reservationDao.getAllReservation(id);
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

	@Override
	public int insertPayment(PaymentVo paymentVo) {
		return reservationDao.insertPayment(paymentVo);
	}

	@Override
	public int deletePayment(int reservation_code) {
		return reservationDao.deletePayment(reservation_code);
	}

	@Override
	public List<ReservationVo> getAllCanceledReservation(int id) {
		return reservationDao.getAllCanceledReservation(id);
	}

}
