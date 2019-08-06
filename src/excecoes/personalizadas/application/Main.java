package excecoes.personalizadas.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JOptionPane;

import excecoes.personalizadas.Exceptions.DomainException;
import excecoes.personalizadas.entities.Reservation;

public class Main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.println("Room number: ");
			int roomNumber = sc.nextInt();

			System.out.println("check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());

			System.out.println("check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");

			System.out.println("check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());

			System.out.println("check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reservation.updateDates(checkIn, checkOut);
			System.out.println(reservation);
		} catch (ParseException e) {
			System.out.println("Invalid date format");
		}catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		
		
sc.close();	}

}