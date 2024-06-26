package br.com.lojaautopecas.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    public Connection getConexao() {
        try {
            Properties prop = getProperties();
            final String url = prop.getProperty("banco.url");
            final String usuario = prop.getProperty("banco.usuario");
            final String senha = prop.getProperty("banco.senha");

            System.out.println("Conectado");
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, usuario , senha);
        }catch (SQLException | IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Properties getProperties() throws IOException {
        Properties prop = new Properties();
        String caminho = "/db.properties";
        prop.load(DBConnection.class.getResourceAsStream(caminho));
        return prop;
    }
}
