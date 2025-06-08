package filas;
public class filaLista {
    private NoFila inicio;
    private NoFila fim;

    public filaLista() {}

    public void enqueue(Object elemento) {
        NoFila novoNo = new NoFila(elemento);

        if (fim == null) {
            inicio = fim = novoNo;
        } else {
            fim.setProx(novoNo);
            fim = novoNo;
        }
    }

    public Object dequeue() {
        if (inicio == null) {
            return null;
        }

        Object elemento = inicio.getElemento();
        inicio = inicio.getProx();

        if (inicio == null) {
            fim = null;
        }

        return elemento;
    }

    public boolean isEmpty() {
        return inicio == null;
    }
}