import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class JpaRepository<T, ID> {
    private final Class<T> domainType;
    private final EntityManager em;
    public static final String
            SELECT_ALL_QUERY_STRING = "select x from %s x";

    public JpaRepository(Class<T> domainType,
                         EntityManager entityManager) {
        this.domainType = domainType;
        this.em = entityManager;
    }

    public T save(T entity) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entity);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        }
        return entity;
    }

    private String getSelectAllQueryString() {
        return String.format(SELECT_ALL_QUERY_STRING,
                domainType.getSimpleName());
    }
}
