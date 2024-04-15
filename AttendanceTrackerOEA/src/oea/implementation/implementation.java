package oea.implementation;

import oea.interfac.AttendanceInterface;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;


public class implementation implements AttendanceInterface{
	
	public Set<Integer> hs = new LinkedHashSet<Integer>();
	
	@Override
	public void recordAttendance(int id)
	{
		hs.add(id);
	}
	
	@Override
	public void createFile(String date)
	{
		String str = date+".csv";
		File myFile = new File(str);
		try {
			myFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
            FileWriter writer = new FileWriter(str, true); // Append mode
            for (Integer element : hs) {
                // Format each element as a comma-separated string
                String csvRow = String.valueOf(element); // Convert Integer to String
                // Write the formatted string to the CSV file
                writer.write(csvRow + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		hs.clear();
        
	}
	
	@Override
	public void checkAttendance(String date, int id) 
	{
		storeInLinkedHashSet(date);
		if(hs.contains(id))
		{
			System.out.println(id + " was Present on " + date);
		}
		else
		{
			System.out.println(id + " was Absent on " + date);
		}
		hs.clear();
	}
	
	@Override
	public void storeInLinkedHashSet(String date)
	{
		String str = date + ".csv";
		try (BufferedReader br = new BufferedReader(new FileReader(str))) {
            String line;
            while ((line = br.readLine()) != null) {
                int value = Integer.parseInt(line.trim()); 
                
                hs.add(value);
            }
        } catch (IOException e) {
        	System.out.println("File not found");
            e.printStackTrace();
        }
	}
	
	@Override
	public void retrieveAttendance(String date) 
	{
		storeInLinkedHashSet(date);
		System.out.println("Attendance on " + date + " : " + hs);
		hs.clear();
		
	}
	
	public void appendAttendance(String date, int id)
	{
		String str = date+".csv";
		String csvRow = String.valueOf(id);
		try {
            FileWriter writer = new FileWriter(str, true); // Append mode
            writer.write(csvRow + "\n");
            writer.close();
            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
