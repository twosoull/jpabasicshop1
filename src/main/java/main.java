import jpabook.jpashop.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();


        try{

            Team teamA =new Team();
            teamA.setName("ddsad");
            em.persist(teamA);

            Team teamB =new Team();
            teamB.setName("teamB");
            em.persist(teamB);

            Team teamC =new Team();
            teamC.setName("teamC");
            em.persist(teamC);

            Member memberA = new Member();
            memberA.setUsername("memberA");
            memberA.setTeam(teamA);
            memberA.setAge(1);
            memberA.setMemberType(MemberType.ADMIN);

            Member memberB = new Member();
            memberB.setUsername("memberB");
            memberB.setTeam(teamA);
            memberB.setAge(1);
            memberB.setMemberType(MemberType.ADMIN);

            Member memberC = new Member();
            memberC.setUsername("memberC");
            memberC.setTeam(teamB);
            memberC.setAge(1);
            memberC.setMemberType(MemberType.ADMIN);

            em.persist(memberA);
            em.persist(memberB);
            em.persist(memberC);

            em.flush();
            em.clear();

            //String query = "select m from Member m ";
            //String query = "select m from Member m join fetch m.team";

            List<Member> resultList = em.createNamedQuery("Member.findByUsername",Member.class)
                    .setParameter("username" , memberA.getUsername()).getResultList();

            for (Member o : resultList) {
                System.out.println("Member " + o.getUsername());
            }

            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();

        }
        emf.close();


    }

}
