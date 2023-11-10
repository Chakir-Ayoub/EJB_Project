import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.IDao;
import entities.Filiere;
import entities.Role;
import entities.Student;
import entities.User;




public class TestMain {

	public static <T> IDao<T> lookupRemote(String jndiName) throws NamingException{
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (IDao<T>) context.lookup(jndiName);
		
	}
	
	
	
	public static void main(String[] args) {
		//Create Roles
		try {
			IDao<Role> dao = lookupRemote("ejb:EARtest/testEJB/rs!dao.IDao");
			Role r = new Role();
			r.setName("Role1");
			dao.create(r);
			r.setName("Role2");
			dao.create(r);
			for(Role us : dao.findAll()) {
				System.out.println(us.getName());
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		////Create Filieres
		//try {
		//IDao<Filiere> dao = lookupRemote("ejb:EARtest/testEJB/fs!dao.IDao");
		//Filiere f = new Filiere();
		//f.setCode("F1");
		//f.setName("Filiere1");
		//dao.create(f);
		//f.setCode("F2");
		//f.setName("Filiere2");
		//dao.create(f);
		//for(Filiere fs : dao.findAll()) {
		//	System.out.println(fs.getName());
		//}
		//} catch (NamingException e) {
		//	// TODO Auto-generated catch block
		//e.printStackTrace();
		//}
		
		////Create Students
		//try {
			
		//IDao<Student> dao = lookupRemote("ejb:EARtest/testEJB/ss!dao.IDao");
		//IDao<Filiere> daof = lookupRemote("ejb:EARtest/testEJB/fs!dao.IDao");
		//IDao<Role> daor = lookupRemote("ejb:EARtest/testEJB/rs!dao.IDao");
		//Student s = new Student();
		//s.setFirstname("ilhame");
		//s.setLastname("lamdibih");
		//s.setLogin("ily01");
		//s.setPassword("1234");
		//s.setFiliere(daof.findById(1));
		//s.setRoles((List<Role>) daor.findById(1));
		
		//dao.create(s);
			
		//for(Student ss : dao.findAll()) {
		//	System.out.println(ss.getLastname());
		//}
			
		//} catch (NamingException e) {
		//// TODO Auto-generated catch block
		//e.printStackTrace();
		//}
}
	}