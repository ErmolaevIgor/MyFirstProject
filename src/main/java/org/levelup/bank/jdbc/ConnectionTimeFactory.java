package org.levelup.bank.jdbc;

import java.lang.reflect.Proxy;

public class ConnectionTimeFactory {

    public static ConnectionManager getConnection() {
        return (ConnectionManager) Proxy.newProxyInstance(
                ConsoleConnection.class.getClassLoader(),
                ConsoleConnection.class.getInterfaces(),
                new ConnectionTimeInvocationHandler(new ConsoleConnection())
        );
    }

}
