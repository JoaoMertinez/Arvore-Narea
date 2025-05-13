import vetor.nArea;

public class aplicacao {

    public static void main(String[] args) {
        nArea arv = new nArea();
        arv.inserir(100);
        arv.inserir(90);
        arv.inserir(20);
        arv.inserir(30);
        arv.inserir(40);
        arv.inserir(50);
        arv.inserir(60);
        arv.inserir(542);
        arv.inserir(22);
        arv.inserir(1);

        System.out.println("antes da exclusao do 542");
        arv.Inordem(arv.getRaiz());
        System.out.println("depois da exclusao do 542");
        arv.excluir(542);
        arv.Inordem(arv.getRaiz());

    }
}
