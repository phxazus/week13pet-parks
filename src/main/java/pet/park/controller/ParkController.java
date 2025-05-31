package pet.park.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pet.park.controller.model.ContributorData;
import pet.park.service.ParkService;

@RestController
@RequestMapping("/pet_park")
@Slf4j
public class ParkController {
	@Autowired
	private ParkService parkService;
	
	@PostMapping("/contributor")
	public ContributorData insertContributor(@RequestBody ContributorData contributorData) {
		log.info("Creating contributor()", contributorData);
		return parkService.saveContributor(contributorData);		
	}

	@GetMapping("/contributor")
	public List<ContributorData> retrieveAllContributors () {
		log.info("Retrieve all contributors called.");
		return parkService.retrieveAllContributors ();
	}
}
