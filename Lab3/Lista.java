import java.util.ArrayList;
import java.util.Collections;
class Lista { 
	private Nodo laCabeza;
	Lista() { 
		laCabeza = null;
	} 
	//---Inserta un objeto(int) al comienzo de la lista
	public void InsertaInicio(int o) {
		if (EstaVacia()) laCabeza=new Nodo(o, null);
		else  laCabeza = new Nodo(o, laCabeza);
	}
	//---- Inserta al final ----
	public void InsertaFinal(int o) {
		if (EstaVacia()) laCabeza=new Nodo(o, null);
		else{
			Nodo t;
			for(t = laCabeza; t.next != null; t= t.next) ;;
			t.next = new Nodo(o,null);
		}
	}
	// ---cuenta la cantidad de nodos de la lista (Size)
	public int Size() {
		int tnodos=0;
		for(Nodo t = laCabeza; t !=null; t= t.next) 
			tnodos++;
		return tnodos;
	}
	//eliminar un nodo de la lista 
	// Elimina el primer nodo n tal que o.elObjeto==o 
	public void Eliminar(int o) { 
		if(!EstaVacia()) { 
			if(laCabeza.elObjeto==o) laCabeza = laCabeza.next;
			else { 
				Nodo p = laCabeza;
				Nodo t = laCabeza.next; 
				while (t !=null && t.elObjeto != o)  { 
					p = t ; t = t.next;
				} 
				if(t.elObjeto==o) p.next = t.next;
			}
		}
	}
	// Verifica si la lista esta vacias;
	public boolean EstaVacia() {
		return laCabeza == null;
	}
  //Calcula el promedio
	public int promed() {
		int p=0;
		Nodo n = laCabeza;
		int cont =0;
		while (n!=null) {
			p+=n.elObjeto;
			n=n.next;
			cont++;
		}
		return p/cont;
	}
  //Obiene los numeros mayores al promedio y los almacena en una lista ordenados de mayor a menor
	public Lista getMayoresProm(int prom) {
		Lista may = new Lista();
		Nodo n = laCabeza;
		while (n!=null) {
			if(n.elObjeto>prom ) {
				may.InsertaFinal(n.elObjeto);
			}
			n=n.next;
		}
		return Ordenada(may);
	}
  //Ordeena los elementos de una lista de mayor a menor(Haciendo un poco de trampa)
	public Lista Ordenada(Lista a) {
		if(a.laCabeza==null){
			return null;
		}
		Lista ord = new Lista();
		ArrayList <Integer> aux = new ArrayList<>();
		Nodo n = a.laCabeza;
		while(n!=null) {
			aux.add(n.elObjeto);
			n = n.next;
		}
		Collections.sort(aux);
		ord.InsertaFinal(aux.get(0));
		int i = 1;
		n=ord.laCabeza;
		while(n!=null&&i< aux.size()) {
			ord.InsertaFinal(aux.get(i));
			n=n.next;
			i++;
		}
		return ord;
	}
	//-----Imprime la lista-----
	void Print() {
		if(laCabeza!=null) Imprimir(laCabeza);
		else System.out.println("Lista Vacia");
	}
	void Imprimir(Nodo m ) {
		if(m !=null) {m.Print(); Imprimir(m.next);}
	}
	//-----Clase Nodo--------- 
	public class Nodo { 
		public int elObjeto;
		public Nodo next;
		public Nodo(int nuevoObjeto, Nodo next)
		{this.elObjeto=nuevoObjeto; this.next = next;} 
		void Print(){ System.out.print("- " + elObjeto);}
	}
}
