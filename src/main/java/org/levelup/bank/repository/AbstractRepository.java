package org.levelup.bank.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.function.Function;

@RequiredArgsConstructor
public abstract class AbstractRepository {

    protected final SessionFactory factory;

    public <T> T supplyWithoutTransaction(Function<Session, T> sessionFunction) {
        try (Session session = factory.openSession()){
            // T apply(Session s)
            return sessionFunction.apply(session);
        }
    }

}
