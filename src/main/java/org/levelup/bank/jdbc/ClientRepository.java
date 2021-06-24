package org.levelup.bank.jdbc;

import org.levelup.bank.domain.ClientEntity;

import java.time.LocalDate;
import java.util.Collection;

// Controller /bank/new/client -> createNewClient from ClientController
// Service
// DAO/Repository
//      DAO - Data Access Objects
//      CRUD - CreateReadUpdateDelete
public interface ClientRepository {

    void createNewClient(String firstName, String lastName, String middleName, LocalDate birthday);

    void printAllClients();

    Collection<ClientEntity> findClientsWhenBirthdayBetween(LocalDate begin, LocalDate end);

}
