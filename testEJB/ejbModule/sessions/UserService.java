package sessions;

import java.util.List;

import dao.IDao;
import dao.IDaoLocal;
import entities.User;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * Session Bean implementation class UserService
 */
@Stateless(name="us")
public class UserService implements IDao<User> //, IDaoLocal<User> 
{

	@PersistenceContext
	private EntityManager u;
	
    /**
     * Default constructor. 
     */
    public UserService() {
        // TODO Auto-generated constructor stub
    }

    @Override
	@PermitAll
    public void delete(User o) {
        u.remove(o);
    }

	@Override
	@PermitAll
    public List<User> findAll() {
        Query req= u.createQuery("select u from User u");
        return req.getResultList();
    }

	@Override
	@PermitAll
    public User create(User o) {
        u.persist(o);
        return o;
    }

	@Override
	@PermitAll
    public User update(User o) {
		u.persist(o);
        return o;
    }
	
	@Override
	@PermitAll
    public User findById(int id) {
		User user = u.find(User.class, id);
        if(user == null) throw new RuntimeException("Utilisateur introuvable");
        return user;
    }

}
