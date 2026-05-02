package jsp.SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jsp.SpringBoot.dto.ResponseStructure;
import jsp.SpringBoot.entity.Attendee;
import jsp.SpringBoot.entity.Registration;
import jsp.SpringBoot.service.Attendeeservice;
@CrossOrigin(origins = "https://event-management-frontend-livid-three.vercel.app")
@RestController
@RequestMapping("/attendee")
public class Attendeecontroller {

	@Autowired
	private Attendeeservice attendeeservice;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Attendee>> registerAttendee(@RequestBody Attendee attendee){
		return attendeeservice.registerAttendee(attendee);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Attendee>>> getAllAttendee(){
		return attendeeservice.getAllAttendee();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Attendee>> getAttendeeById(@PathVariable Integer id){
		return attendeeservice.getAttendeeById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Attendee>> updateAttendee(@RequestBody Attendee attendee){
		return attendeeservice.updateAttendee(attendee);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteAttendee(@PathVariable Integer id){
		return attendeeservice.deleteAttendee(id);
	}
	
	@GetMapping("/contact/{contact}")
	public ResponseEntity<ResponseStructure<Attendee>> getAttendeeByContact(@PathVariable long contact){
		return attendeeservice.getAttendeeByContact(contact);
	}
	
	@GetMapping("/getregistration/{id}")
	public ResponseEntity<ResponseStructure<List<Registration>>> getRegistrationByAttendee(@PathVariable Integer id){
		return  attendeeservice.getRegistrationByAttendee(id);
	}
	
	@GetMapping("/pagination&sorting/{PageNumber}/{PageSize}/{field}")
	public ResponseEntity<ResponseStructure<Page<Attendee>>> getAttendeeByPaginationAndSorting(@PathVariable int PageNumber, @PathVariable int PageSize,@PathVariable String field){
		return attendeeservice.getAttendeeByPaginationAndSorting(PageNumber, PageSize, field);
	}
}
