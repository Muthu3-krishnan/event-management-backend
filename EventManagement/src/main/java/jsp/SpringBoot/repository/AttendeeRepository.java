package jsp.SpringBoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jsp.SpringBoot.entity.Attendee;
import jsp.SpringBoot.entity.Registration;

public interface AttendeeRepository extends JpaRepository<Attendee, Integer>{
	
	@Query("select a.registrations from Attendee a where a.id=?1")
	List<Registration> getRegistrationByAttendee(Integer id);
	
	@Query("select a from Attendee a where a.contact=?1")
	Optional<Attendee> getAttendeeByContact(long contact);
}
