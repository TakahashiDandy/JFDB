/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dandyrahadiansyah
 */
public class JFDBCommand {
    
    final Connection conn;
    
    public JFDBCommand(Connection conn) {
        this.conn = conn;
    }
    
    public void insertData(String tablename, String[] data){
        try {
            Statement st = conn.createStatement();
            String insert = "Insert into "+ tablename + " values (";
            for(int a = 0; a < data.length; a++){
                if(a == data.length-1){
                    insert += "'" + data[a]+ "')";
                } else {
                    insert += "'" + data[a]+ "',";
                }
            }
            st.executeUpdate(insert);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateData(String tablename, String[] columnNames, String[] data, String whereClause){
        if(whereClause == null){
            whereClause = "";
        }
        try {
            Statement st = conn.createStatement();
            String update = "Update "+ tablename + " set ";
            for(int a = 0; a < data.length; a++){
                if(a == data.length-1){
                    update += columnNames[a] + "='" + data[a]+ "'" + whereClause;
                } else {
                    update += columnNames[a] + "='" + data[a]+ "',";
                }
            }
            st.executeUpdate(update);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void deleteData(String tablename, String whereClause){
        if(whereClause == null){
            whereClause = "WHERE 0";
        }
        try {
            Statement st = conn.createStatement();
            String delete = "Delete from " + tablename + " " + whereClause;
            st.executeUpdate(delete);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public ResultSet selectData(String sql){
        ResultSet rs = null;
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rs;
    }
}
