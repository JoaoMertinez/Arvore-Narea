import vetor.nArea;

public class aplicacao {

    public static void main(String[] args) {
        nArea arv = new nArea();
        arv.inserir(100);
        arv.inserir(90);
        arv.inserir(20);
        arv.inserir(30);
        arv.inserir(40);

        System.out.println("antes da exclusao do 40");
        arv.Inordem(arv.getRaiz());
        System.out.println("depois da exclusao do 40");
        arv.excluir(40);
        arv.Inordem(arv.getRaiz());

    }
}
