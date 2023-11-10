package sessions;

import dao.IDao;
import dao.IDaoLocal;
import entities.Role;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Singleton;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

/**
 * Session Bean implementation class RoleService
 */
@Singleton (name="rs")
public class RoleService implements IDao<Role> , IDaoLocal<Role> {

    
	@PersistenceContext
	private EntityManager r;
	
	public RoleService() {}
	
	@Override
	@PermitAll
    public void delete(Role o) {
        r.remove(o);
    }

	@Override
	@PermitAll
    public List<Role> findAll() {
        Query req= r.createQuery("select r from Role r");
        return req.getResultList();
    }

	@Override
	@PermitAll
    public Role create(Role o) {
        r.persist(o);
        return o;
    }

	@Override
	@PermitAll
    public Role update(Role o) {
		r.persist(o);
        return o;
    }
	
	@Override
	@PermitAll
    public Role findById(int id) {
        Role role = r.find(Role.class, id);
        if(role == null) throw new RuntimeException("Role introuvable");
        return role;
    }

}
