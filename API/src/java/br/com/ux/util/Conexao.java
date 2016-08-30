/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ux.util;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author charles
 */
public class Conexao {

    @PersistenceContext(unitName = "TesteWebServicePU")
    public EntityManager em;

    public static Connection conexaoJDBC() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/testews", "teste", "teste");
            return conexao;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
