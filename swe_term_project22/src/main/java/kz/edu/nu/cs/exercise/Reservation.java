package kz.edu.nu.cs.exercise;

public class Reservation {
	public String guestEmail;
	public int guestID;
	public int hotelID;
	public int roomNumber;
	public int floorNumber;
	public int billPrice;
	public boolean cleanedRoom;
	public String checkInDate;
	public String checkOutDate;
	public int requestType = 0;
	public String changeInDate;
	public String changeOutDate;
	
	Reservation(String guestEmail, int guestID, int hotelID, int roomNumber, int floorNumber, String checkInDate, String checkOutDate) {
		this.guestEmail = guestEmail;
		this.guestID = guestID;
		this.hotelID = hotelID;
		this.roomNumber = roomNumber;
		this.floorNumber = floorNumber;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}
	
	public void setRequestType(int requestType) {
		this.requestType = requestType;
	}
	
	public void setChange(String changeInDate, String changeOutDate) {
		this.checkInDate = changeInDate;
		this.changeOutDate = changeOutDate;
	}
	
}
