package org.levelup.bank.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@ToString(exclude = "filials")
@Table(name = "manager")
@NoArgsConstructor
public class ManagerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "filial_manager",
            joinColumns = @JoinColumn(name = "manager_id"),           // колонка, которая находится в таблице filial_manager и имеет внешний ключ на текущую таблицу (на таблицу managers)
            inverseJoinColumns = @JoinColumn(name = "filial_id")    // колонка, которая находится в таблице filial_manager и имеет внешний ключ на связующую таблицу (на таблицу managers)
    )
    private Collection<FilialEntity> filials;
}
