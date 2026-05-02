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
import jsp.SpringBoot.entity.Event;
import jsp.SpringBoot.entity.Organizer;
import jsp.SpringBoot.entity.Venue;
import jsp.SpringBoot.service.Eventservice;
@CrossOrigin(origins = "https://event-management-frontend-livid-three.vercel.app")
@RestController
@RequestMapping("/event")
public class Eventcontroller {

	@Autowired
	private Eventservice eventservice;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Event>> createEvent(@RequestBody Event event){
		return eventservice.createEvent(event);
	}
	@CrossOrigin(origins = "https://event-management-frontend-livid-three.vercel.app")
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Event>>> getAllEvent(){
		return eventservice.getAllEvent();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Event>> getEventById(@PathVariable Integer id){
		return eventservice.getEventById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Event>> updateEvent(@RequestBody Event event){
		return eventservice.updateEvent(event);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteEvent(@PathVariable Integer id){
		return eventservice.deleteEvent(id);
	}
	
	@GetMapping("/getattendee/{id}")
	public ResponseEntity<ResponseStructure<List<Attendee>>> getAttendeeByEventId(@PathVariable Integer id){
		return eventservice.getAttendeeByEventId(id);
	}
	
	@GetMapping("/getevent/{id}")
	public ResponseEntity<ResponseStructure<List<Event>>> getEventByOrganizerId(@PathVariable Integer id){
		return eventservice.getEventByOrganizerId(id);
	}
	
	@GetMapping("/P&S/{PageNumber}/{PageSize}/{field}")
	public ResponseEntity<ResponseStructure<Page<Event>>> getVenueByPaginationAndSorting(@PathVariable int PageNumber, @PathVariable int PageSize,@PathVariable String field){
		return eventservice.getEventPaginationAndSorting(PageNumber, PageSize, field);
	}
}
