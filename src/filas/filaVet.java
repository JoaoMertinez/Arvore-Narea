package filas;

import vetor.No;

public class filaVet {
    private noFilavet inicio;
    private noFilavet fim;

    public filaVet() {
        inicio = fim = null;
    }

    public void enqueue(No info) {
        noFilavet novo = new noFilavet();
        novo.setInfo(info);

        if (this.isEmpty()) {
            inicio = fim = novo;
        } else {
            fim.setProx(novo);
            fim = novo;
        }
    }

    public No dequeue() {
        if (!this.isEmpty()) {
            No ret = inicio.getInfo();
            inicio = inicio.getProx();
            return ret;
        }
        return null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }
}
