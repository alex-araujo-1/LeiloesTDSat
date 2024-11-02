/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leiloestdsat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class conectaDAO {
    
     public Connection connectDB() {

        try {

            Connection conn = DriverManager.getConnection
        ("jdbc:mysql://localhost:3306/leiloes_uc11", "root", "desenvolvedor");
             return conn;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }
        return null;
       
    }
    
}
