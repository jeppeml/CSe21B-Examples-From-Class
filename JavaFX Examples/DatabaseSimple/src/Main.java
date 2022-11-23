import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        SQLServerDataSource ds;
        ds = new SQLServerDataSource();
        ds.setDatabaseName("CSe22B_40_MRS"); // make this unique as names are shared on server
        ds.setUser("CSe22B_40"); // Use your own username
        ds.setPassword("CSe22B_40"); // Use your own password
        ds.setServerName("10.176.111.31");
        ds.setPortNumber(1433);
        ds.setTrustServerCertificate(true); // Newer JDBC has this on by default, our db doesn't work with real TLS certificate

        try(Connection con = ds.getConnection()){
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM persons");
            while(rs.next()){
                int id = rs.getInt("id");
                String full_name = rs.getString("full_name");
                int zip = rs.getInt("zipcode");
                System.out.println(id + " , " + full_name + " , " + zip);
            }

        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}