package com.app.parkingmate.repository;

import com.app.parkingmate.domain.EventSearch;
import com.app.parkingmate.domain.EventSearchDTO;
import com.app.parkingmate.domain.Pagination;
import com.app.parkingmate.domain.VO.EventVO;
import com.app.parkingmate.mapper.EventMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class EventDAO {
    private final EventMapper eventMapper;

//    이벤트 작성
    public void save(EventVO eventVO){eventMapper.insert(eventVO);}

//    이벤트 리스트
    public List<EventVO> list( Pagination pagination,  EventSearch eventSearch, String keyword){return eventMapper.selectAll(pagination, eventSearch,keyword);}


//    이벤트 디테일
    public Optional<EventVO> selectByEventId(Integer id){return eventMapper.select(id);}


//    이벤트 수정
    public void update(EventVO eventVO){eventMapper.update(eventVO);}

//    이벤트 status 수정
    public void updateStatus(EventVO eventVO){eventMapper.update(eventVO);}

    //    이벤트 리스트 카운트
    public int selectTotal(EventSearch eventSearch){ return eventMapper.selectTotal(eventSearch);}

//    이벤트 검색
    public List<EventVO> selectSearch(EventSearch eventSearch){return eventMapper.selectSearch(eventSearch);}

    public Integer nextEvent(Integer id){return eventMapper.nextEvent(id);};

    public Integer prevEvent(Integer id){return eventMapper.prevEvent(id);};
}
