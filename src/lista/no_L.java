package lista;
import vetor.nArea;

public class no_L {
    private int info;
    private no_L prox;

    public no_L(int info) {
        this.info = info;
        prox = null;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public no_L getProx() {
        return prox;
    }

    public void setProx(no_L prox) {
        this.prox = prox;
    }
}
