package lista;

public class Linfo {
    private noInfo inicio;
    private int tamanho;

    public Linfo() {
        this.tamanho = 0;
    }

    public noInfo getInicio() {
        return inicio;
    }

    public void setInicio(noInfo inicio) {
        this.inicio = inicio;
    }

    public int getTamanho() {
        return tamanho;
    }

    // Inserir elemento de forma ordenada
    public boolean inserir(int numero) {
        noInfo no = new noInfo(numero);

        // Lista vazia ou inserir no início
        if (inicio == null || numero < inicio.getElemento()) {
            no.setProx(inicio);
            inicio = no;
            tamanho++;
            return true;
        }

        // Procurar posição correta para inserir
        noInfo atual = inicio;
        while (atual.getProx() != null && atual.getProx().getElemento() < numero) {
            atual = atual.getProx();
        }

        // Verificar se elemento já existe
        if (atual.getProx() != null && atual.getProx().getElemento() == numero) {
            return false; // Elemento duplicado
        }

        no.setProx(atual.getProx());
        atual.setProx(no);
        tamanho++;
        return true;
    }

    // Buscar e retornar a quantidade de elementos
    public int buscar() {
        return tamanho;
    }

    // Remover elemento
    public boolean remover(int numero) {
        if (inicio == null) {
            return false;
        }

        // Remover do início
        if (inicio.getElemento() == numero) {
            inicio = inicio.getProx();
            tamanho--;
            return true;
        }

        // Procurar elemento para remover
        noInfo atual = inicio;
        while (atual.getProx() != null && atual.getProx().getElemento() != numero) {
            atual = atual.getProx();
        }

        if (atual.getProx() != null) {
            atual.setProx(atual.getProx().getProx());
            tamanho--;
            return true;
        }

        return false;
    }

    // Buscar elemento específico (-1 se não encontrar, posição se encontrar)
    public int buscarElemento(int numero) {
        noInfo atual = inicio;
        int pos = 0;

        while (atual != null) {
            if (atual.getElemento() == numero) {
                return pos;
            }
            atual = atual.getProx();
            pos++;
        }

        return -1;
    }
}