package excecoes.personalizadas.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import excecoes.personalizadas.Exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private StringBuilder sbd = new StringBuilder();
	private final Date now = new Date();
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut){
		
		if (!checkOut.after(checkIn)) {
			throw new DomainException(": CheckOut date must be after checkIn date");
		}
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() -checkIn.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	
	
	public void updateDates(Date checkIn, Date checkOut) {
		
		
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		}
		
		if (!checkOut.after(now)) {
			throw new DomainException("CheckOut date must be after checkIn date");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		
	}

	@Override
	public String toString() {
		sbd.append("Reservation: Room ");
		sbd.append(getRoomNumber());
		sbd.append(", check-in: " + sdf.format(getCheckIn()));
		sbd.append(", check-out: "+ sdf.format(getCheckOut()));
		sbd.append(", " + duration());
		sbd.append(" nights.");
		
		return sbd.toString() ;
	}
	
	

	
	
}
