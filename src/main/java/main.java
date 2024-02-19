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
            Team team =new Team();
            team.setName("ddsad");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

            em.flush();
            em.clear();

            //이렇게하면 조인이 가능하지만 조인 이용시에는 이렇게 사용하면 안된다
            //List<Member> resultList = em.createQuery("select m.team from Member m", Member.class).getResultList();

            //이렇게 해야 조인이 예측이 된다.
            //List<Team> resultList1 = em.createQuery("select t from Member m join m.team t", Team.class).getResultList();

            //임베디드 타입은 같은 테이블 안에 있기 때문에 사용해도 문제없다.
            //em.createQuery("select m.address from Member m", Address.class).getResultList();

            System.out.println("asdsa");

            em.createQuery("select new jpabook.jpashop.domain.MemberDTO(m.username) from Member m", MemberDTO.class).getResultList();

            System.out.println("zxvas");
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();

        }
        emf.close();


    }

}
