package jsp.SpringBoot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import jsp.SpringBoot.entity.Organizer;
import jsp.SpringBoot.exception.IdNotFoundException;
import jsp.SpringBoot.exception.NoRecordFoundException;
import jsp.SpringBoot.repository.OrganizerRepository;

@Repository
public class Organizerdao {

	@Autowired
	private OrganizerRepository repository;
	
	public Organizer addorganizer(Organizer organizer) {
		return repository.save(organizer);
	}
	
	public List<Organizer> getAllOrganizer(){
		List<Organizer> organizers=repository.findAll();
		if(organizers.isEmpty())
			throw new IdNotFoundException("invalid id");
		return organizers;
	}
	
	public Organizer getOrganizerById(Integer id) {
		Optional<Organizer> optional=repository.findById(id);
		if(optional.isEmpty())
			throw new IdNotFoundException("invalid id");
		return optional.get();
	}
	
	public Organizer updateOrganizer(Organizer organizer) {
		Optional<Organizer> optional=repository.findById(organizer.getId());
		if(optional.isPresent())
			return repository.save(organizer);
		throw new IdNotFoundException("invalid id");
	}
	
	public void deleteOrganizer(Integer id) {
		Optional<Organizer> optional=repository.findById(id);
		if(optional.isEmpty())
			throw new IdNotFoundException("invalid id");
		repository.delete(optional.get());
	}
	
	public Page<Organizer> getOrganizerByPaginationAndSorting(int PageNumber, int PageSize, String field){
		Page<Organizer> page=repository.findAll(PageRequest.of(PageNumber, PageSize,Sort.by(field).ascending()));
		if(page.isEmpty())
			throw new NoRecordFoundException("No record found exception");
		return page;
	}
}
