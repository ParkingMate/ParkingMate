package com.app.parkingmate.service;

import com.app.parkingmate.domain.VO.ReservationVO;
import com.app.parkingmate.repository.ReservationDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationDAO reservationDAO;
    @Override
    public void insert(ReservationVO reservationVO) {
        reservationDAO.insert(reservationVO);
    }

    @Override
    public List<ReservationVO> list(Integer userId) {
        return reservationDAO.list(userId);
    }

    @Override
    public void cancel(ReservationVO reservationVO) {
        reservationDAO.cancel(reservationVO);
    }
}
