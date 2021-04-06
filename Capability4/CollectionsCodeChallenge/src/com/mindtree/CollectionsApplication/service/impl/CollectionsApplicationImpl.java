package com.mindtree.CollectionsApplication.service.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import com.mindtree.CollectionsApplication.entity.City;
import com.mindtree.CollectionsApplication.entity.Country;
import com.mindtree.CollectionsApplication.service.CollectionApplication;

public class CollectionsApplicationImpl implements CollectionApplication {

	@Override
	public Map<Country, Set<City>> createCountry(Scanner sc) {
		Map<Country,Set<City>> countries = new LinkedHashMap<>();
		
		System.out.println("Enter number of countries you want to add");
		int countryNumber = sc.nextInt();
		sc.nextLine();
		for(int i = 0;i<countryNumber;i++)
		{
			System.out.println("Enter Country Name");
			String country = sc.nextLine();
			Country countryObj = new Country(country);
			System.out.println("Enter number of cities that country have");
			int cityNumber = sc.nextInt();
			sc.nextLine();
			Set<City> cities = new LinkedHashSet<>();
			for(int j = 0;j<cityNumber;j++)
			{
				System.out.println("Enter City name");
				String city = sc.nextLine();
				
				City cityObj = new City(city);
				cities.add(cityObj);
			}
			
			countries.put(countryObj, cities);
		}
		return countries;
	}

	@Override
	public Map<Country,Set<City>> addCountryAndCity(Map<Country,Set<City>> countries, String country, Set<City> cities) {
		if(countries.size()>0)
		{
			Country countryObj = new Country(country);
			countries.put(countryObj, cities);
		}
		else
		{
			Map<Country,Set<City>> countries2 = new LinkedHashMap<>();
	
			Country countryObj = new Country(country);
			countries.put(countryObj, cities);
			countries=countries2;
		}
		return countries;
	}

	@Override
	public Map<Country,Set<City>> updateCity(Map<Country,Set<City>> countries, String country, String city) {
		if(countries.size()>0)
		{
			Set countrySet = countries.entrySet();
			Iterator iterator = countrySet.iterator();
			boolean isPresent = false;
			while(iterator.hasNext())
			{
				Map.Entry entry = (Entry) iterator.next();
				Country countryObj = (Country) entry.getKey();
				if(countryObj.getCountry().equalsIgnoreCase(country))
				{
					isPresent = true;
					Set<City> cities = (Set<City>) entry.getValue();
					City cityobj = new City(city);
					cities.add(cityobj);
				}
				
			}
			if(!isPresent)
				System.out.println("Country is not present");	
		}
		return countries;
	}

}
