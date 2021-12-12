import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayerRepository implements IRepository{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pnu.cse");
    EntityManager em = emf.createEntityManager();
    public static final String SELECT_ALL_QUERY_STRING = "SELECT A.name, B FROM Club A, Player B WHERE A.name = 'PNU' AND A.id = B.club.id";

    @Override
    public void save(Player t) {
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(t.getClub());
            em.persist(t.getNationality());
            em.persist(t);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void deleteById(int id) {
        Optional<Player> entity = findById(id);
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(entity.get());
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public List<Player> findAll() {
        List resultList = em.createQuery(SELECT_ALL_QUERY_STRING).getResultList();
        List<Player> players = new ArrayList<>();
        for (Object o : resultList){
            Object[] result = (Object[]) o;
            players.add((Player) result[1]);
        }
        return players;
    }

    @Override
    public Optional<Player> findById(int id) {
        return Optional.ofNullable(em.find(Player.class, Long.valueOf(id)));
    }
}
