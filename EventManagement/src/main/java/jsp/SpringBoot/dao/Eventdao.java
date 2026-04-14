package jsp.SpringBoot.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import jsp.SpringBoot.entity.Attendee;
import jsp.SpringBoot.entity.Event;
import jsp.SpringBoot.entity.Venue;
import jsp.SpringBoot.exception.IdNotFoundException;
import jsp.SpringBoot.exception.NoRecordFoundException;
import jsp.SpringBoot.repository.EventRepository;

@Repository
public class Eventdao {

	@Autowired
	private EventRepository repository;
	
	public Event createEvent(Event event) {
		return repository.save(event);
	}
	
	public List<Event> getAllEvent(){
		List<Event> events=repository.findAll();
		if(!events.isEmpty())
			return events;
		throw new NoRecordFoundException("No Records available");
	}
	
	public Event getEventById(Integer id) {
		Optional<Event> optional=repository.findById(id);
		if(optional.isPresent())
			return optional.get();
		throw new IdNotFoundException("invalid id");
	}
	
	public Event updateEvent (Event event) {
		Optional<Event> optional=repository.findById(event.getId());
		if(!optional.isEmpty())
			return repository.save(event);
		throw new IdNotFoundException("invalid id");
	}
	
	public void deleteEvent(Integer id) {
	    Optional<Event> event = repository.findById(id);
	    if (event.isEmpty()) 
	    	throw new IdNotFoundException("invalid id");
	    repository.delete(event.get());
	}
	
	public List<Attendee> getAttendeeByEventId(Integer id){
		List<Attendee> attendees=repository.getAttendeeByEvenetId(id);
		if(attendees.isEmpty())
			throw new IdNotFoundException("invalid id");
		return attendees;
	}
	
	public List<Event> getEventByOrganizerId(Integer id){
		List<Event> attendees=repository.getEventByOrganizerId(id);
		if(attendees.isEmpty())
			throw new IdNotFoundException("invalid id");
		return attendees;
	}
	
	public Page<Event> getEventPaginationAndSorting(int PageNumber, int PageSize, String field){
		Page<Event> page=repository.findAll(PageRequest.of(PageNumber, PageSize, Sort.by(field).ascending()));
		if(page.isEmpty())
			throw new NoRecordFoundException("no record available");
		return page;
	}

}
