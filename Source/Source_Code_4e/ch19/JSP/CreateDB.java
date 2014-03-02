import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB
{
	private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String protocol = "jdbc:derby:";

	public static void main(String[] args)
	{
		// First load the embedded driver
		try
		{
			Class.forName(driver).newInstance();
			System.out.println("Loaded the embedded driver.");
		}
		catch (Exception err)  // Must catch ClassNotFoundException, InstantiationException, IllegalAccessException
		{
			System.err.println("Unable to load the embedded driver.");
			err.printStackTrace(System.err);
			System.exit(0);
        }

        // Create a new database and connect to it
        // In the connection string we could also supply a username and password
        // if applicable by adding "user=username;password=dbuserpwd".
        // This will create a folder named "BookDatabase" in the
        // program's directory that contains the database files
        String dbName = "BookDatabase";
        Connection conn = null;
        try
        {
			System.out.println("Connecting to and creating the database...");
        	conn = DriverManager.getConnection(protocol + dbName + ";create=true");
			System.out.println("Database created.");

			// Create a statement object for running SQL statements
			Statement s = conn.createStatement();

			// Create a table named "names" with three fields.
			// One is for author, which holds a string up to 50 characters.
			// author_id is a numeric ID number for each author.
			// url is a varchar, which is a String that holds 80 characters
			s.execute("CREATE TABLE names" +
					  "(author varchar(50), author_id int, url varchar(80))");
			System.out.println("Created 'names' table.");

			// Add some sample data.  Would be more efficient to use prepareStatement
			// but leave off for simplicity
			System.out.println("Inserting authors.");
			s.execute("INSERT INTO names " +
				"VALUES ('Adams, Douglas', 1, 'http://www.douglasadams.com')");
			s.execute("INSERT INTO names " +
				"VALUES ('Simmons, Dan', 2, 'http://www.dansimmons.com')");
			s.execute("INSERT INTO names " +
				"VALUES ('Stephenson, Neal', 3, 'http://www.nealstephenson.com')");

			System.out.println("Authors inserted.");

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