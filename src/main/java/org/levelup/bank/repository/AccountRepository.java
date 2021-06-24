package org.levelup.bank.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.levelup.bank.domain.AccountEntity;
import org.levelup.bank.domain.ClientEntity;

import java.util.Collection;
import java.util.UUID;

@RequiredArgsConstructor
public class AccountRepository {

    private final SessionFactory factory;

    public AccountEntity createAccount(long clientId) {
        try (Session session = factory.openSession()) {
            // Все операции по добавлению, изменению и удалению записей должны быть выполнены в рамках транзакций
            Transaction tx = session.beginTransaction(); // момент начала транзакции

            AccountEntity account = new AccountEntity();
            account.setClient(session.load(ClientEntity.class, clientId));
            account.setAmount(0.0d);
            account.setAccountNumber(UUID.randomUUID().toString().substring(0, 16)); // генерации UUID

            session.save(account);

            tx.commit(); // фиксируем изменения, сделанные в рамках транзакции
            return account;
        }
    }

    public Collection<AccountEntity> loadClientAccounts(long clientId) {
        try (Session session = factory.openSession()) {
            // HQL - Hibernate Query Language = similar to SQL
            return session.createQuery("from AccountEntity where clientId = :clientId", AccountEntity.class)
                    .setParameter("clientId", clientId)
                    .getResultList();

            // HQL: from AccountEntity clientId = 1
            // SQL: select * from accounts where client_id = 1;
        }
    }

}
