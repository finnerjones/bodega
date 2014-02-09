package com.finnerjones.bodega.persistence.jpa;

import javax.ejb.Local;

import com.finnerjones.bodega.core.exceptions.BodegaDatabaseException;

@Local
public interface BodegaJpaPersistence extends JpaPersistence {

	public void insert(Object entity) throws BodegaDatabaseException;

	public Object update(Object entity) throws BodegaDatabaseException;

	public void delete(Object entity) throws BodegaDatabaseException;

	public Object find(Class<?> entityClass, Object primaryKey) throws BodegaDatabaseException;

}
