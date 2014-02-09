package com.finnerjones.bodega.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "YEARS")
@NamedQueries({ @NamedQuery(name = "findAllYears", query = "select yrs from Year yrs") })
public class Year {

	protected Long id;
	protected Integer year;

	@Id
	@Column(name = "YEARS_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "YEARS_YYYY")
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}
