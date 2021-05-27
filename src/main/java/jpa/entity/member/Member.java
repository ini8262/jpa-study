package jpa.entity.member;

import jpa.entity.BaseEntity;
import jpa.entity.valuetype.Address;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@ToString
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="TEAM_ID")
    private Team team;

    private String name;

    @Embedded
    private Address address;

    @ElementCollection
    @CollectionTable(name="FAVORITE_FOOD", joinColumns = @JoinColumn(name="MEMBER_ID"))
    private Set<String> favoriteFoods = new HashSet<>();

    public void setTeam(Team team) {
        this.team = team;
        this.team.getMembers().add(this);
    }
}
