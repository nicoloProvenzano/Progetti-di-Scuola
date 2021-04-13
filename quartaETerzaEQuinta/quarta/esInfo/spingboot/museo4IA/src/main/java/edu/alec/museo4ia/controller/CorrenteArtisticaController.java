package edu.alec.museo4ia.controller;

import edu.alec.museo4ia.entity.CorrenteArtistica;
import edu.alec.museo4ia.repository.CorrenteArtisticaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alessandro Cazziolato
 */

@RestController
@RequestMapping("/correntiArtistiche")
public class CorrenteArtisticaController {

	@Autowired
	CorrenteArtisticaRepo correnteArtisticaRepo;

	@RequestMapping()
	public List<CorrenteArtistica> mostraCorrentiArtistiche(){
		return correnteArtisticaRepo.findAll();
	}

	@GetMapping(("/{ca}"))
	public List<CorrenteArtistica> mostraCorrentiArtisticheByNome(@PathVariable("ca") String ca){
		return correnteArtisticaRepo.findCorrArtByCorrenteArtistica(ca);
	}

}
