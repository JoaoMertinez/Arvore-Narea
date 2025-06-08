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
            p = raiz;//p recebe o primeiro
            while (p!=null && !flag) //esse while vai andando nos nos da arvore
            {
                pos = p.buscarPos(info);
                if(p.getTL() < Definicoes.N-1)//quando ir para baixo vai dar certo
                {
                    p.remanejar(pos);//vai para o ultimo sempre
                    p.setvInfo(pos,info);
                    p.setTL(p.getTL()+1);
                    flag = true;
                    //System.out.printf(info+" inserido com sucesso! \n");
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

    public void inserirFixar(int info) {
        int pos = 0;
        No ant =null;

        if(raiz==null){
            raiz = new No(info);
        }
        else{
            No p  = raiz;
            boolean flag = false;
            while(!flag && p!=null)//tem sempre que ter o while porque o p sempre recebe o raiz, ou seja, se tem 1000 arvores para baixo, cada cada inserir vai comecar na raiz
            {
                pos = p.buscarPos(info);
                if(p.getTL() < N-1)// pois o vetor de registros tem n-1
                {
                    p.remanejar(pos);
                    p.setvInfo(pos,info);
                    p.setTL(p.getTL()+1);
                    flag = true;
                }
                else{
                    ant = p;//porque??
                    p = p.getvLig(pos);
                }
            }
            if (!flag){
                ant.setvLig(pos, new No(info));
            }
        }
    }

    public void excluir(int info) {
        if (raiz != null) {
            raiz = remover(raiz, info);
        }
    }

    public No remover(No p, int info) {
        if (p == null)
            return null;

        int pos = p.buscarPos(info);

        // achou
        if (pos < p.getTL()-1 && p.getvInfo(pos) == info) {

            // Caso simples: é folha
            if (p.getvLig(pos) == null && p.getvLig(pos + 1) == null) {
                p.remanejar(pos);
                p.setTL(p.getTL() - 1);
            } else {
                // Substituir pelo antecessor (maior da subárvore à esquerda)
                No aux = p.getvLig(pos);
                while (aux.getvLig(aux.getTL()) != null) {
                    aux = aux.getvLig(aux.getTL());
                }
                int antecessor = aux.getvInfo(aux.getTL() - 1);

                p.setvInfo(pos, antecessor); // substitui o valor original
                p.setvLig(pos, remover(p.getvLig(pos), antecessor)); // remove o antecessor da subárvore
            }
        } else {
            // Não encontrou, desce recursivamente
            No filho = p.getvLig(pos);
            if (filho != null)
                p.setvLig(pos, remover(filho, info));
            else
                System.out.println("Valor não encontrado.");
        }

        return p;
    }

    public void excluirFixar(No nodo, int info) {
        int pos = 0;
        No ant=null;
        pos = nodo.buscarPos(info);

        if(pos<nodo.getTL()-1)//achou
        {
            if(nodo.getvLig(pos)==null && nodo.getvInfo(pos)==info)//folha
            {
                //nodo.remanejar(pos);
                nodo.remanejarExclusao(pos);
                nodo.setTL(nodo.getTL()-1);
            }
            else//aponta para alguem
            {
                //excluirFixar(nodo.getvLig(pos), info);
                No aux = nodo.getvLig(pos);
                while(aux.getvLig(aux.getTL()-1)!=null)
                    aux = aux.getvLig(aux.getTL()-1);
            }
            //depois mecher
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
