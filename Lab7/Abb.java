/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carola
 */
public class Abb {
    class NodoAbb {
        int elemento;
        NodoAbb lchild;
        NodoAbb rchild;
        NodoAbb(int elemento, NodoAbb lchild, NodoAbb rchild) {
            this.elemento = elemento;
            this.lchild = lchild;
            this.rchild = rchild;
        }

        void Print() {
            System.out.println(elemento);
        }
    }

    private NodoAbb laRaiz;

    public Abb() {
        laRaiz = null;
    }

    /* Verifica si existen dos enteros a, b en el ABB tal que a+b =0.
     */
    public boolean Complemento() {
        return comple(laRaiz);
    }
    boolean p,q;
    private boolean comple(NodoAbb n) {
        if(laRaiz==null){
            return false;
        }
        if (buscar(-n.elemento)) return true;
        if(n.elemento<n.rchild.elemento){
            if(n.lchild!=null) p= buscar(-n.lchild.elemento);
        }else{
            if(n.rchild!=null) q= buscar(-n.rchild.elemento);
        }
        return p||q;
    }
    public boolean buscar(int x){
        return buscar(laRaiz,x);
    }
    public boolean buscar(NodoAbb a, int x){
        if(laRaiz==null){
            return false;
        }
        if (a.elemento == x) return true;
        if (x < a.elemento && a.lchild != null) return(buscar(a.lchild, x));
        if (x > a.elemento && a.rchild != null) return(buscar(a.rchild, x));
        return false;
    }
    //--- Supone que no existe un nodo con valor = elemento----//
    public void Insertar(int elemento) {
        laRaiz = InsertaenAbb(laRaiz, elemento);
    }

    private NodoAbb InsertaenAbb(NodoAbb nodo, int elemento) {
        if (nodo == null)
            return new NodoAbb(elemento, null, null);
        else if (elemento < nodo.elemento)
            nodo.lchild = InsertaenAbb(nodo.lchild, elemento);
        else
            nodo.rchild = InsertaenAbb(nodo.rchild, elemento);
        return nodo;
    }

    // -- Supone que el elemento esta en el arbol----//
    public void Eliminar(int elemento) {
        laRaiz = EliminaenAbb(laRaiz, elemento);
    }

    private NodoAbb EliminaenAbb(NodoAbb nodo, int elemento) {
        if (nodo.elemento == elemento) {
            if (nodo.lchild == null && nodo.rchild == null)
                return null;
            else if (nodo.lchild == null)
                return nodo.rchild;
            else if (nodo.rchild == null)
                return nodo.lchild;
            else {
                nodo.elemento = MayorElemento(nodo.lchild);
                nodo.lchild = EliminaenAbb(nodo.lchild, nodo.elemento);
            }
        } else if (nodo.elemento > elemento)
            nodo.lchild = EliminaenAbb(nodo.lchild, elemento);
        else
            nodo.rchild = EliminaenAbb(nodo.rchild, elemento);
        return nodo;
    }

    private int MayorElemento(NodoAbb nodo) {
        if (nodo.rchild == null)
            return nodo.elemento;
        else
            return MayorElemento(nodo.rchild);
    }

    public void Imprimir() {
        ImprimeAbb(laRaiz, " ");
    }

    private void ImprimeAbb(NodoAbb n, String tab) {
        if (n != null) {
            System.out.println(tab + n.elemento);
            ImprimeAbb(n.lchild, tab + "  ");
            ImprimeAbb(n.rchild, tab + "  ");
        }
    }
}
