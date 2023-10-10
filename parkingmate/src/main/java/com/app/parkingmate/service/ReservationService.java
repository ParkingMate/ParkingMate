package com.app.parkingmate.service;

import com.app.parkingmate.domain.VO.ReservationVO;

import java.util.List;

public interface ReservationService {
//    예약하기
    public void insert(ReservationVO reservationVO);

//    예약내역
    public List<ReservationVO> list(Integer userId);

//    예약취소
    public void cancel(ReservationVO reservationVO);
}
