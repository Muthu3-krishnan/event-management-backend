package jsp.SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import jsp.SpringBoot.dao.Registrationdao;
import jsp.SpringBoot.dto.ResponseStructure;
import jsp.SpringBoot.entity.Registration;

@Service
public class Registrationservice {

	@Autowired
	private Registrationdao registrationdao;
	
	public ResponseEntity<ResponseStructure<Registration>> createregistration(Registration registration) {

	    Integer attendeeId = registration.getAttendee().getId();
	    Integer eventId = registration.getEvent().getId();

	    Registration existing =
	            registrationdao.findByAttendeeIdAndEventId(attendeeId, eventId);

	    if (existing != null) {
	        ResponseStructure<Registration> structure = new ResponseStructure<>();
	        structure.setStatusCode(HttpStatus.CONFLICT.value());
	        structure.setMessage("Attendee already registered for this event");
	        structure.setData(null);

	        return new ResponseEntity<>(structure, HttpStatus.CONFLICT);
	    }

	    ResponseStructure<Registration> structure = new ResponseStructure<>();
	    structure.setStatusCode(HttpStatus.CREATED.value());
	    structure.setMessage("created");
	    structure.setData(registrationdao.createregistration(registration));

	    return new ResponseEntity<>(structure, HttpStatus.CREATED);
	}

	
	public ResponseEntity<ResponseStructure<List<Registration>>> getAllRegistration(){
		ResponseStructure<List<Registration>> structure=new ResponseStructure<List<Registration>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("fetched");
		structure.setData(registrationdao.getAllRegistration());
		return new ResponseEntity<ResponseStructure<List<Registration>>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Registration>> getRegistrationById(Integer id){
		ResponseStructure<Registration> structure=new ResponseStructure<Registration>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("fetched based on id");
		structure.setData(registrationdao.getRegistrationById(id));
		return new ResponseEntity<ResponseStructure<Registration>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Registration>> updateRegistration(Registration registration){
		ResponseStructure<Registration> structure=new ResponseStructure<Registration>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("updated");
		structure.setData(registrationdao.updateRegistration(registration));
		return new ResponseEntity<ResponseStructure<Registration>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteRegistration(Integer id){
		registrationdao.deleteRegistration(id);
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("deleted");
		structure.setData("successfully deleted");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Registration>>> getRegistrationByEventId(Integer id){
		ResponseStructure<List<Registration>> structure=new ResponseStructure<List<Registration>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("fetched based on event id");
		structure.setData(registrationdao.getRegistrationByEventId(id));
		return new ResponseEntity<ResponseStructure<List<Registration>>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Registration>>> getRegistrationByAttendee(Integer id){
		ResponseStructure<List<Registration>> structure=new ResponseStructure<List<Registration>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("fetched based on attendee");
		structure.setData(registrationdao.getRegistrationByAttendee(id));
		return new ResponseEntity<ResponseStructure<List<Registration>>>(structure, HttpStatus.OK);
	}
}
