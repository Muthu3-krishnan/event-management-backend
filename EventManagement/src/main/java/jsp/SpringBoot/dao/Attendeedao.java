package jsp.SpringBoot.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import jsp.SpringBoot.entity.Attendee;
import jsp.SpringBoot.entity.Registration;
import jsp.SpringBoot.exception.IdNotFoundException;
import jsp.SpringBoot.exception.NoRecordFoundException;
import jsp.SpringBoot.repository.AttendeeRepository;

@Repository
public class Attendeedao {

	@Autowired
	private AttendeeRepository repository;
	
	public Attendee registerAttendee(Attendee attendee) {
		return repository.save(attendee);
	}
	
	public List<Attendee> getAllAttendee(){
		List<Attendee> attendees=repository.findAll();
		if(!attendees.isEmpty())
			return attendees;
		throw new NoRecordFoundException("no record available");
	}
	
	public Attendee getAttendeeById(Integer id) {
		Optional<Attendee> optional=repository.findById(id);
		if(optional.isPresent())
			return optional.get();
		throw new IdNotFoundException("invalid id");
	}
	
	public Attendee updateAttendee(Attendee attendee) {
		Optional<Attendee> optional=repository.findById(attendee.getId());
		if(optional.isPresent())
			return repository.save(attendee);
		throw new IdNotFoundException("invalid id");
	}
	
	public void deleteAttendee (Integer id) {
		Optional<Attendee> optional=repository.findById(id);
		if(optional.isEmpty())
			throw new IdNotFoundException("invalid id");
		repository.delete(optional.get());
	}
	
	public Attendee getAttendeeByContact(long contact) {
		Optional<Attendee> optional=repository.getAttendeeByContact(contact);
		if(optional.isPresent())
			return optional.get();
		throw new NoRecordFoundException("no record found");
	}
	
	public List<Registration> getRegistrationByAttendee(Integer id){
		List<Registration> registrations=repository.getRegistrationByAttendee(id);
		if(!registrations.isEmpty())
			return registrations;
		throw new NoRecordFoundException("no record found");
	}
	
	public Page<Attendee> getAttendeeByPaginationAndSorting(int PageNumber, int PageSize, String field){
		return repository.findAll(PageRequest.of(PageNumber, PageSize,Sort.by(field).ascending()));
	}
}
