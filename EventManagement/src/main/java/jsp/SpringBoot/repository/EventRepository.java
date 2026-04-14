package jsp.SpringBoot.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jsp.SpringBoot.entity.Attendee;
import jsp.SpringBoot.entity.Event;
import jsp.SpringBoot.entity.Organizer;

public interface EventRepository extends JpaRepository<Event, Integer> {
	
	@Query("select r.attendee from Registration r where r.event.id=?1")
	List<Attendee> getAttendeeByEvenetId(Integer id);
	
	@Query("select e from Event e where e.organizer.id=?1")
	List<Event> getEventByOrganizerId(Integer id);	
	

}

