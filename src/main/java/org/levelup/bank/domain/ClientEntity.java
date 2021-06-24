package org.levelup.bank.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "clients")
@NoArgsConstructor

public class ClientEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId; // insert into clients (first_name, last_name...) values ('', '', ...);
    // insert into clients (id, first_name, last_name...) values (1,
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    private LocalDate birthday;


    // 1-to-1 unidirectional relation
    // @JoinColumn(name = "client_id") // название колонки, которая содержит foreign key в таблице client_data
    @OneToOne(mappedBy = "client") // mappedBy - поле, которое хранит ссылку на первый объект в связи (поле из класса ClientDataEntity, которое имеет тип ClientEntity
    private ClientDataEntity clientDataEntity;

    @OneToMany(mappedBy = "client")
    private Collection<AccountEntity> accounts;

    public ClientEntity(Long clientId, String firstName, String lastName, String middleName, LocalDate birthday) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthday = birthday;
    }
}
