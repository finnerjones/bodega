package com.finnerjones.bodega.persistence.jpa.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.finnerjones.bodega.persistence.entities.Year;
import com.finnerjones.bodega.persistence.jpa.YearsJpaPersistence;

@Stateless
public class YearsJpaPersistenceEjb extends BodegaJpaPersistenceEjb implements YearsJpaPersistence {

	@Override
	@SuppressWarnings("unchecked")
	public List<Year> findAllYears() {
		Query query = getEntityManager().createNamedQuery("findAllYears");
		List<Year> years = query.getResultList();
		return years;

	}

}
