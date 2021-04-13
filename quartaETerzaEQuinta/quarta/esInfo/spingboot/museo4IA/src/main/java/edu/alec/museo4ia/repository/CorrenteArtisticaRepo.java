package edu.alec.museo4ia.repository;

import edu.alec.museo4ia.entity.CorrenteArtistica;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alessandro Cazziolato
 */

@Repository
public interface CorrenteArtisticaRepo extends CrudRepository<CorrenteArtistica, Long> {
	@Override
	public List<CorrenteArtistica> findAll();

	List<CorrenteArtistica> findCorrArtByCorrenteArtistica(String ca);
}
