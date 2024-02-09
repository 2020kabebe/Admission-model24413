package dao;

	import model.Student;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.query.Query;
	

	import java.util.List;
  
	public class StudentDAO {

	    private SessionFactory sessionFactory;

	    public StudentDAO() {
	        this.sessionFactory = HibernateUtil.getSessionFactory();
	    }

	    public void register(Student student) {
	    	
	        Transaction trans = null;
	        
	        try (Session ss = sessionFactory.openSession()) {
	        	
	            trans = ss.beginTransaction();
	            
	            ss.save(student);
	            
	            trans.commit();
	            
	        } catch (Exception ex) {
	            if (trans != null) {
	                trans.rollback();
	            }
	            ex.printStackTrace();
	        }
	    }

	    public void update(Student student) {
	    	
	        Transaction trans = null;
	        
	        try (Session ss = sessionFactory.openSession()) {
	        	
	            trans = ss.beginTransaction();
	            
	            ss.update(student);
	            
	            trans.commit();
	            
	        } catch (Exception ex) {
	            if (trans != null) {
	                trans.rollback();
	            }
	            ex.printStackTrace();
	        }
	    }

	    public Student searchById(Long id) {
	    	
	        try (Session ss = sessionFactory.openSession()) {
	        	
	            return ss.get(Student.class, id);
	            
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return null;
	        }
	    }

	    public List<Student> findAll() {
	    	
	        try (Session ss = sessionFactory.openSession()) {
	        	
	            Query<Student> query = ss.createQuery("FROM Student", Student.class);
	            return query.getResultList();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return null;
	        }
	    }

	    public void delete(Student student) {
	    	
	        Transaction trans = null;
	        
	        try (Session ss = sessionFactory.openSession()) {
	        	
	            trans = ss.beginTransaction();
	            
	            ss.delete(student);
	            
	            trans.commit();
	            
	        } catch (Exception ex) {
	        	
	            if (trans != null) {
	            	
	                trans.rollback();
	            }
	            ex.printStackTrace();
	        }
	    }
	}

