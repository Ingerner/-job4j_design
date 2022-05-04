package ru.job4j.jdbc;

import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws ClassNotFoundException, SQLException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        String driver = properties.getProperty("driver");
        Class.forName(driver);
        String url = properties.getProperty("url");
        String user = properties.getProperty("login");
        String password = properties.getProperty("password");
        connection = DriverManager.getConnection(url, user, password);
    }

    public  void exe(String tableName, String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println(getTableScheme(connection, tableName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeUp(String tableName, String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void createTable(String tableName) {
            String sql = String.format(
                    "create table if not exists %s(%s, %s);",
                    tableName,
                    "id serial primary key",
                    "name text"
            );
     exe(tableName, sql);
    }


    public void dropTable(String tableName) {
            String sql = String.format(
                    "drop table %s;",
                    tableName
            );
        executeUp(tableName, sql);
    }

    public void addColumn(String tableName, String columnName, String type) {
            String sql = String.format(
                    "alter table %s add %s %s;",
                    tableName,
                    columnName,
                    type
            );
        exe(tableName, sql);
    }

    public void dropColumn(String tableName, String columnName) {
            String sql = String.format(
                    "alter table %s drop %s;",
                    tableName,
                    columnName
            );
        exe(tableName, sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
            String sql = String.format(
                    "alter table %s rename %s to %s;",
                    tableName,
                    columnName,
                    newColumnName
            );
        exe(tableName, sql);
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.put("driver", "org.postgresql.Driver");
        properties.put("url", "jdbc:postgresql://localhost:5432/idea_db");
        properties.put("login", "postgres");
        properties.put("password", "*#*Job4j");
        TableEditor editor = new TableEditor(properties);
        editor.createTable("example_table");
        editor.addColumn("example_table", "first_name", "varchar(255)");
        editor.dropColumn("example_table", "first_name");
        editor.renameColumn("example_table", "name", "human");
        editor.dropTable("example_table");

    }
}