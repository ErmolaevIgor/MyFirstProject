package org.levelup.bank.It;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.levelup.bank.domain.*;

import java.util.Properties;

public class ItHibernateUtils {

    private static SessionFactory factory = loadTestFactory();

    private static SessionFactory loadTestFactory() {

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        hibernateProperties.setProperty("hibernate.connection.url", "jdbc:postgresql://127.0.0.1:5432/bank_test");
        hibernateProperties.setProperty("hibernate.connection.username", "postgres");
        hibernateProperties.setProperty("hibernate.connection.password", "%?Pzbmeu2T");

        hibernateProperties.setProperty("show_sql", "true");
        hibernateProperties.setProperty("format_sql", "true");

        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");

        Configuration configuration = new Configuration()
                .addAnnotatedClass(ClientEntity.class)
                .addAnnotatedClass(AccountEntity.class)
                .addAnnotatedClass(ClientDataEntity.class)
                .addAnnotatedClass(OperationEntity.class)
                .addAnnotatedClass(ManagerEntity.class)
                .addAnnotatedClass(FilialEntity.class);

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .applySettings(hibernateProperties)
        .build();

        return configuration.buildSessionFactory(registry);
    }

    public static SessionFactory getFactory() {
        return factory;
    }

}
