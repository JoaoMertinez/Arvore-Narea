// noLig.java - Nó da lista de ligações
package lista;

public class noLig {
    private noNarea info;
    private noLig prox;

    public noLig() {}

    public noLig(noNarea info) {
        this.info = info;
    }

    public noNarea getInfo() {
        return info;
    }

    public void setInfo(noNarea info) {
        this.info = info;
    }

    public noLig getProx() {
        return prox;
    }

    public void setProx(noLig prox) {
        this.prox = prox;
    }
}