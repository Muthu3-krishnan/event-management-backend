package jsp.SpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import jsp.SpringBoot.dao.Eventdao;
import jsp.SpringBoot.dto.ResponseStructure;
import jsp.SpringBoot.entity.Attendee;
import jsp.SpringBoot.entity.Event;
import jsp.SpringBoot.entity.Venue;

@Service
public class Eventservice {

	@Autowired
	private Eventdao eventdao;
	
	public ResponseEntity<ResponseStructure<Event>> createEvent(Event event){
		ResponseStructure<Event> structure=new ResponseStructure<Event>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("message");
		structure.setData(eventdao.createEvent(event));
		return new ResponseEntity<ResponseStructure<Event>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Event>>> getAllEvent(){
		ResponseStructure<List<Event>> structure=new ResponseStructure<List<Event>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("fetched");
		structure.setData(eventdao.getAllEvent());
		return new ResponseEntity<ResponseStructure<List<Event>>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Event>> getEventById(Integer id){
		ResponseStructure<Event> structure=new ResponseStructure<Event>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("fetched based on id");
		structure.setData(eventdao.getEventById(id));
		return new ResponseEntity<ResponseStructure<Event>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Event>> updateEvent(Event event){
		Event e=eventdao.updateEvent(event);
		ResponseStructure<Event> structure=new ResponseStructure<Event>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("updated");
		structure.setData(e);
		return new ResponseEntity<ResponseStructure<Event>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteEvent(Integer id){
		eventdao.deleteEvent(id);
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("deleted");
		structure.setData("Successfully deleted");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Attendee>>> getAttendeeByEventId(Integer id){
		ResponseStructure<List<Attendee>> structure=new ResponseStructure<List<Attendee>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("fetched based on event id");
		structure.setData(eventdao.getAttendeeByEventId(id));
		return new ResponseEntity<ResponseStructure<List<Attendee>>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Event>>> getEventByOrganizerId(Integer id){
		ResponseStructure<List<Event>> structure=new ResponseStructure<List<Event>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("fetched based on oprganizer id");
		structure.setData(eventdao.getEventByOrganizerId(id));
		return new ResponseEntity<ResponseStructure<List<Event>>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Page<Event>>> getEventPaginationAndSorting(int PageNumber, int PageSize, String field){
		ResponseStructure<Page<Event>> structure=new ResponseStructure<Page<Event>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("success");
		structure.setData(eventdao.getEventPaginationAndSorting(PageNumber, PageSize, field));
		return new ResponseEntity<ResponseStructure<Page<Event>>>(structure, HttpStatus.OK);
	}
	
}
