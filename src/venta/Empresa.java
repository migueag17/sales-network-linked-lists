package venta;

public class Empresa {
	String nombre;
	float porcentajeDescuento;
	float comisionxPorcentaje;
	float valorInicial;
	ListaVendedor listaVendedores;
	
	public Empresa(String nombreEmpresa, float descuento, float comision, float valorInicialMiembro) {
		nombre = nombreEmpresa;
		porcentajeDescuento = descuento;
		comisionxPorcentaje = comision;
		valorInicial = valorInicialMiembro;
		listaVendedores = new ListaVendedor();
	}
	
	void agregarVendedor(Vendedor vendedor) {
		listaVendedores.insertar(vendedor);
	}
	
	float balanceVendedor(Vendedor vendedor) {
		
		float balanceTotal = valorInicial - ((valorInicial*porcentajeDescuento) / 100);
		
		float balance = balanceTotal;

		
		Vendedor tmpIzq = vendedor.izquierdo;
		if(tmpIzq != null) {
			float comisionIzq = 0;
			while(tmpIzq.izquierdo != null) {
				comisionIzq += (balanceTotal*comisionxPorcentaje) / 100;
				tmpIzq = tmpIzq.izquierdo;
			}
			float tmpBalance = balanceTotal + comisionIzq;
			balance += (tmpBalance*25)/100;		
		}
		
		Vendedor tmpDer = vendedor.derecho;
		if(tmpDer != null) {
			float comisionDer = 0;
			while(tmpDer.derecho != null) {
				comisionDer += (balanceTotal*comisionxPorcentaje) / 100;
				tmpDer = tmpDer.derecho;
			}
			float tmpBalanceDer = balanceTotal + comisionDer;
			
			balance += (tmpBalanceDer*25)/100;		
		}
		
		return balance;	
	}
	
	void totalBalance(Vendedor vendedor) {
		
		float balance = balanceVendedor(vendedor);	
		Vendedor tmpDer = vendedor.derecho;
		float balanceDer = 0;
		while(tmpDer != null) {
			balanceDer += balanceVendedor(tmpDer);
			tmpDer = tmpDer.derecho;	
		}
		
		Vendedor tmpIzq = vendedor.izquierdo;
		float balanceIzq = 0;
		while(tmpIzq != null) {
			balanceIzq += balanceVendedor(tmpIzq);
			
			tmpIzq = tmpIzq.izquierdo;
		}
		float total = balance + balanceDer + balanceIzq;
		
		System.out.println("Balance total de la empresa: " + total);
		
	}
	
	float mayorBalance(Vendedor vendedor) {
		
		float balance = balanceVendedor(vendedor);
		
		Vendedor tmpDer = vendedor.derecho;
		
		float balanceDer = 0;
		float tmp = balance;
		while(tmpDer != null) {
			float balancetmp = balanceVendedor(tmpDer);
			
			if(balancetmp > tmp ) {
				
				tmp = balancetmp;
			}
			tmpDer = tmpDer.derecho;
			
		}
		
		Vendedor tmpIzq = vendedor.izquierdo;

		while(tmpIzq != null) {
			float balanceIzq = balanceVendedor(tmpIzq);
			if(balanceIzq > tmp ) {
				
				tmp = balanceIzq;
			}
			tmpIzq = tmpIzq.izquierdo;
			
		}

		
		return tmp;
		
	}
	
	float menorBalance(Vendedor vendedor) {
		
		float balance = balanceVendedor(vendedor);
		
		Vendedor tmpDer = vendedor.derecho;

		float tmp = balance;
		while(tmpDer != null) {
			float balancetmp = balanceVendedor(tmpDer);
			
			if(balancetmp < tmp ) {
				
				tmp = balancetmp;
			}
			tmpDer = tmpDer.derecho;
			
		}
		
		Vendedor tmpIzq = vendedor.izquierdo;

		while(tmpIzq != null) {
			float balanceIzq = balanceVendedor(tmpIzq);
			if(balanceIzq > tmp ) {
				
				tmp = balanceIzq;
			}
			tmpIzq = tmpIzq.izquierdo;
			
		}

		return tmp;
		
	}
	
	void recorrerBalancesMayores() {
		NodoVendedor tmp = listaVendedores.head;
		
		float mayor = 0;
		while(tmp != null) {
			float balanceTmp = mayorBalance(tmp.vendedor);
			if(balanceTmp > mayor) {
				mayor = balanceTmp;
				
			}
			
			tmp = tmp.next;
		}
		
		System.out.println("Balance mayor: " + mayor);
	}
	
	void recorrerBalancesMenores() {
		NodoVendedor tmp = listaVendedores.head;
		
		float menor = menorBalance(tmp.vendedor);
		while(tmp != null) {
			float balanceTmp = menorBalance(tmp.vendedor);
			if(balanceTmp < menor) {
				menor = balanceTmp;
				
			}
			
			tmp = tmp.next;
		}
		
		System.out.println("Balance menor: " + menor);
	}
}
