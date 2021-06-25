package org.levelup.bank.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.levelup.bank.domain.AccountEntity;
import org.levelup.bank.domain.ClientEntity;
import org.mockito.ArgumentMatchers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RequiredArgsConstructor
public class AccountRepositoryTest {

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    private AccountRepository accountRepository;

    // BeforeEach - перед методом @Test
    // AfterEach - после метода @Test
    // BeforeAll - в самом начале - перед выполнением всех тестов - обязан быть static
    // AfterAll - в самом конце - после выполнения всех тестов - обязан быть static

    // BeforeAll
    // BeforeEach
    // Test
    // AfterEach
    // BeforeEach
    // Test
    // AfterEach
    // AfterAll

    @BeforeEach // метод помеченный этой аннотацией будет вызываться перед каждым тестом
    public void setupBehaviour() {
        factory = mock(SessionFactory.class); // factory - реальный объект, существующий в памяти (не null)
        session = mock(Session.class);
        transaction = mock(Transaction.class);

        when(factory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);


        accountRepository = new AccountRepository(factory);
    }

    @Test
    public void testCreateAccount_whenValidParams_thenCreateAnAccount() {
        // given
        long clientId = 1L;

        // when
        AccountEntity result = accountRepository.createAccount(1L);

        // then
        assertEquals(0, result.getAmount());
        assertEquals(16, result.getAccountNumber().length());
    }

    @Test
    public void testCreateAccount_whenValidParams_thenCheckAccountClient() {
        // given
        long clientId = 1L;
        ClientEntity client = new ClientEntity();
        client.setClientId(clientId);

        // when(session.load(ClientEntity.class, 1))
        // session.load(ClientEntity.class, 2) -> null
        when(session.load(ClientEntity.class, clientId)).thenReturn(client);

        // when
        AccountEntity result = accountRepository.createAccount(1L);

        // then
        assertNotNull(result.getClient());
        assertSame(client, result.getClient()); // assertSame - сравнение по ссылкам
        // assertEquals(clientId, result.getClient().getClientId));
    }

    @Test
    public void testCreateAccount_whenValidParams_thenVerifyMethodCalls() {
        // given
        long clientId = 1L;

        // when
        AccountEntity result = accountRepository.createAccount(1L);

        // then
        verify(session).save(ArgumentMatchers.any(AccountEntity.class));
        verify(transaction).commit();
        verify(session, times(1)).close();
    }

    @Test
    public void testLoadClientAccounts_whenAccountsExist_thenReturnAccountList() {
        // given
        long clientId = 1L;
        Query query = mock(Query.class);

        // when() / verify()
        // все параметры переопределяемого метода должны быть:
        // либо реальные объекты - те которые созданы самостоятельно, или получены откуда-то
        // либо объектами ArgumentMatchers
        when(session.createQuery(ArgumentMatchers.anyString(), ArgumentMatchers.eq(AccountEntity.class))) // eq - оборачивает реальный объект в ArgumentMatcher
                .thenReturn(query);
        when(query.setParameter("clientId", clientId))
                .thenReturn(query);

        List<AccountEntity> expectedResult = new ArrayList<>();
        expectedResult.add(new AccountEntity());
        expectedResult.add(new AccountEntity());

        when(query.getResultList()).thenReturn(expectedResult);

        // when
        Collection<AccountEntity> accounts = accountRepository.loadClientAccounts(clientId);

        // then
        assertSame(expectedResult, accounts);
        verify(session).close();

    }

}
