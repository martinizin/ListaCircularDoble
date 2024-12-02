public class listaCircularDoble {
    Nodo cabeza = null;
    Nodo cola = null;

    // Método para insertar un elemento en la lista
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

    // Método para eliminar un elemento de la lista
    public void eliminar(int dato) {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo actual = cabeza;
        do {
            if (actual.dato == dato) {
                if (actual == cabeza && actual == cola) {  // Caso único (solo un nodo)
                    cabeza = cola = null;
                } else if (actual == cabeza) {  // Caso de eliminación en el inicio
                    cabeza = actual.siguiente;
                    cabeza.anterior = cola;
                    cola.siguiente = cabeza;
                } else if (actual == cola) {  // Caso de eliminación en el final
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

    // Función de búsqueda avanzada (por ejemplo, verificar si el valor está en la lista)
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

    // Algoritmo de ordenamiento táctico ascendente/descendente
    public void ordenar(boolean ascendente) {
        if (cabeza == null || cabeza.siguiente == cabeza) {
            return;  // Lista vacía o con un solo elemento
        }

        boolean intercambiado;
        do {
            intercambiado = false;
            Nodo actual = cabeza;
            do {
                if ((ascendente && actual.dato > actual.siguiente.dato) ||
                        (!ascendente && actual.dato < actual.siguiente.dato)) {
                    // Intercambiar los datos
                    int temp = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temp;
                    intercambiado = true;
                }
                actual = actual.siguiente;
            } while (actual != cabeza);
        } while (intercambiado);

        System.out.println("Lista ordenada " + (ascendente ? "ascendentemente" : "descendentemente"));
    }

    // Método para imprimir la lista (útil para visualizar)
    public void imprimirLista() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo actual = cabeza;
        do {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println();
    }
}
