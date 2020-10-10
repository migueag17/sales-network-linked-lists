package venta;

	public class ListaVendedor {
	NodoVendedor head;
	
		void insertar(Vendedor next){
			NodoVendedor nuevoNodo = new NodoVendedor();
			nuevoNodo.vendedor = next;
		
			//La lista está vacía
			if(head == null){
				head = nuevoNodo;
			}
			else { //La lista no está vacía
				NodoVendedor ultimo = head;
				while(ultimo.next != null) {
					ultimo = ultimo.next;			
				}
			
				ultimo.next = nuevoNodo;
		}
	}
}