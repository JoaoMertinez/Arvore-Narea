// Narea.java - Classe principal da árvore N-área
package lista;
import filas.filaLista;
import interfaces.Definicoes;

public class Narea implements Definicoes {
    private noNarea raiz;

    public Narea() {}

    public noNarea getRaiz() {
        return raiz;
    }

    public void inserir(int info) {
        if (raiz == null) {
            // Criar primeiro nó da árvore
            raiz = new noNarea();
            raiz.getInfo().inserir(info);
            System.out.println("Elemento " + info + " inserido na raiz");
        } else {
            inserirRecursivo(raiz, info);
        }
    }

    private void inserirRecursivo(noNarea no, int info) {
        int tamanhoAtual = no.getInfo().buscar();

        if (tamanhoAtual < N) {
            // Há espaço no nó atual
            no.getInfo().inserir(info);
            System.out.println("Elemento " + info + " inserido (tamanho atual: " + (tamanhoAtual + 1) + ")");
        } else {
            // Nó está cheio, precisa criar filhos
            // Determinar em qual posição inserir baseado no valor
            int posicaoFilho = determinarPosicaoFilho(no, info);

            // Verificar se já existe filho na posição
            noNarea filho = no.getLig().retornaNoNarea(posicaoFilho);

            if (filho == null) {
                // Criar novo filho
                noNarea novoFilho = new noNarea();
                novoFilho.getInfo().inserir(info);
                no.getLig().inserirLig(posicaoFilho, novoFilho);
                System.out.println("Elemento " + info + " inserido em novo filho na posição " + posicaoFilho);
            } else {
                // Inserir no filho existente
                inserirRecursivo(filho, info);
            }
        }
    }

    private int determinarPosicaoFilho(noNarea no, int info) {
        noInfo atual = no.getInfo().getInicio();
        int posicao = 0;

        while (atual != null && info > atual.getElemento()) {
            posicao++;
            atual = atual.getProx();
        }

        return posicao;
    }

    public void imprimirLista() {
        System.out.println("=== Exibição da Árvore N-área ===");
        exibirLista(raiz, 0);
    }

    private void exibirLista(noNarea p, int nivel) {
        if (p != null) {
            // Indentação baseada no nível
            for (int i = 0; i < nivel; i++) {
                System.out.print("  ");
            }

            System.out.print("Nível " + nivel + ": ");
            noInfo info = p.getInfo().getInicio();
            while (info != null) {
                System.out.print(info.getElemento() + " ");
                info = info.getProx();
            }
            System.out.println();

            // Percorrer todos os filhos
            noLig ligacao = p.getLig().getInicio();
            while (ligacao != null) {
                if (ligacao.getInfo() != null) {
                    exibirLista(ligacao.getInfo(), nivel + 1);
                }
                ligacao = ligacao.getProx();
            }
        }
    }

    public void exibirPorNivel() {
        if (raiz == null) {
            System.out.println("Árvore vazia");
            return;
        }

        System.out.println("=== Exibição por Nível ===");
        filaLista fila = new filaLista();
        fila.enqueue(raiz);
        fila.enqueue(null); // Marcador de fim de nível
        int nivel = 0;

        while (!fila.isEmpty()) {
            noNarea atual = (noNarea) fila.dequeue();

            if (atual == null) {
                // Fim do nível atual
                if (!fila.isEmpty()) {
                    nivel++;
                    fila.enqueue(null); // Marcador para próximo nível
                }
            } else {
                System.out.print("Nível " + nivel + ": ");
                noInfo info = atual.getInfo().getInicio();
                while (info != null) {
                    System.out.print(info.getElemento() + " ");
                    info = info.getProx();
                }
                System.out.println();

                // Adicionar todos os filhos na fila
                noLig ligacao = atual.getLig().getInicio();
                while (ligacao != null) {
                    if (ligacao.getInfo() != null) {
                        fila.enqueue(ligacao.getInfo());
                    }
                    ligacao = ligacao.getProx();
                }
            }
        }
    }

    public boolean buscar(int info) {
        return buscarRecursivo(raiz, info);
    }

    private boolean buscarRecursivo(noNarea no, int info) {
        if (no == null) {
            return false;
        }

        if (no.getInfo().buscarElemento(info) != -1) {
            return true;
        }

        // Buscar em todos os filhos
        noLig ligacao = no.getLig().getInicio();
        while (ligacao != null) {
            if (ligacao.getInfo() != null && buscarRecursivo(ligacao.getInfo(), info)) {
                return true;
            }
            ligacao = ligacao.getProx();
        }

        return false;
    }
}