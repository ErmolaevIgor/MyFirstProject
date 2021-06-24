package org.levelup.bank.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor // у entity всгда должен быть пустой конструктор (конструктор без параметров)
@Entity
@Table(name = "accounts") //
public class AccountEntity {

    @Id // первичный ключ
    @Column(name = "account_number")

    private String accountNumber;
    private double amount;          // double vs Double - double - если колонка имеет ограничение not null
                                    //                    Double - если нет not null
//    @Column(name = "client_id")
//    private Long clientId;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

}
