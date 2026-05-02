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
import jsp.SpringBoot.entity.Organizer;
import jsp.SpringBoot.service.Organizerservice;
@CrossOrigin(origins = "https://event-management-frontend-livid-three.vercel.app")
@RestController
@RequestMapping("/organizer")
public class Organizercontroller {

	@Autowired
	private Organizerservice organizerservice;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Organizer>> addorganizer(@RequestBody Organizer organizer){
		return organizerservice.addorganizer(organizer);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Organizer>>> getAllOrganizer(){
		return organizerservice.getAllOrganizer();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Organizer>> getOrganizerById(@PathVariable Integer id){
		return organizerservice.getOrganizerById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Organizer>> updateOrganizer(@RequestBody Organizer organizer){
		return organizerservice.updateOrganizer(organizer);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteOrganizer(@PathVariable Integer id){
		return organizerservice.deleteOrganizer(id);
	}
	
	@GetMapping("/P&S/{PageNumber}/{PageSize}/{field}")
	public ResponseEntity<ResponseStructure<Page<Organizer>>> getOrganizerByPaginationAndSorting(@PathVariable int PageNumber, @PathVariable int PageSize, @PathVariable String field){
		return organizerservice.getOrganizerByPaginationAndSorting(PageNumber, PageSize, field);
	}
}
