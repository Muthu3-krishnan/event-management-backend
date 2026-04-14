package jsp.SpringBoot.service;

import org.springframework.data.domain.Page;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import jsp.SpringBoot.dao.Attendeedao;
import jsp.SpringBoot.dto.ResponseStructure;
import jsp.SpringBoot.entity.Attendee;
import jsp.SpringBoot.entity.Registration;

@Service
public class Attendeeservice {

	@Autowired
	private Attendeedao attendeedao;
	
	public ResponseEntity<ResponseStructure<Attendee>> registerAttendee(Attendee attendee){
		ResponseStructure<Attendee> structure=new ResponseStructure<Attendee>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("created");
		structure.setData(attendeedao.registerAttendee(attendee));
		return new ResponseEntity<ResponseStructure<Attendee>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Attendee>>> getAllAttendee(){
		ResponseStructure<List<Attendee>> structure=new ResponseStructure<List<Attendee>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("fetched");
		structure.setData(attendeedao.getAllAttendee());
		return new ResponseEntity<ResponseStructure<List<Attendee>>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Attendee>> getAttendeeById(Integer id){
			ResponseStructure<Attendee> structure=new ResponseStructure<Attendee>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("fetched based on id");
			structure.setData(attendeedao.getAttendeeById(id));
			return new ResponseEntity<ResponseStructure<Attendee>>(structure, HttpStatus.OK);			
	}
	
	public ResponseEntity<ResponseStructure<Attendee>> updateAttendee(Attendee attendee){
		ResponseStructure<Attendee> structure=new ResponseStructure<Attendee>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("updated");
		structure.setData(attendeedao.updateAttendee(attendee));
		return new ResponseEntity<ResponseStructure<Attendee>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteAttendee(Integer id){
		attendeedao.deleteAttendee(id);
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("deleted");
		structure.setData("successfully deleted");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Attendee>> getAttendeeByContact(long contact){
		ResponseStructure<Attendee> structure=new ResponseStructure<Attendee>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("fetched Attendeee by using contact");
		structure.setData(attendeedao.getAttendeeByContact(contact));
		return new ResponseEntity<ResponseStructure<Attendee>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Registration>>> getRegistrationByAttendee(Integer id){
		ResponseStructure<List<Registration>> structure=new ResponseStructure<List<Registration>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("fetched based oh attendee");
		structure.setData(attendeedao.getRegistrationByAttendee(id));
		return new ResponseEntity<ResponseStructure<List<Registration>>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Page<Attendee>>> getAttendeeByPaginationAndSorting(int PageNumber, int PageSize, String field){
		ResponseStructure<Page<Attendee>> structure=new ResponseStructure<Page<Attendee>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("success");
		structure.setData(attendeedao.getAttendeeByPaginationAndSorting(PageNumber, PageSize, field));
		return new ResponseEntity<ResponseStructure<Page<Attendee>>>(structure, HttpStatus.OK);
	}
}
