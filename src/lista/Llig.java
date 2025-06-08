// Llig.java - Lista encadeada de ligações
package lista;

public class Llig {
    private noLig inicio;
    private int tamanho;

    public Llig() {
        this.tamanho = 0;
    }

    public noLig getInicio() {
        return inicio;
    }

    public int getTamanho() {
        return tamanho;
    }

    // Inserir nova ligação na posição especificada
    public void inserirLig(int pos, noNarea info) {
        noLig novoNo = new noLig(info);

        if (pos == 0 || inicio == null) {
            novoNo.setProx(inicio);
            inicio = novoNo;
        } else {
            noLig atual = inicio;
            for (int i = 0; i < pos - 1 && atual.getProx() != null; i++) {
                atual = atual.getProx();
            }
            novoNo.setProx(atual.getProx());
            atual.setProx(novoNo);
        }
        tamanho++;
    }

    // Retornar o nó na posição especificada
    public noNarea retornaNoNarea(int pos) {
        if (pos >= tamanho || inicio == null) {
            return null;
        }

        noLig atual = inicio;
        for (int i = 0; i < pos && atual != null; i++) {
            atual = atual.getProx();
        }

        return atual != null ? atual.getInfo() : null;
    }

    // Retornar o primeiro nó da lista de ligações
    public noNarea retornaNoNarea() {
        return retornaNoNarea(0);
    }

    // Posicionar na posição especificada e retornar nova Llig
    public Llig posicionaL(int pos) {
        if (pos >= tamanho || inicio == null) {
            return null;
        }

        noLig atual = inicio;
        for (int i = 0; i < pos && atual != null; i++) {
            atual = atual.getProx();
        }

        if (atual != null) {
            Llig novaLista = new Llig();
            novaLista.inicio = atual;
            novaLista.tamanho = tamanho - pos;
            return novaLista;
        }

        return null;
    }

    // Garantir que sempre há pelo menos um nó na lista
    public void ajustar() {
        if (inicio == null) {
            inserirLig(0, new noNarea());
        }
    }

    // Método para percorrer todos os filhos
    public void percorrerFilhos(java.util.function.Consumer<noNarea> acao) {
        noLig atual = inicio;
        while (atual != null) {
            if (atual.getInfo() != null) {
                acao.accept(atual.getInfo());
            }
            atual = atual.getProx();
        }
    }
}