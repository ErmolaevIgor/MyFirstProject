package org.levelup.bank.jdbc;

import lombok.SneakyThrows;
import org.levelup.bank.domain.ClientEntity;
import org.levelup.bank.jdbc.pool.PostgreSqlConnectionManager;

import java.time.LocalDate;
import java.util.Collection;

public class BankApplication {

    @SneakyThrows
    public static void main(String[] args) {
        ConnectionManager cm = new PostgreSqlConnectionManager();
        ClientRepository clientRepository = new JdbcClientRepository(cm);

//        clientRepository.createNewClient("Im", "Last", null, null);
//        System.out.println();

        clientRepository.printAllClients();
        System.out.println();

        Collection<ClientEntity> clientEntities = clientRepository.findClientsWhenBirthdayBetween(
                LocalDate.of(1950, 1, 1),
                LocalDate.of(1980, 12, 31)
        );

        for (ClientEntity clientEntity : clientEntities) {
            System.out.println(clientEntity.getClientId() + " " + clientEntity.getLastName() + " " + clientEntity.getBirthday());
        }
        System.out.println();

        ConnectionTimeFactory.getConnection().openConnection();
    }

}
