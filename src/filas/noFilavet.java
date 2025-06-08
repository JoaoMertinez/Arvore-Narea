package filas;
import vetor.No;

public class noFilavet {
    private No info;
    private noFilavet prox;

    public noFilavet() {
        this.info = null;
        this.prox = null;
    }

    public No getInfo() {
        return info;
    }

    public void setInfo(No info) {
        this.info = info;
    }

    public noFilavet getProx() {
        return prox;
    }

    public void setProx(noFilavet prox) {
        this.prox = prox;
    }
}
