package vetor;
import interfaces.Definicoes;

public class No implements Definicoes
{
    private int vInfo[];
    private No vLig[];
    private int TL;

    public No() {
        vInfo = new int[N-1];
        vLig = new No[N];
        TL = 0;
    }

    public No(int info) {
        this();
        //nao precisa colocar vlig nulo pois o java ja faz sozinho
        vInfo[TL] = info;
        TL = 1;
    }

    public int getvInfo(int p) {
        return vInfo[p];
    }

    public void setvInfo(int p, int info) {
        vInfo[p] = info;
    }

    public No getvLig(int p) {
        return vLig[p];
    }

    public void setvLig(int p,No info) {
        vLig[p] = info;
    }

    public int getTL() {
        return TL;
    }

    public void setTL(int TL) {
        this.TL = TL;
    }

    public int buscarPos(int info) {
        int pos = 0;
        while(pos < TL && vInfo[pos] < info)
            pos++;
        return pos;
    }

    public void remanejar(int pos) {
        for (int i = TL; i>pos ; i--) //e assim que voce controla se vai ou nao remanejar
        {
            vInfo[i] = vInfo[i-1];
        }
    }
}
