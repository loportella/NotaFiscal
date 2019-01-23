package entites;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entites.enuns.PedidoStatus;

public class Order {
	private SimpleDateFormat sum=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	private Date data;
	private PedidoStatus status;
	private List<OrderItem> item=new ArrayList<>();
	
	public Order() {
	}

	public Order(Date data, PedidoStatus status) {
		this.data = data;
		this.status = status;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public PedidoStatus getStatus() {
		return status;
	}

	public void setStatus(PedidoStatus status) {
		this.status = status;
	}
	public void additem(OrderItem oi) {
		item.add(oi);
	}
	public void removeitem(OrderItem oi) {
		item.add(oi);
	}

	public void leituraitens() {
		System.out.println("Itens do pedido: ");
		for(OrderItem oi : item) {
			System.out.println(oi.toString());
		}
	}
	public Double total() {
		Double soma=0.0;
		for(OrderItem i:item) {
			soma+=i.subTotal();
		}return soma;
	}
	@Override
	public String toString() {
		return "iNFORMAÇÕES DO PEDIDO: \n"+"Momento do pedido:"+
	sum.format(data)+"\n"+"Status do pedido: "+status;
	}
	
}
