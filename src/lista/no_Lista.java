package lista;

public class no_Lista {
    private no_L dados;          // Lista encadeada de inteiros (30 -> 40)
    private no_Lista filhos;     // Ponteiro para os filhos
    private no_Lista prox;       // Ponteiro para os irmãos

    public no_Lista() {
        dados = null;
        filhos = null;
        prox = null;
    }

    public no_Lista(no_L dados) {
        this();
        this.dados = dados;
    }

    public no_L getDados() { return dados; }
    public void setDados(no_L dados) { this.dados = dados; }

    public no_Lista getFilhos() { return filhos; }
    public void setFilhos(no_Lista filhos) { this.filhos = filhos; }

    public no_Lista getProx() { return prox; }
    public void setProx(no_Lista prox) { this.prox = prox; }
}

