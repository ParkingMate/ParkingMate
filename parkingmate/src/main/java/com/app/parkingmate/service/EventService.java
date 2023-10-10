package com.app.parkingmate.service;

import com.app.parkingmate.domain.EventSearch;
import com.app.parkingmate.domain.EventSearchDTO;
import com.app.parkingmate.domain.Pagination;
import com.app.parkingmate.domain.VO.EventVO;

import java.util.List;
import java.util.Optional;

public interface EventService {
// 이벤트 작성
    public void create(EventVO eventVO);

//    이벤트 리스트

    public List<EventVO> list(Pagination pagination, EventSearch eventSearch,String keyword);

//    이벤트 리스트 카운터
    public int selectTotal(EventSearch eventSearch);

//    이벤트 디테일
    public Optional<EventVO> detail(Integer id);

    //    이벤트 수정
    public void update(EventVO eventVO);

//    이벤트 status 수정
    public void updateStatus(EventVO eventVO);

//    이벤트 검색
    public EventSearchDTO searchEvent(EventSearch eventSearch);

    public Integer nextEvent(Integer id);

    public Integer prevEvent(Integer id);
}
