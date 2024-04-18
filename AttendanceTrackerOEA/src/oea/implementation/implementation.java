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
	public HashMap<Integer, String> employees = new HashMap<>();
	
	@Override
	public void values()
	{
		String csvFile = "C:\\Users\\richa\\git\\AttendanceTracker\\AttendanceTrackerOEA\\Employees.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Integer employeeID = Integer.parseInt(data[0].trim());
                String employeeName = data[1].trim();
                employees.put(employeeID, employeeName);
            }
            System.out.println("Data loaded from CSV file to HashMap successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	@Override
	public void printEmployees()
	{
		for (Integer key : employees.keySet()) {
            String value = employees.get(key);
            System.out.println(key + " : " + value);
        }
	}
	
	@Override
	public void recordAttendance(int id)
	{
		hs.add(id);
	}
	
	@Override
	public void addEmployee(int id, String name)
	{
		employees.put(id, name);
		String csvFile = "Employees.csv"; // Path to your existing CSV file


        try {
            FileWriter writer = new FileWriter(csvFile, true); // Append mode

            // Append new data to the CSV file
            writer.append(Integer.toString(id));
            writer.append(",");
            writer.append(name);
            writer.append("\n");

            writer.close();
            System.out.println("New entry added to the CSV file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@Override
	public void createFile(String date)
	{
		String str = date+".csv";
		File myFile = new File(str);
		try {
			myFile.createNewFile();
			System.out.println("File created at: " + myFile.getAbsolutePath());
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
		if(hs.contains(id) && employees.containsKey(id))
		{
			System.out.println(id + " was Present on " + date);
		}
		else if(employees.containsKey(id) && !hs.contains(id))
		{
			System.out.println(id + " was Absent on " + date);
		}
		else
		{
			System.out.println(id + " employee not in list ");
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
		System.out.println("Presentees on " + date + " : ");
		for (Integer id : hs) {
            System.out.println(id + " : " + employees.get(id));
        }
		System.out.println("Absentees on " + date + ":");
		
		for (Integer key : employees.keySet()) {
			
			if(!hs.contains(key))
			{
				String value = employees.get(key);
				System.out.println( + key + " : " + value);
			}
        }
		
		hs.clear();
		
	}
	
	@Override
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
