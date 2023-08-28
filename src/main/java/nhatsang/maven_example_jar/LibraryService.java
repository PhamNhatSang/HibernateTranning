package nhatsang.maven_example_jar;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class LibraryService {
    public List<Book> getAllBooksByAuthor(String authorName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Book> query = builder.createQuery(Book.class);
            Root<Book> root = query.from(Book.class);
            query.select(root)
                 .where(builder.equal(root.get("author").get("name"), authorName));

            return session.createQuery(query).getResultList();
        }
    }
    
    public void updateBookHQL(int bookId, String newTitle){
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Transaction transaction = null;
    	try {
    	    transaction = session.beginTransaction();

    	    String hql = "UPDATE Book SET title = :newTitle WHERE id = :bookId";
            Query query = session.createQuery(hql);
            query.setParameter("newTitle", newTitle);
            query.setParameter("bookId", bookId);

            int updatedCount = query.executeUpdate();
            System.out.println("Updated "+updatedCount);
    	    transaction.commit(); 
    	} catch (Exception e) {
    	    if (transaction != null) {
    	        transaction.rollback(); 
    	    }
    	    e.printStackTrace();
    	} finally {
    	    session.close(); 
    	}
}
}

