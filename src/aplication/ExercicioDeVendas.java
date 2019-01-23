package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entites.Cliente;
import entites.Order;
import entites.OrderItem;
import entites.Product;
import entites.enuns.PedidoStatus;

public class ExercicioDeVendas {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner s=new Scanner(System.in);
		SimpleDateFormat ani=new SimpleDateFormat("dd/mm/yyyy");
		SimpleDateFormat sum=new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
		
		System.out.println("Dados do cliente: ");
		System.out.print("Nome: ");
		String no=s.nextLine();
		System.out.print("Email: ");
		String em=s.nextLine();
		System.out.print("Data (DD/MM/YYYY): ");
		String da=s.next();
		Cliente c=new Cliente(no, em, ani.parse(da));
		
		System.out.println("Dados do pedido:");
		System.out.print("Status: ");
		String sta=s.next();
		Order or=new Order(new Date(), PedidoStatus.valueOf(sta));
		System.out.print("Quantidade de itens nesta ordem: ");
		int qnt=s.nextInt();
		int i;
		for(i=0;i<qnt;i++) {
			s.nextLine();
			System.out.printf("Dados do item #%d:\n ",i+1);
			System.out.print("Nome do produto: ");
			String np=s.nextLine();
			System.out.print("Quantidade: ");
			Integer q=s.nextInt();
			System.out.print("Preço: ");
			Double pr=s.nextDouble();
			OrderItem oi=new OrderItem(q, pr, new Product(np, pr));
			or.additem(oi);
		}
		System.out.println();
		
		System.out.println(or.toString());
		System.out.println(c.toString());
		or.leituraitens();
		System.out.printf("Total: $%.2f",or.total());
		s.close();
	}
}