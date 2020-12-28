package enumabstract;

public interface Deletable {

    // Az OrderState enum NEW, CONFIRMED és PREPARED értékei esetén igazat, minden más esetben hamisat kell visszaadjon.
    boolean canDelete();
}
