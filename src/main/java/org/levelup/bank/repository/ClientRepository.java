package org.levelup.bank.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.levelup.bank.domain.ClientEntity;

import java.time.LocalDate;

@RequiredArgsConstructor
public class ClientRepository {

    private final SessionFactory factory;

    public ClientEntity createClient(String firstName, String lastName, String middleName, LocalDate birthday) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();

            ClientEntity entity = new ClientEntity();
            entity.setFirstName(firstName);
            entity.setLastName(lastName);
            entity.setMiddleName(middleName);
            entity.setBirthday(birthday);

            session.persist(entity);

            tx.commit();
            return entity;
        }
    }
}
