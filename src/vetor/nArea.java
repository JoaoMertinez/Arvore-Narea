package vetor;
import interfaces.Definicoes;

public class nArea implements Definicoes {
    private No raiz;

    public nArea() {
        raiz = null;//nao precisa disso, mas e bom colocar para visualizarmos
    }

    public No getRaiz() {
        return raiz;
    }

    public void inserir(int info) {
        No p, ant=null;
        boolean flag = false;
        int pos = 0;

        if (raiz == null) {
            raiz = new No(info);
        }
        else {
            p = raiz;
            while (p!=null && !flag) {
                pos = p.buscarPos(info);
                if(p.getTL() < Definicoes.N-1)//quando ir para baixo vai dar certo
                {
                    p.remanejar(pos);
                    p.setvInfo(pos,info);
                    p.setTL(p.getTL()+1);
                    flag = true;
                }
                else{
                    ant = p;
                    p = p.getvLig(pos);//vai para o vetor.No que tem que apontar
                }
            }
            if (!flag)
                ant.setvLig(pos, new No(info));
        }
    }

    public void Inordem(No raiz) {
        if (raiz != null) {
            for (int i = 0; i < raiz.getTL() ; i++) {
                Inordem(raiz.getvLig(i));
                System.out.println(raiz.getvInfo(i));
            }
            Inordem(raiz.getvLig(raiz.getTL()-1));
        }
    }
}
