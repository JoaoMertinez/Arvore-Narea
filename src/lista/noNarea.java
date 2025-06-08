// noNarea.java - Nó da árvore N-área
package lista;

public class noNarea {
    private Linfo info;
    private Llig lig;

    public noNarea() {
        info = new Linfo();
        lig = new Llig();
    }

    public Linfo getInfo() {
        return info;
    }

    public void setInfo(Linfo info) {
        this.info = info;
    }

    public Llig getLig() {
        return lig;
    }

    public void setLig(Llig lig) {
        this.lig = lig;
    }
}