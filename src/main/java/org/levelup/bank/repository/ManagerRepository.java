package org.levelup.bank.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.levelup.bank.domain.ManagerEntity;

@RequiredArgsConstructor
public class ManagerRepository {

    private final SessionFactory factory;

    public ManagerEntity addManager(String firstName, String lastName) {
        try (Session sessions = factory.openSession()) {
            Transaction tx = sessions.beginTransaction();
            // ACID
            // A - Атомарность (atomicity)
            // C - Consistency (Консистентность) - Согласованность данных
            // I - Isolation (Изоляция, изолированность транзакций)
            // D - Durability

            ManagerEntity manager = new ManagerEntity();
            manager.setFirstName(firstName);
            manager.setLastName(lastName);

            sessions.persist(manager);

            tx.commit();
            return manager;
        }
    }

    // session.get(Class, Id)
    // session.load(Class, Id)

    public ManagerEntity getById(Integer managerId) {
        try (Session session = factory.openSession()) {
            return session.get(ManagerEntity.class, managerId);
        }
    }

    public ManagerEntity loadById(Integer managerId) {
        try (Session session = factory.openSession()) {
            return session.load(ManagerEntity.class, managerId);
            // me = proxy(ManageEntity(id=managerId))
            // me.getFirstName() -> select * from manager
        }
    }

}