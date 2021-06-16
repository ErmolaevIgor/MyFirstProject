package org.levelup.bank.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class ConsoleConnection implements ConnectionManager{

    @Override
    @ConnectionTime
    public Connection openConnection() throws SQLException {
        return null;
    }
}
