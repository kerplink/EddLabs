//============================
//Nodo árbol/cola binomial
//Alumno: Fernando Chandia Molina
//============================
class NodoCB {
	NodoCB p; // El padre
	NodoCB sibling; // el hermano
	NodoCB child;  // el hijo
	Integer key;  // la clave
	Short  degree; // el grado.
	//============================
	//Constructor 
	//============================
	NodoCB(NodoCB p, NodoCB sibling,
			NodoCB child, Integer key,
			Short degree){
		this.p=p; this.sibling=sibling;
		this.child = child; this.key = key;
		this.degree = degree;
	}
	//===============================
	//Une dos binomiales árboles B_k 
	//===============================
	void  BinomialLink(NodoCB z){
		p =z;
		sibling = z.child;
		z.child= this;
		z.degree++;
	}

	//================================== 
	//Imprime un árbol binomial
	//==================================
	void Print(){
		System.out.println("\\pstree[levelsep=25pt]{\\Tcircle{"+key+"}}"); // La salida es códgio latex
		System.out.println("{"); // Salida código latex
		for(NodoCB l = child; l!=null; l = l.sibling) 
			l.Print(); //impresión recursiva de los hijos del nodo 
		System.out.println("}");// Salida código latex

	}
}
