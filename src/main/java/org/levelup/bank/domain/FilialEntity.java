package org.levelup.bank.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@ToString(exclude = "managers")
@Table(name = "filial")
@NoArgsConstructor
public class FilialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "bank_code")
    private String bankCode;
    private String address;

    @ManyToMany(mappedBy = "filials")
    private Collection<ManagerEntity> managers;

}
