package jsp.SpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jsp.SpringBoot.entity.Event;
import jsp.SpringBoot.entity.Venue;

public interface VenueRepository extends JpaRepository<Venue, Integer>{
	
	@Query("select e from Event e where e.venue.id = ?1")
	List<Event> getEventByVenueId(Integer id);
	
	@Query("select v from Venue v where v.location=?1")
	List<Venue> getVenueByLocation(String location);
	
}
