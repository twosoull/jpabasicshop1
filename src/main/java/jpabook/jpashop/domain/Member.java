package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @OneToMany(mappedBy = "member")
    private List<Orders> ordersList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;
/*  다대다

    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT")
    private List<Product> products = new ArrayList<>();
*/

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
