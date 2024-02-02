package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Locker {

    @Id @GeneratedValue
    @Column(name="LOCKER_ID")
    private Long Id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;
}
