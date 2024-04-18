package oea.frontEnd;

import java.util.*;
import oea.implementation.implementation;
import oea.interfac.AttendanceInterface;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AttendanceInterface record = new implementation();
		
		String date;
		int id;
		int a = 1;
		
		record.values();
		System.out.println("ID " + " : EMPLOYEE");
		record.printEmployees();
		System.out.println();
		
		System.out.println("-------ATTENDANCE TRACKER-------");
		
		while(a==1)
		{
			System.out.println();
			System.out.println("Case 1: Record Attendance");
			System.out.println("Case 2: Append Attendance");
			System.out.println("Case 3: Check Attendance");
			System.out.println("Case 4: Retrieve Attendance");
			System.out.println("Case 5: Add Employee in Employee List");
			System.out.println("Case 6: View Employee List");
			System.out.println("Case 0: Exit");
			System.out.println("Enter your choice : ");
			
			int choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					System.out.println();
					System.out.println("----Case 1----");
					int x = 1;
				
					System.out.println("Enter the date of attendance in DDMMYYYY format : ");
					date = sc.next();
					
					System.out.println("Enter the IDs who are present on " + date);
					while(x == 1)
					{
						System.out.println("Enter ID : ");
						record.recordAttendance(sc.nextInt());
						System.out.println("Enter 0 to exit and 1 to continue");
						x = sc.nextInt();
					}
					record.createFile(date);
					
					break;
					
				case 2:
					System.out.println();
					System.out.println("----Case 2----");
					System.out.println("Enter Date in DDMMYYYY format: ");
					date = sc.next();
					System.out.println("Enter the ID of Employee to be added on " + date + ":");
					id = sc.nextInt();
					record.appendAttendance(date, id);
					break;
					
				case 3:
					System.out.println();
					System.out.println("----Case 3----");
					System.out.println("Enter Date in DDMMYYYY format: ");
					date = sc.next();
					System.out.println("Enter ID of employee to check attendance on " + date + ":");
					id = sc.nextInt();
					record.checkAttendance(date, id);
					break;
				
				case 4:
					System.out.println();
					System.out.println("----Case 4----");
					System.out.println("Enter Date in DDMMYYYY format for which you want to retrieve attendance: ");
					date = sc.next();
					record.retrieveAttendance(date);
					break;
					
				case 5:
					System.out.println();
					System.out.println("----Case 5----");
					System.out.println("Enter ID of the Employee");
					id = sc.nextInt();
					System.out.println("Enter name of the Employee");
					String name = sc.next();
					record.addEmployee(id, name);
					break;
					
				case 6:
					System.out.println();
					System.out.println("----Case 6----");
					System.out.println("ID " + " : EMPLOYEE");
					record.printEmployees();
					break;
					
				case 0:
					a = 0;
					System.out.println();
					System.out.println("----THANK YOU----");
					break;
				
			}
			
		}
		
		sc.close();
	}
}
