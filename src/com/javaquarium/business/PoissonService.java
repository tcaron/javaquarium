package com.javaquarium.business;

import java.util.ArrayList;
import java.util.List;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.dao.IPoissonDAO;

/**
 * 
 * @author alex
 *
 */
public class PoissonService implements IPoissonService {

	// Création d'un poissonDAO qui fera le lien avec la bdd
	private IPoissonDAO poissonDAO;

	@Override
	public List<PoissonVO> findAll() {

		// Liste qui va contenir des poissons de type VO (web)
		final List<PoissonVO> listePoisson = new ArrayList<PoissonVO>();

		// Création d'une liste de PoissonDO (le bean de type bdd), on va faire la liste des élément de la base de données
	
		final List<PoissonDO> poissonDO = poissonDAO.list();
		
		for (final PoissonDO p : poissonDO) {
			// instanciation du bean (le bean de type web)
			final PoissonVO poissonVO = map(p);
			listePoisson.add(poissonVO);

		}
		return listePoisson;

	}

	/**
	 * setter PoissonDAO
	 * 
	 * @param poissonDAO
	 */
	public void setPoissonDAO(IPoissonDAO poissonDAO) {
		this.poissonDAO = poissonDAO;
	}

	@Override
	public void save(PoissonVO poissonvo) {

		final PoissonDO poissonDO = map(poissonvo);
		
		poissonDAO.insert(poissonDO);

	}

	private PoissonDO map(final PoissonVO poissonvo) {
		final PoissonDO poissonDO = new PoissonDO();

		poissonDO.setNom(poissonvo.getNom());
		poissonDO.setId(poissonvo.getId());
		poissonDO.setCouleur(poissonvo.getCouleur());
		poissonDO.setDescription(poissonvo.getDescription());
		poissonDO.setPrix(poissonvo.getPrix());
		String[] d = poissonvo.getDimension().split(PoissonVO.SEPARATOR_POISSON);
		poissonDO.setLongeur(Float.parseFloat(d[0]));
		poissonDO.setLargeur(Float.parseFloat(d[1]));
		return poissonDO;
	}

	private PoissonVO map(final PoissonDO p) {
		// On va récupéré les poissons de la base de données (DAO -> DO -> getters du  DO) qu'on va insérer dans la partie web (->poissonVO)
		
		final PoissonVO poissonVO = new PoissonVO();

		poissonVO.setNom(p.getNom());
		poissonVO.setId(p.getId());
		poissonVO.setCouleur(p.getCouleur());
		poissonVO.setDescription(p.getDescription());
		poissonVO.setDimension(p.getLongueur() + PoissonVO.SEPARATOR_POISSON + p.getLargeur());
		poissonVO.setPrix(p.getPrix());
		return poissonVO;
	}

	@Override
	public void delete(Integer code) {
		// TODO Auto-generated method stub

		poissonDAO.delete(code);
	}

	@Override
	public PoissonDO find(Integer id) {
		return poissonDAO.find(id);
	}

}
