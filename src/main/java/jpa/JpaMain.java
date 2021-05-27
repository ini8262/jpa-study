package jpa;

import jpa.entity.member.Member;
import jpa.entity.member.Team;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        //앱실행시 최초 한번
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        //고객의 요청이 올때마다 만들었다 버렸다가해야함
        EntityManager em = emf.createEntityManager();       //영속성 컨테스트 (엔티티 매니저와 영속성 컨텍스트가 1: 1)

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();


            //Team team = em.find(Team.class, 1L);

            for (long i = 0; i < 10; i++) {
                Member member = em.find(Member.class, i);
                System.out.println(member);
            }

            /*Member member = em.find(Member.class, 7L);
            System.out.println(member);*/

            /*Team dev1 = initTeam("dev1");
            Team dev2 = initTeam("dev2");
            em.persist(dev1);
            em.persist(dev2);

            em.persist(initMember("hun", dev2));
            */

            //em.flush();
            tx.commit();    //커밋하는 순간 데이터베이스에 sql 실행 (단 키본키 전략이 아이덴티티 전략이 아닌경우만)
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static Team initTeam(String name) {
        Team team = new Team();
        team.setName(name);

        return team;
    }

    private static Member initMember(String name, Team team) {
        Member member = new Member();
        member.setName(name);
        member.setTeam(team);

        return member;
    }

    /*private static void update(EntityManager em) {
        Member findM = em.find(Member.class, 1L);
        findM.setName("hong");
    }*/
}
