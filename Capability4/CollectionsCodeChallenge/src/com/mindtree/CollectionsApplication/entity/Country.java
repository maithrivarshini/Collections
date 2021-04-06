package com.mindtree.CollectionsApplication.entity;

public class Country implements Comparable<Country> {
	private String country;

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Country(String country) {
		super();
		this.country = country;
	}


	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Country [country=" + country + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		return true;
	}



	@Override
	public int compareTo(Country o) {
		if(this.country.compareToIgnoreCase(o.country)>0)
			return 1;
		else if(this.country.compareToIgnoreCase(o.country)<0)
			return -1;
		return 0;
	}

}
