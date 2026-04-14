package jsp.SpringBoot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.SpringBoot.entity.Registration;
import jsp.SpringBoot.exception.IdNotFoundException;
import jsp.SpringBoot.exception.NoRecordFoundException;
import jsp.SpringBoot.repository.RegistrationRepository;

@Repository
public class Registrationdao {

	@Autowired
	private RegistrationRepository repository;
	
	public Registration createregistration(Registration registration) {
		return repository.save(registration);
	}
	
	public List<Registration> getAllRegistration(){
		List<Registration> registrations=repository.findAll();
		if(!registrations.isEmpty())
			return registrations;
		throw new NoRecordFoundException("no records found");
	}
	
	public Registration getRegistrationById(Integer id) {
		Optional<Registration> optional=repository.findById(id);
		if(optional.isPresent())
			return optional.get();
		throw new IdNotFoundException("invalid id");
	}
	
	public Registration updateRegistration(Registration registration) {
		Optional<Registration> optional=repository.findById(registration.getId());
		if(optional.isPresent())
			return repository.save(registration);
		throw new IdNotFoundException("invalid id");
	}
	
	public void deleteRegistration(Integer id) {
		Optional<Registration> optional=repository.findById(id);
		if(optional.isEmpty())
			throw new IdNotFoundException("invalid id");
		repository.delete(optional.get());		
	}
	
	public List<Registration> getRegistrationByEventId(Integer id){
	    List<Registration> registrations = repository.getRegistrationByEventId(id);
	    if(!registrations.isEmpty())
	        return registrations;
	    throw new NoRecordFoundException("no registrations found for this event");
	}

	public List<Registration> getRegistrationByAttendee(Integer id){
	    List<Registration> registrations = repository.getRegistrationByAttendee(id);
	    if(!registrations.isEmpty())
	        return registrations;
	    throw new NoRecordFoundException("no registrations found for this attendee");
	}

	public Registration findByAttendeeIdAndEventId(Integer attendeeId, Integer eventId) {
	    return repository.findByAttendeeIdAndEventId(attendeeId, eventId);
	}

}
