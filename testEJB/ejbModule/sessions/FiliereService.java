package sessions;

import java.util.List;

import dao.IDao;
import dao.IDaoLocal;
import entities.Filiere;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * Session Bean implementation class FiliereService
 */
@Stateless(name="fs")
public class FiliereService implements IDao<Filiere> //, IDaoLocal<Filiere> 
{

	@PersistenceContext
	private EntityManager f;
	
    /**
     * Default constructor. 
     */
    public FiliereService() {
        // TODO Auto-generated constructor stub
    }


    @Override
	@PermitAll
	public Filiere create(Filiere o) {
    	f.persist(o);
        return o;
	}

    @Override
	@PermitAll
	public void delete(Filiere o) {
    	f.remove(o);
		
	}

    @Override
	@PermitAll
	public Filiere update(Filiere o) {
    	f.persist(o);
        return o;
	}

    @Override
	@PermitAll
	public Filiere findById(int id) {
    	 Filiere filiere = f.find(Filiere.class, id);
         if(filiere == null) throw new RuntimeException("Filiere introuvable");
         return filiere;
	}

    @Override
	@PermitAll
	public List<Filiere> findAll() {
    	  Query req= f.createQuery("select f from Filiere f");
          return req.getResultList();
	}

}
