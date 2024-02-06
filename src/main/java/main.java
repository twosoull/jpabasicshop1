import jpabook.jpashop.domain.*;

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

            Member member = new Member();
            member.setUsername("member1");
            member.setAddress(new Address("city1","street","zipcode"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("피자");
            member.getFavoriteFoods().add("족발");

            member.getAddressHistory().add(new AddressEntity("ccc","Ddd","Fdsfs"));
            member.getAddressHistory().add(new AddressEntity("ccc","Ddd","Fdsfs"));

            em.persist(member);
            em.flush();
            em.clear();
/*

            //조회
            Member findMember = em.find(Member.class, member.getId());

            //수정
            // findMember.getAddress().setCity("newCiry"); 값타입은 절대로 이렇게 바꾸면 안된다. 사고난다.
            // 통으로 갈아끼우기
            findMember.setAddress(new Address("newCiry","ddd","safdasd"));
            //치킨 -> 한식
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

            // 주소 변경 // remove는 equals를 사용해서 변경한다.
            findMember.getAddressHistory().remove(new Address("ccc","Ddd","Fdsfs"));
            findMember.getAddressHistory().add(new Address("cc124","Ddddas","Fds124fs"));
*/

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();

        }
        emf.close();


    }

}
