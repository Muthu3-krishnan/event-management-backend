package jsp.SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jsp.SpringBoot.entity.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {
	
	
}
