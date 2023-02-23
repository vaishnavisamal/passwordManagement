package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.PasswordData;

public class PasswordDataDao {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("project");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public void savePasswordData(PasswordData user){
		et.begin();
		em.persist(user);
		et.commit();
	}
	
	public List<PasswordData> getPasswordDataByEmailAndPassword(String email,String password){
		Query query=em.createQuery("select u from PasswordData u where u.email=?1 and u.password=?2");
		query.setParameter(1,email);
		query.setParameter(2, password);
		List<PasswordData> user =query.getResultList();
		
		  if(user.size()>0) {
			  return user;
		  }
		  else {
		return null;
		  }
	}
	
	public List<PasswordData> getAllPasswordDatasDetails(){
		Query query=em.createQuery("Select u from PasswordData u",PasswordData.class);
		return query.getResultList();
	}
	
	public PasswordData getPasswordDataById(int id) {
		return em.find(PasswordData.class,id);
	}
	
	public PasswordData deletePasswordDataById(int id) {
		PasswordData user=em.find(PasswordData.class, id);
		et.begin();
		em.remove(user);
		et.commit();
		return user;
	}
	
	public PasswordData updatePasswordDataById(PasswordData passwordData) {
		et.begin();
		em.merge(passwordData);
		et.commit();
		return passwordData;
		
	}

}
