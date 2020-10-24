package automovel;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Application {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("automovel"); 
		EntityManager em = emf.createEntityManager();		

		em.getTransaction().begin();
			
			Marca marca1 = new Marca(null, "Toyota");
			Marca marca2 = new Marca(null, "Chery");
			
			Modelo modelo1 = new Modelo(null, "Yaris", 1600, marca1);
			Modelo modelo2 = new Modelo(null, "QQ", 1100, marca2);
			
			Automovel auto1 = new Automovel(null, 2020, 2021, "Yaris", 78000.00, 325, modelo1);
			Automovel auto2 = new Automovel(null, 2018, 2016, "QQ", 12000.00, 37000, modelo2);
		
			em.persist(marca1);
			em.persist(marca2);
			em.persist(modelo1);
			em.persist(modelo2);
			em.persist(auto1);
			em.persist(auto2);

			
		em.getTransaction().commit();		
		em.close();		
		emf.close();
	}
}
