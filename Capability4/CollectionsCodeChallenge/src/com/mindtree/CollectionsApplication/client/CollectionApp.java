package com.mindtree.CollectionsApplication.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.mindtree.CollectionsApplication.entity.City;
import com.mindtree.CollectionsApplication.entity.Country;
import com.mindtree.CollectionsApplication.service.CollectionApplication;
import com.mindtree.CollectionsApplication.service.impl.CollectionsApplicationImpl;

public class CollectionApp {

	public static void main(String[] args) {
	CollectionApplication collectionObject = new CollectionsApplicationImpl();
	CollectionApp collectionApp = new CollectionApp();
	Scanner sc = new Scanner(System.in);
	int choice;
	boolean exit=false;
	Map<Country, Set<City>> countries = new LinkedHashMap<>();
	do
	{
		collectionApp.displayMenu();
		choice = sc.nextInt();
		sc.nextLine();
		switch(choice)
		{
		case 1:countries = collectionObject.createCountry(sc);
				break;
		case 2: collectionApp.displayAll(countries);
				break;
		case 3: System.out.println("Enter country name");
		 		String country = sc.nextLine();
		 		collectionApp.displayCity(countries,country);
		 		break;
		case 4:	System.out.println("Enter Country name");
				String countryName = sc.nextLine();
				System.out.println("Enter number of cities you like to add");
				int number = sc.nextInt();
				sc.nextLine();
				Set<City> cities = new LinkedHashSet<>();
				for(int i = 0;i<number;i++)
				{
					System.out.println("Enter City Name");
					String cityName = sc.nextLine();
					City cityobj = new City(cityName);
					cities.add(cityobj);
				}
				
				countries = collectionObject.addCountryAndCity(countries, countryName, cities);
				break;
		case 5: System.out.println("Enter Country name");
				String countryName1 = sc.nextLine();
				System.out.println("Enter City Name");
				String cityName1 = sc.nextLine();
				
				
				countries = collectionObject.updateCity(countries, countryName1, cityName1);
				break;
		case 6: exit = true;
				break;
		}
		
	}while(!exit);
	sc.close();
	
	
	}

	public void displayCity(Map<Country, Set<City>> countries, String country) {
		if(countries.size()>0)
		{
			Set countrySet = countries.entrySet();
			Iterator iterator = countrySet.iterator();
			boolean isPresent = false;
			while(iterator.hasNext())
			{
				Map.Entry entry = (Entry) iterator.next();
				Country countryObj = (Country) entry.getKey();
				if(countryObj.getCountry().equals(country)&&!isPresent)
				{
					isPresent = true;
					Set<City> cities = (Set<City>) entry.getValue();
					cities.forEach(System.out::println);
				}
			
			}
			if(!isPresent)
				System.out.println("Country is not present");	
			
		}
		else
			System.out.println("There is no data");
		
	}

	public void displayAll(Map<Country,Set<City>> countries) {
		
		Comparator<City> comparator = (City c1,City c2)->{
			if(c1.getCity().compareToIgnoreCase(c2.getCity())>0)
				return 1;
			else if(c1.getCity().compareToIgnoreCase(c2.getCity())<0)
				return -1;
			return 0;
				
			
		};
		if(countries.size()>0) {
		Set countrySet = countries.entrySet();
		Iterator iterator = countrySet.iterator();
		while(iterator.hasNext())
		{
			Map.Entry entry = (Entry) iterator.next();
			System.out.println(entry.getKey()+" : ");
			Set<City> cities = (Set<City>) entry.getValue();
			List<City> cityList = new ArrayList<>(cities);
			Collections.sort(cityList, comparator);
			cityList.forEach(System.out::print);
			System.out.println();
			
		}
	}
		else
			System.out.println("No Data");
	}		

	public void displayMenu() {
		System.out.println("1.Create Country and assign some cities to each Country");
		System.out.println("2.Display all countries and city details");
		System.out.println("3.Display all cities based on given country by user");
		System.out.println("4.Add a new country and city given by user");
		System.out.println("5.Update the cities of a country as given by user");
		System.out.println("6.Exit");
	}

}
