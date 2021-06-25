package org.levelup.bank.It;

import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.levelup.bank.domain.AccountEntity;
import org.levelup.bank.domain.ClientEntity;
import org.levelup.bank.repository.AccountRepository;
import org.levelup.bank.repository.ClientRepository;

import java.time.LocalDate;

public class AccountRepositoryIT {

    private static ClientRepository clientRepository;
    private static AccountRepository accountRepository;

    @BeforeAll
    public static void setupRepositories() {
        clientRepository = new ClientRepository(ItHibernateUtils.getFactory());
        accountRepository = new AccountRepository(ItHibernateUtils.getFactory());
    }

    @Test
    public void testCreateAccount_whenValidParams_thenCreateAccount() {
        // given
        ClientEntity client = clientRepository
                .createClient("Richard", "King", null, LocalDate.of(1993, 9, 18));
        // when
        AccountEntity result = accountRepository.createAccount(client.getClientId());

        // then
        Session s = ItHibernateUtils.getFactory().openSession();
        AccountEntity account = s.get(AccountEntity.class, result.getAccountNumber());

        Assertions.assertEquals(account.getAccountNumber(), result.getAccountNumber());
        Assertions.assertEquals(account.getAmount(), result.getAmount());
        Assertions.assertEquals(account.getClient().getClientId(), result.getClient().getClientId());
    }

}
