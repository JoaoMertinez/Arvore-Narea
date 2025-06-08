import lista.Narea;
import vetor.nArea;

public class aplicacao {

    public static void main(String[] args) {
        nArea arv = new nArea();
//        arv.inserir(100);
//        arv.inserir(90);
//        arv.inserir(20);
//        arv.inserir(30);
//        arv.inserir(40);
//        arv.inserir(50);
//        arv.inserir(60);
//        arv.inserir(542);
//        arv.inserir(22);
//        arv.inserir(1);

        Narea arvore = new Narea();

        // Teste de inserção conforme o exemplo do PDF
        System.out.println("=== Teste de Inserção ===");
        arvore.inserir(30);
        arvore.inserir(40);
        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(35);
        arvore.inserir(38);
        arvore.inserir(45);

        System.out.println("\n=== Resultado da Árvore ===");
        arvore.imprimirLista();

        System.out.println("\n=== Exibição por Nível ===");
        arvore.exibirPorNivel();

        System.out.println("\n=== Teste de Busca ===");
        System.out.println("Buscar 35: " + arvore.buscar(35));
        System.out.println("Buscar 50: " + arvore.buscar(50));

    }
}
