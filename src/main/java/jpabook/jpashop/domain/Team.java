package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team") //mappedBy는 나는 무엇과 연결되어있지? 라면 Member에서 선언한 필드의 team이다.
    private List<Member> members = new ArrayList<>(); //arrayList를 쓰는 이유는 nullPoint가 뜨지 않기 위함

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void addMember(Member member) {
        member.setTeam(this);
        members.add(member);
    }
}
