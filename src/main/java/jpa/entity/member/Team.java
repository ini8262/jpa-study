package jpa.entity.member;

import jpa.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Team extends BaseEntity {

    @Id @GeneratedValue
    @Column(name="TEAM_ID")
    private Long id;

    private String name;

    //@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();
}
