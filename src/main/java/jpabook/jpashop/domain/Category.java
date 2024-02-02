package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "CATAGORY_ITEM", joinColumns= @JoinColumn(name="CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    ) //inversJoinColumns 반대쪽이 조인하는 애
    private List<Item> items = new ArrayList<>();

}
