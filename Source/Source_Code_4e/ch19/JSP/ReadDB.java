import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDB
{
	private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String protocol = "jdbc:derby:";

	/*
	 Outputs the author, ID, and URL of the current
	 author in the ResultSet
	*/
	public static void displayNameRecord(ResultSet rs) throws SQLException
	{
		int id = rs.getInt("author_id");
		String author = rs.getString("author");
		String url = rs.getString("url");
		System.out.println("ID = " + id + ", Author = "
				+ author + ", URL = " + url);
	}

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

			Statement s = conn.createStatement();

			ResultSet rs = null;
			System.out.println("All records:");
			rs = s.executeQuery("SELECT author, author_id, url FROM names");
			while( rs.next() )
			{
				displayNameRecord(rs);
			}
			rs.close();

			System.out.println();
			System.out.println("All records with an ID > 1:");
			rs = s.executeQuery("SELECT author, author_id, url " +
					"FROM names WHERE author_id > 1");
			while( rs.next() )
			{
				displayNameRecord(rs);
			}
			rs.close();
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