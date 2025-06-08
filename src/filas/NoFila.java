// FilaLista.java - Fila implementada com lista encadeada para exibição por nível
package filas;

class NoFila {
    private Object elemento;
    private NoFila prox;

    public NoFila(Object elemento) {
        this.elemento = elemento;
    }

    public Object getElemento() {
        return elemento;
    }

    public NoFila getProx() {
        return prox;
    }

    public void setProx(NoFila prox) {
        this.prox = prox;
    }
}