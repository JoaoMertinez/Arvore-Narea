package lista;
import interfaces.Definicoes;
import vetor.nArea;

public class nArea_lista implements Definicoes {
    private no_Lista raiz;

    public nArea_lista(no_Lista raiz) {raiz = null;}
    public no_Lista getRaiz() { return raiz; }

    public void inserirLista(int valor){
        no_L info = new no_L(valor);

        if(raiz==null){
            raiz = new no_Lista(info);
        }
        else{

        }

    }


}
