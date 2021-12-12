package org.levelup.bank.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.levelup.bank.domain.FilialEntity;
import org.levelup.bank.domain.FilialManagerEntity;
import org.levelup.bank.domain.ManagerEntity;
import org.levelup.bank.repository.ClientRepository;
import org.levelup.bank.repository.ManagerRepository;
import org.levelup.bank.repository.OperationRepository;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.getFactory();

        // (ниже рабочий пример записи нового клиента в ClientEntity)
        ClientRepository newClient = new ClientRepository(factory);
        newClient.createClient("Fedor", "Troshkin", "Alekseevich", LocalDate.of(2000, 9, 18));

//        AccountRepository accountRepository = new AccountRepository(factory);
//
//        AccountEntity account = accountRepository.createAccount(1);
//        System.out.println(account.toString());
//
//        Collection<AccountEntity> accounts = accountRepository.loadClientAccounts(2);
//        for (AccountEntity account : accounts) {
//            System.out.println(account.toString());
//        }
//        factory.close();

//        ManagerRepository managerRepository = new ManagerRepository(factory);
//        ManagerEntity manager1 = managerRepository.addManager("Hello", "World");
//        ManagerEntity manager2 = managerRepository.addManager("Igor", "Ermolaev");
//
//        ManagerEntity get = managerRepository.getById(manager1.getId());
//        ManagerEntity load = managerRepository.loadById(manager2.getId());
//
//        System.out.println(get);
//        Session s = factory.openSession();
//        s.refresh(get); // s.merge(get)
//        System.out.println(get.getFilials());
//        s.close();
//        System.out.println(load);

//        OperationRepository operationRepository = new OperationRepository(factory);
//        FilialManagerEntity filial1 = operationRepository.addFilialManager(946580000,745795602);

        factory.close();
    }
}
