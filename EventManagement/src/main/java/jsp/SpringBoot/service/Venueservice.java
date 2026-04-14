package jsp.SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import jsp.SpringBoot.dao.venuedao;
import jsp.SpringBoot.dto.ResponseStructure;
import jsp.SpringBoot.entity.Attendee;
import jsp.SpringBoot.entity.Event;
import jsp.SpringBoot.entity.Venue;

@Service
public class Venueservice {

	@Autowired
	private venuedao venuedao;
	
	public ResponseEntity<ResponseStructure<Venue>> addvenue(Venue venue){
		ResponseStructure<Venue> structure=new ResponseStructure<Venue>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("created");
		structure.setData(venuedao.addvenue(venue));
		return new ResponseEntity<ResponseStructure<Venue>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Venue>>> getAllVenue (){
		ResponseStructure<List<Venue>> structure=new ResponseStructure<List<Venue>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("fetched");
		structure.setData(venuedao.getAllVenue());
		return new ResponseEntity<ResponseStructure<List<Venue>>>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Venue>> getVenueById(Integer id){
		ResponseStructure<Venue> structure=new ResponseStructure<Venue>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("fetched based omnm id");
		structure.setData(venuedao.getVenueById(id));
		return new ResponseEntity<ResponseStructure<Venue>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Venue>> updateVenue(Venue  venue){
		ResponseStructure<Venue> structure=new ResponseStructure<Venue>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("updated");
		structure.setData(venuedao.updateVenue(venue));
		return new ResponseEntity<ResponseStructure<Venue>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteVenue(Integer id){
		venuedao.deleteEvent(id);
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("updated");
		structure.setData("successfully deleted");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Event>>> getEventByVenueId(Integer id){
		ResponseStructure<List<Event>> structure=new ResponseStructure<List<Event>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("fetched based on venue id");
		structure.setData(venuedao.getEventByVenueId(id));
		return new ResponseEntity<ResponseStructure<List<Event>>>(structure, HttpStatus.OK);
	}
	
	
	public ResponseEntity<ResponseStructure<List<Venue>>> getVenueByLoacation(String location){
		ResponseStructure<List<Venue>> structure=new ResponseStructure<List<Venue>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("fetched based on location");
		structure.setData(venuedao.getVenueByLocation(location));
		return new ResponseEntity<ResponseStructure<List<Venue>>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Page<Venue>>> getVenuePaginationAndSorting(int PageNumber, int PageSize, String field){
		ResponseStructure<Page<Venue>> structure=new ResponseStructure<Page<Venue>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("success");
		structure.setData(venuedao.getVenuePaginationAndSorting(PageNumber, PageSize, field));
		return new ResponseEntity<ResponseStructure<Page<Venue>>>(structure, HttpStatus.OK);
	}
}
