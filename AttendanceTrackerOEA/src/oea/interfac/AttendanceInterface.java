package oea.interfac;

public interface AttendanceInterface {
	
	void recordAttendance(int id);
	void createFile(String date);
	void checkAttendance(String date, int id);
	void storeInLinkedHashSet(String date);
	void retrieveAttendance(String date);
	void appendAttendance(String date, int id);
}
