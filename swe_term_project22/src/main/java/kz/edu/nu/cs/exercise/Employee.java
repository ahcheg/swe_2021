package kz.edu.nu.cs.exercise;

public class Employee {
	private int employeeID;
	private String name;
	private int type; // 0-Supervisor, 1-Administrator, 2-Cleaning Staff
	private int payroll;
	private int workDays;
	private int hotelID;
	
	Employee(Employee x) {
		this.employeeID = x.employeeID;
		this.name = x.name;
		this.type = x.type;
		this.payroll = x.payroll;
		this.workDays = x.workDays;
		this.hotelID = x.hotelID;
	}
	Employee(int ID, int type, int hotelID, int workDays, int payroll) {
		this.employeeID = ID;
		this.type = type;
		this.hotelID = hotelID;
		this.workDays = workDays;
		this.payroll = payroll;
	}
	
	Employee(int ID, String name, int type, int hotelID, int payroll) {
		this.employeeID = ID;
		this.name = name;
		this.type = type;
		this.hotelID = hotelID;
		this.payroll = payroll;
	}
	
	public void setPayroll(int payroll) {
		this.payroll = payroll;
	}
	public void setDays(int workHours) {
		this.workDays = workDays;
	}
	
}
