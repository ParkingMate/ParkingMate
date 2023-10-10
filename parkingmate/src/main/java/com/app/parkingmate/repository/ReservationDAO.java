package com.app.parkingmate.repository;

import com.app.parkingmate.domain.VO.ReservationVO;
import com.app.parkingmate.mapper.ReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReservationDAO {
    public final ReservationMapper reservationMapper;

//    예약하기
    public void insert(ReservationVO reservationVO){reservationMapper.insert(reservationVO);}

//    예약리스트
    public List<ReservationVO> list(Integer userId){return reservationMapper.selectByUserId(userId);}

//    예약취소
    public void cancel(ReservationVO reservationVO){reservationMapper.cancel(reservationVO);}

}
