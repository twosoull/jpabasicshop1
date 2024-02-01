package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private Integer price;
    private Integer stockQuantity;

}
