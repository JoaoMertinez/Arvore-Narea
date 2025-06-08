package lista;

public class noInfo {
    private int elemento;
    private noInfo prox;

    public noInfo() {}

    public noInfo(int elemento) {
        this.elemento = elemento;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public noInfo getProx() {
        return prox;
    }

    public void setProx(noInfo prox) {
        this.prox = prox;
    }
}