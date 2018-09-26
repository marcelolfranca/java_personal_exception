import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		System.out.println("Numero do quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.println("Check-in (dd/mm/aaaa): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-out (dd/mm/aaaa): ");
		Date checkOut = sdf.parse(sc.next());
		
	//verificando se as datas são compatíveis
	 
		Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
		System.out.println("Reserva: " + reserva);
		
		System.out.println();
		System.out.println("Entre com as datas para atualizar a sua reserva: ");
		System.out.println("Check-in (dd/mm/aaaa): ");
		checkIn = sdf.parse(sc.next());
		System.out.println("Check-out (dd/mm/aaaa): ");
		checkOut = sdf.parse(sc.next());
		
		reserva.updateDates(checkIn, checkOut);
		
		System.out.println(reserva); //concatena com o erro da função
		} catch (ParseException e) {
			System.out.println("Data inválida");	
		} catch (DomainException e) {
			System.out.println("Erro na reserva " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
	
	sc.close();

	}
}
