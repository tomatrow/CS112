import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDB
{

	private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String protocol = "jdbc:derby:";

	public static void main(String[] args)
	{
		try
		{
			Class.forName(driver).newInstance();
			System.out.println("Loaded the embedded driver.");
		}
		catch (Exception err)
		{
			System.err.println("Unable to load the embedded driver.");
			err.printStackTrace(System.err);
			System.exit(0);
        }
        String dbName = "BookDatabase";
        Connection conn = null;
        try
        {
			System.out.println("Connecting to the database...");
        	conn = DriverManager.getConnection(protocol + dbName);
			System.out.println("Connected.");

			System.out.println("Enter the ID number of the author to change:");
			Scanner scan = new Scanner(System.in);
			int id = scan.nextInt();
			scan.nextLine();
			// Skip newline after nextInt()
			System.out.println("Enter the new URL for this author.");
			String newURL = scan.nextLine();

			Statement s = conn.createStatement();
			s.execute("UPDATE names " +
				"SET URL = '" + newURL + "' WHERE author_id = " + id);

			System.out.println("URL changed to " + newURL);
			conn.close();
		}
		catch (SQLException err)
		{
			System.err.println("SQL error.");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
}