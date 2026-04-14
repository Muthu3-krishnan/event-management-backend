package jsp.SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import jsp.SpringBoot.dao.Organizerdao;
import jsp.SpringBoot.dto.ResponseStructure;
import jsp.SpringBoot.entity.Organizer;

@Service
public class Organizerservice {

	@Autowired
	private Organizerdao organizerdao;
	
	public ResponseEntity<ResponseStructure<Organizer>> addorganizer(Organizer organizer){
		ResponseStructure<Organizer> structure=new ResponseStructure<Organizer>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("created");
		structure.setData(organizerdao.addorganizer(organizer));
		return new ResponseEntity<ResponseStructure<Organizer>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Organizer>>> getAllOrganizer( ){
		ResponseStructure<List<Organizer>> structure=new ResponseStructure<List<Organizer>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("fetched");
		structure.setData(organizerdao.getAllOrganizer());
		return new ResponseEntity<ResponseStructure<List<Organizer>>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Organizer>> getOrganizerById(Integer id){
		ResponseStructure<Organizer> structure=new ResponseStructure<Organizer>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("fetched based on id");
		structure.setData(organizerdao.getOrganizerById(id));
		return new ResponseEntity<ResponseStructure<Organizer>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Organizer>> updateOrganizer(Organizer organizer){
		ResponseStructure<Organizer> structure=new ResponseStructure<Organizer>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("updated");
		structure.setData(organizerdao.updateOrganizer(organizer));
		return new ResponseEntity<ResponseStructure<Organizer>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteOrganizer(Integer id){
		organizerdao.deleteOrganizer(id);
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("deleted");
		structure.setData("successfully deleted");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Page<Organizer>>> getOrganizerByPaginationAndSorting(int PageNumber, int PageSize, String field){
		ResponseStructure<Page<Organizer>> structure=new ResponseStructure<Page<Organizer>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Pagination and Sorting");
		structure.setData(organizerdao.getOrganizerByPaginationAndSorting(PageNumber, PageSize, field));
		return new ResponseEntity<ResponseStructure<Page<Organizer>>>(structure, HttpStatus.OK);
	}
	
}
