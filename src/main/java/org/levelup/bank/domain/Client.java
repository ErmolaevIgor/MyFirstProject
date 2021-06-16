package org.levelup.bank.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor

public class Client {

    private Long clientId;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthday;

}
