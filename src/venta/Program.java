package venta;

public class Program {

	public static void main(String[] args) {
		Empresa empresa = new Empresa("Empresa Miguel", 10, 25, 1000);
		
		ListaVendedor listaVendedores = new ListaVendedor();
		Vendedor vendedor1 = new Vendedor("Maria");
		empresa.agregarVendedor(vendedor1);
		
		// hijos de Maria
		Vendedor mariaIzq = new Vendedor("Luis");
		vendedor1.izquierdo = mariaIzq;
		Vendedor mariaDer= new Vendedor("Pedro");
		vendedor1.derecho = mariaDer;
		
		// hijos de Luis
		Vendedor luisIzq = new Vendedor("Pepito");
		vendedor1.izquierdo.izquierdo = luisIzq;
		Vendedor luisDer= new Vendedor("Juan");
		vendedor1.izquierdo.derecho = luisDer;
		
		// hijos de Pedro
		Vendedor pedroIzq = new Vendedor("James");
		vendedor1.derecho.izquierdo = pedroIzq;
		Vendedor pedroDer= new Vendedor("Falcao");
		vendedor1.derecho.derecho = pedroDer;
		
		// hijo de Pepito
		Vendedor pepitoIzq = new Vendedor("Luisa");
		vendedor1.izquierdo.izquierdo.izquierdo = pepitoIzq;
		
		// hijo de Juan
		Vendedor juanDer = new Vendedor("Sofía");
		vendedor1.izquierdo.derecho.derecho = juanDer;
		
		// hijo de James
		Vendedor jamesIzq = new Vendedor("Raul");
		vendedor1.derecho.izquierdo.izquierdo = jamesIzq;
				
		// hijo de Falcao
		Vendedor falcaoDer = new Vendedor("Dayro");
		vendedor1.izquierdo.derecho.derecho = falcaoDer;
		
		
		System.out.println(vendedor1.nombre + " balance: " + empresa.balanceVendedor(vendedor1));
		empresa.totalBalance(vendedor1);
		empresa.recorrerBalancesMayores();
		empresa.recorrerBalancesMenores();
	}
}
