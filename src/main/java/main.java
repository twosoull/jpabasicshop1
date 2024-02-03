import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Movie;
import jpabook.jpashop.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();


        try{

            Movie movie = new Movie();

            movie.setActor("actor");
            movie.setName("영화이름");
            movie.setDirector("디렉터");


            em.persist(movie);
            em.flush();
            em.clear();

            Movie movie1 = em.find(Movie.class, movie.getId());

            System.out.println("movie = " + movie1);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();

        }
        emf.close();


    }
}
