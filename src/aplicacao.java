import vetor.nArea;

public class aplicacao {

    public static void main(String[] args) {
        nArea arv = new nArea();
        arv.inserir(100);
        arv.inserir(90);
        arv.inserir(20);
        arv.inserir(30);

        arv.Inordem(arv.getRaiz());
    }
}
