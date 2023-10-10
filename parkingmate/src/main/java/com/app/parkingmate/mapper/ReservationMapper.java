package com.app.parkingmate.mapper;

import com.app.parkingmate.domain.VO.ReservationVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {
//    예약하기
    public void insert(ReservationVO reservationVO);

//    예약내역
    public List<ReservationVO> selectByUserId(Integer userId);

//    예약취소
    public void cancel(ReservationVO reservationVO);
}
