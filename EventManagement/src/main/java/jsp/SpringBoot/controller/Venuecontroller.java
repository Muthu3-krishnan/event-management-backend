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
import jsp.SpringBoot.entity.Venue;
import jsp.SpringBoot.service.Venueservice;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/venue")
public class Venuecontroller {

	@Autowired
	private Venueservice venueservice;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Venue>> addvenue(@RequestBody Venue venue){
		return venueservice.addvenue(venue);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Venue>>> getAllVenue(){
		return venueservice.getAllVenue();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Venue>> getVenueById(@PathVariable Integer id){
		return venueservice.getVenueById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Venue>> updateVenue(@RequestBody Venue venue){
		return venueservice.updateVenue(venue);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteVenue(@PathVariable Integer id){
		return venueservice.deleteVenue(id);
	}
	
	@GetMapping("/getevent/{id}")
	public ResponseEntity<ResponseStructure<List<Event>>> getEventByVenueId(@PathVariable Integer id){
		return venueservice.getEventByVenueId(id);
	}
	
	@GetMapping("/getvenue/{location}")
	public ResponseEntity<ResponseStructure<List<Venue>>> getVenueByLocation(@PathVariable String location){
		return venueservice.getVenueByLoacation(location);
	}
	
	@GetMapping("/P&S/{PageNumber}/{PageSize}/{field}")
	public ResponseEntity<ResponseStructure<Page<Venue>>> getVenueByPaginationAndSorting(@PathVariable int PageNumber, @PathVariable int PageSize,@PathVariable String field){
		return venueservice.getVenuePaginationAndSorting(PageNumber, PageSize, field);
	}
}
