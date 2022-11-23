import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    private SQLServerDataSource ds;
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.ds = new SQLServerDataSource();
        m.ds.setServerName("10.176.111.31");
        m.ds.setDatabaseName("testing_no_sus");
        m.ds.setPortNumber(1433);
        m.ds.setUser("CSe21B_39");
        m.ds.setPassword("CSe21B_39");


        System.out.println("Hello world!");
        System.out.println(m.getAll(m.ds));
    }
    public String getAll(SQLServerDataSource cm) throws IOException {
        String all = "";
        try (Connection con = cm.getConnection()) {
            String sqlcommandSelect = "SELECT * FROM Movies";
            PreparedStatement pstmtSelect = con.prepareStatement(sqlcommandSelect);
            ResultSet rs = pstmtSelect.executeQuery();
            while(rs.next())
            {
                all+=rs.getInt("Id") +
                    rs.getString("Title") +
                    rs.getInt("Year") + "\n";
            }
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return all;
    }
}