package jsp.SpringBoot.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import jsp.SpringBoot.entity.Event;
import jsp.SpringBoot.entity.Venue;
import jsp.SpringBoot.exception.IdNotFoundException;
import jsp.SpringBoot.exception.NoRecordFoundException;
import jsp.SpringBoot.repository.VenueRepository;

@Repository
public class venuedao {

	@Autowired
	private VenueRepository repository;
	
	public Venue addvenue(Venue venue) {
		return repository.save(venue);
	}
	
	public  List<Venue> getAllVenue(){
		List<Venue> venues=repository.findAll();
		if(!venues.isEmpty()) {
			return venues;}
		throw new NoRecordFoundException("no records available");
	}
	
	public Venue getVenueById(Integer id) {
		Optional<Venue> optional=repository.findById(id);
		if(optional.isPresent())
			return optional.get();
		throw new IdNotFoundException("invalid id");
	}
	
	public Venue updateVenue(Venue venue) {
		Optional<Venue> optional=repository.findById(venue.getId());
		if(optional.isPresent())
			return repository.save(venue);
		throw new IdNotFoundException("invalid id");
	}
	
	public void deleteEvent(Integer id) {
	    Optional<Venue> venue = repository.findById(id);
	    if (venue.isEmpty()) 
	    	throw new IdNotFoundException("invalid id");
	    repository.delete(venue.get());
	}
	
	public List<Event> getEventByVenueId(Integer id){
		List<Event> events=repository.getEventByVenueId(id);
		if(!events.isEmpty())
			return events;
		throw new IdNotFoundException("invalid id");
	}
	
	public List<Venue> getVenueByLocation(String location){
		List<Venue> venues=repository.getVenueByLocation(location);
		if(venues.isEmpty())
			throw new NoRecordFoundException("no records available");
		return venues;
	}
	
	public Page<Venue> getVenuePaginationAndSorting(int PageNumber, int PageSize, String field){
		Page<Venue> page=repository.findAll(PageRequest.of(PageNumber, PageSize, Sort.by(field).ascending()));
		if(page.isEmpty())
			throw new NoRecordFoundException("no record available");
		return page;
	}
}
