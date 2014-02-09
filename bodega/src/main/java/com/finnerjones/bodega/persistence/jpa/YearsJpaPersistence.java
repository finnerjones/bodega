package com.finnerjones.bodega.persistence.jpa;

import java.util.List;

import javax.ejb.Local;

import com.finnerjones.bodega.persistence.entities.Year;

@Local
public interface YearsJpaPersistence extends BodegaJpaPersistence {

	public List<Year> findAllYears();

}
