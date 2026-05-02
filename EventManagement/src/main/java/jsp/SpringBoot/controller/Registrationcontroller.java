package jsp.SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import jsp.SpringBoot.entity.Registration;
import jsp.SpringBoot.service.Registrationservice;
@CrossOrigin(origins = "https://event-management-frontend-livid-three.vercel.app")
@RestController
@RequestMapping("/registration")
public class Registrationcontroller {

	@Autowired
	private Registrationservice registrationservice;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Registration>> createRegistration(@RequestBody Registration registration){
		return registrationservice.createregistration(registration);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Registration>>> getAllRegistration(){
		return registrationservice.getAllRegistration();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Registration>> getRegistrationById(@PathVariable Integer id){
		return registrationservice.getRegistrationById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Registration>> updatRegistration(@RequestBody Registration registration){
		return registrationservice.updateRegistration(registration);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteRegistration(@PathVariable Integer id){
		return registrationservice.deleteRegistration(id);
	}
	
	@GetMapping("/getregistration/{id}")
	public ResponseEntity<ResponseStructure<List<Registration>>> getRegistrationByEventId(@PathVariable Integer id){
		return registrationservice.getRegistrationByEventId(id);
	}
	
	@GetMapping("/getregistrationbyattendee/{id}")
	public ResponseEntity<ResponseStructure<List<Registration>>> getRegistrationByAttendee(@PathVariable Integer id){
		return registrationservice.getRegistrationByAttendee(id);
	}
}
