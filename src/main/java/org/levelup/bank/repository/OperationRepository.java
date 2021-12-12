package org.levelup.bank.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.levelup.bank.domain.FilialManagerEntity;

@RequiredArgsConstructor
public class OperationRepository {

    private final SessionFactory factory;

    public FilialManagerEntity addFilialManager(int managerId, int filialId) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();

            FilialManagerEntity filial = new FilialManagerEntity();
            filial.setManagerId(managerId);
            filial.setFilialId(filialId);

            session.persist(filial);

            tx.commit();
            return filial;
        }
    }

    public FilialManagerEntity getById(Integer managerId) {
        try (Session session = factory.openSession()) {
            return session.get(FilialManagerEntity.class, managerId);
        }
    }

    public FilialManagerEntity loadById(Integer managerId) {
        try (Session session = factory.openSession()) {
            return session.load(FilialManagerEntity.class, managerId);
        }
    }
}
