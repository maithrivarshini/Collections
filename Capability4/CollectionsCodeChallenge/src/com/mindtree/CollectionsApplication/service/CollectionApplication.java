package com.mindtree.CollectionsApplication.service;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.mindtree.CollectionsApplication.entity.City;
import com.mindtree.CollectionsApplication.entity.Country;

public interface CollectionApplication {
	Map<Country, Set<City>> createCountry(Scanner sc);
	Map<Country,Set<City>> addCountryAndCity(Map<Country,Set<City>> countries,String country,Set<City> cities);
	Map<Country,Set<City>> updateCity(Map<Country,Set<City>> countries,String country,String city);

}
