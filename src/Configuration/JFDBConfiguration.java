/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dandyrahadiansyah
 */
public class JFDBConfiguration {
    private final String driver = "com.mysql.jdbc.Driver";
    private String ipaddress = "localhost";
    private String dbuser = "root";
    private String dbpass = "";
    private String dbname = "";
    private Connection conn = null;
    

    public JFDBConfiguration(String ipaddress, String dbuser, String dbpass, String dbname) {
        this.ipaddress = ipaddress;
        this.dbuser = dbuser;
        this.dbpass = dbpass;
        this.dbname = dbname;
        loadConnection();
    }
    
    private void loadConnection(){
        try {
            Class.forName(driver).newInstance();
            String javaconnection ="jdbc:mysql://"+getIpaddress()+":3306/"+ getDbname();
            conn = DriverManager.getConnection(javaconnection, getDbuser(), getDbpass());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
        }
    }
    
    public Connection getConnection(){
        return this.conn;
    }
    
    public void closeConnection() throws SQLException{
        this.conn.close();
    }

    /**
     * @return the ipaddress
     */
    public String getIpaddress() {
        return ipaddress;
    }

    /**
     * @param ipaddress the ipaddress to set
     */
    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    /**
     * @return the dbuser
     */
    public String getDbuser() {
        return dbuser;
    }

    /**
     * @param dbuser the dbuser to set
     */
    public void setDbuser(String dbuser) {
        this.dbuser = dbuser;
    }

    /**
     * @return the dbpass
     */
    public String getDbpass() {
        return dbpass;
    }

    /**
     * @param dbpass the dbpass to set
     */
    public void setDbpass(String dbpass) {
        this.dbpass = dbpass;
    }

    /**
     * @return the dbname
     */
    public String getDbname() {
        return dbname;
    }

    /**
     * @param dbname the dbname to set
     */
    public void setDbname(String dbname) {
        this.dbname = dbname;
    }
    
}
