package com.app.parkingmate.service;

import com.app.parkingmate.domain.EventSearch;
import com.app.parkingmate.domain.EventSearchDTO;
import com.app.parkingmate.domain.Pagination;
import com.app.parkingmate.domain.VO.EventVO;
import com.app.parkingmate.repository.EventDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventDAO eventDAO;
    @Override
    public void create(EventVO eventVO) {
        eventDAO.save(eventVO);
    }


    @Override
    public List<EventVO> list(Pagination pagination ,EventSearch eventSearch,String keyword) {
        return eventDAO.list(pagination, eventSearch,keyword);
    }

    @Override
    public int selectTotal(EventSearch eventSearch) {
        return eventDAO.selectTotal(eventSearch);
    }

    @Override
    public Optional<EventVO> detail(Integer id) {
        return eventDAO.selectByEventId(id);
    }

    @Override
    public void update(EventVO eventVO) {
        eventDAO.update(eventVO);
    }

    @Override
    public void updateStatus(EventVO eventVO) {
        eventDAO.updateStatus(eventVO);
    }

    @Override
    public EventSearchDTO searchEvent(EventSearch eventSearch) {
        EventSearchDTO eventSearchDTO  = new EventSearchDTO();
        eventSearchDTO.setFreeEvents(eventDAO.selectSearch(eventSearch));
        eventSearchDTO.setFreeEventsTotalCount(eventDAO.selectTotal(eventSearch));
        return eventSearchDTO;
    }

    @Override
    public Integer nextEvent(Integer id) {
       return eventDAO.nextEvent(id);
    }

    @Override
    public Integer prevEvent(Integer id) {
       return eventDAO.prevEvent(id);
    }
}
