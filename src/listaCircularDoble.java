public class listaCircularDoble {
    Nodo cabeza = null;
    Nodo cola = null;


    public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            nuevoNodo.siguiente = cabeza;
            nuevoNodo.anterior = cola;
        } else {
            nuevoNodo.siguiente = cabeza;
            nuevoNodo.anterior = cola;
            cola.siguiente = nuevoNodo;
            cabeza.anterior = nuevoNodo;
            cola = nuevoNodo;
        }
    }


    public void eliminar(int dato) {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo actual = cabeza;
        do {
            if (actual.dato == dato) {
                if (actual == cabeza && actual == cola) {
                    cabeza = cola = null;
                } else if (actual == cabeza) {
                    cabeza = actual.siguiente;
                    cabeza.anterior = cola;
                    cola.siguiente = cabeza;
                } else if (actual == cola) {
                    cola = actual.anterior;
                    cola.siguiente = cabeza;
                    cabeza.anterior = cola;
                } else {  // Caso de eliminación en medio
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                }
                System.out.println("Elemento " + dato + " eliminado.");
                return;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);

        System.out.println("Elemento no encontrado.");
    }


    public boolean buscar(int dato) {
        if (cabeza == null) {
            return false;
        }
        Nodo actual = cabeza;
        do {
            if (actual.dato == dato) {
                return true;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
        return false;
    }



    public void ordenar() { //Me guie con el metodo Insertion Sort de las diapositivas porque estaba teniendo problemas con el ordenamiento
            if (cabeza == null || cabeza.siguiente == cabeza) return;
            Nodo nodoOrdenado = cabeza.siguiente;

            while (nodoOrdenado != cabeza) {
                int key = nodoOrdenado.dato;
                Nodo temp = nodoOrdenado.anterior;

                while (temp != cabeza.anterior && temp.dato > key) {
                    temp.siguiente.dato = temp.dato;
                    temp = temp.anterior;
                }
                temp.siguiente.dato = key;
                nodoOrdenado = nodoOrdenado.siguiente;
            }
        }

    public listaCircularDoble copiarLista() {
        listaCircularDoble copia = new listaCircularDoble();
        if (cabeza != null) {
            Nodo actual = cabeza;
            do {
                copia.insertar(actual.dato);
                actual = actual.siguiente;
            } while (actual != cabeza);
        }
        return copia;
    }


    public String imprimirLista() {
        if (cabeza == null) {
            return "La lista está vacía.";
        }

        StringBuilder sb = new StringBuilder();
        Nodo actual = cabeza;
        do {
            sb.append(actual.dato).append(" ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        return sb.toString();
    }
}
