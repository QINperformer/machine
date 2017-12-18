
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MachineTest {
    
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
       SessionFactory sessionFactory= configuration.buildSessionFactory();
       sessionFactory.openSession();
    }
    
}
