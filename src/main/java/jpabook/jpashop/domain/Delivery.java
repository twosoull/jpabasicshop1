package jpabook.jpashop.domain;

import org.hibernate.criterion.Order;

import javax.persistence.*;

@Entity
public class Delivery {

    @Id @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipcode;

    @Embedded
    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery")
    private Orders orders;
}
