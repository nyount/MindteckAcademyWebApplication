package com.mindteck.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.mindteck.entities.Graduate;

public class SerializeTest {

	public static void main(String[] args) {

		Graduate graduate = new Graduate();
		
		graduate.setFirstName("Chase");
		graduate.setLastName("McKelvey");
		graduate.setAddress1("Madison");
		graduate.setCourseId(1);
		graduate.setGraduateId(1);
		
		try {
			FileOutputStream fs = new FileOutputStream("grad.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(graduate);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fs = new FileInputStream("grad.ser");
			ObjectInputStream os = new ObjectInputStream(fs);
			Object one = os.readObject();
			os.close();
			Graduate g = (Graduate) one;
			System.out.println(g);
		} 
		catch (FileNotFoundException e) { e.printStackTrace(); } 
		catch (IOException e) { e.printStackTrace(); } 
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		
	}

}
