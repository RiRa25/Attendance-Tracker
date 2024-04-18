package oea.interfac;

public interface AttendanceInterface {
	
	void values();
	void printEmployees();
	void addEmployee(int id, String name);
	void recordAttendance(int id);
	void createFile(String date);
	void checkAttendance(String date, int id);
	void storeInLinkedHashSet(String date);
	void retrieveAttendance(String date);
	void appendAttendance(String date, int id);
}
