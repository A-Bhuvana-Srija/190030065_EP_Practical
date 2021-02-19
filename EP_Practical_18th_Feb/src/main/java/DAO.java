import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DAO 
{
	public static void main(String args[]) 
	{
		StandardServiceRegistry ssr = (StandardServiceRegistry) new StandardServiceRegistryBuilder().configure("/hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		// BY NOW, WE BROUGHT THE DATABASE CONFIG FROM THE hibernate.config.xml FILE
		
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		// BY NOW, WE BROUGHT THE <session-factory> DETAILS FROM hibernate.config.xml FILE
		
		Session session = factory.openSession();
		// BY NOW, WE ARE ACTIVATING A NEW SESSION
		
		Transaction t = session.beginTransaction();
		// BY NOW, WE HAVE CREATED A TRANSACTION
		
		// NOW, EITHER USE save() or get()
		POJO p = new POJO();
//		p = session.get(POJO.class, 30065);
		
		p.setEid(30065);
		p.setEname("Bhuvana Srija");
		p.setEmail("abs@gmail.com");
		
		int n = (Integer) session.save(p);
		// PERSISTANT means data which is saved is updated in the database
		
		t.commit();
		System.out.println(p);
		System.out.println("Data is Saved!");
		
		// NOW, CLOSE factory, session objects
		factory.close();
		session.close();
	}

}
