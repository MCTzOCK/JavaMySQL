/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package de.mctzock.javamysql;

import java.sql.*;

public class MySQL {

    /**
     * SQL query
     */
    private String sql;

    /**
     * MySQL Server host
     */
    private String host;

    /**
     * MySQL Server port
     */
    private String port;

    /**
     * MySQL Username
     */
    private String username;

    /**
     * MySQL Password
     */
    private String password;

    /**
     * MySQL Database
     */
    private String database;

    /**
     * Additional parameters for the connection (e.g. timezone or ssl)
     */
    private String additionalConnectionParameters;
    
    /**
     * MySQL database connection
     */
    private Connection con;

    /**
     * @param sql Your SQL query
     */
    public MySQL(String sql, String host, String port, String username, String password, String database, String additionalConnectionParameters){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.sql = sql;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database = database;
        this.additionalConnectionParameters = additionalConnectionParameters;
    }

    /**
     * @return The result of the query or null.
     */
    public ResultSet executeQuery(){
        try {
            this.con = DriverManager.getConnection(getConnectionString(), username, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            return rs;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Execute Update with the given sql string.
     */
    public void executeUpdate(){
        try {
            this.con = DriverManager.getConnection(getConnectionString(), username, password);
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Close connection and disconnect from database.
     * Attention! ResultSets can't be used after this method is called.
     */
    public void close(){
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * @return Connection URL to database.
     */
    public String getConnectionString(){
        return "jdbc:mysql://" + host + ":" + port + "/" + database + "?" + additionalConnectionParameters;
    }

    /**
     * @return The given sql string.
     */
    public String getSql() {
        return sql;
    }

    /**
     * @return The given host string.
     */
    public String getHost() {
        return host;
    }

    /**
     * @return The given port string.
     */
    public String getPort() {
        return port;
    }

    /**
     * @return The given database string.
     */
    public String getDatabase() {
        return database;
    }

    /**
     * @return The given username string.
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return The given password string.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return The given addition parameters string.
     */
    public String getAdditionalConnectionParameters() {
        return additionalConnectionParameters;
    }
}
