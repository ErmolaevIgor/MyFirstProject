package org.levelup.bank.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "operations")
@NoArgsConstructor
public class OperationEntity {

    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operationId;

    @Column(name = "account_from")
    private String fromAccount;
    @Column(name = "account_to")
    private String toAccount;
    private Double amount;

}
