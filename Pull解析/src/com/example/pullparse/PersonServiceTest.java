package com.example.pullparse;

import java.io.InputStream;
import java.util.ArrayList;

import android.test.AndroidTestCase;
import android.util.Log;

public class PersonServiceTest extends AndroidTestCase {

	public static final String TAG = "PersonServiceTest";
	
	public void parseTest() throws Exception{
		
		
		InputStream xml = this.getClass().getClassLoader().getResourceAsStream("person.xml");
		ArrayList<Person> persons = PersonService.getPersons(xml);
		for(Person person : persons){
			Log.d(TAG, person.toString());
		}
			
		
		
	}
	
}
