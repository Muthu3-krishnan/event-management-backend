package jsp.SpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jsp.SpringBoot.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

    @Query("select r from Registration r where r.event.id = ?1")
    List<Registration> getRegistrationByEventId(Integer id);

    @Query("select r from Registration r where r.attendee.id = ?1")
    List<Registration> getRegistrationByAttendee(Integer id);

    @Query("select r from Registration r where r.attendee.id = ?1 and r.event.id = ?2")
    Registration findByAttendeeIdAndEventId(Integer attendeeId, Integer eventId);
}
