package org.levelup.bank.jdbc.pool;

import org.levelup.bank.jdbc.ConnectionManager;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSqlConnectionManager implements ConnectionManager {

    // DriverManager
    // Driver
    // Connection

    private final ConnectionPool pool;

    public PostgreSqlConnectionManager() {
        this.pool = new ConnectionPool();
    }

    @Override
    public Connection openConnection() throws SQLException {
        // JDBC URL
        // <jdbc:<vendor_name/driver_name>://<dns_name/ip_address>:<port>/<database_schema_name>?<param1>=<value1>&<param2>=<value2>
        Connection connection = pool.acquireConnection();
        if (connection == null) {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/bank_application",
                    "postgres",
                    "%?Pzbmeu2T"
            );
            connection = proxyConnection(connection); // создали прокси-объект
            pool.putConnectionToPool(connection);
        }
        return connection;
    }

    private Connection proxyConnection(Connection realConnection) {
        return (Connection) Proxy.newProxyInstance(
                realConnection.getClass().getClassLoader(),
                realConnection.getClass().getInterfaces(),
                new ConnectionCloseInvocationHandler(realConnection, pool)
        );
    }
}
