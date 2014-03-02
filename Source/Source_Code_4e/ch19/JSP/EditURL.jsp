<%@ page import="java.sql.*" %>
<html>
<title>Edit URL: Update new URL in a database</title>
<body>
<h2>Edit URL</h2>

<p>
This version of EditURL.jsp updates the URL field
of a Derby database to the submitted value for the
record with a matching Author ID.
</p>

<%
   String newURL = request.getParameter("URL");
   String stringID = request.getParameter("AuthorID");
   int author_id = Integer.parseInt(stringID);

   String driver = "org.apache.derby.jdbc.EmbeddedDriver";
   String protocol = "jdbc:derby:";
   try
   {
	Class.forName(driver).newInstance();
	out.println("Loaded the embedded driver.<br>");
   }
   catch (Exception err)
   {
	out.println("Unable to load the embedded driver.</body></html>");
	return;
   }
        
   String dbName = "BookDatabase";
   Connection conn = null;
   try
   {
	out.println("Connecting to and creating the database...<br />");
       	conn = DriverManager.getConnection(protocol + dbName + ";create=true");
	out.println("Connected.<br />");
		
	Statement s = conn.createStatement();
	s.execute("UPDATE names " +
	   "SET URL = '" + newURL + "' WHERE author_id = " + author_id);
	out.println("<br/><b>URL changed to " + newURL +
	   " for Author ID = " + author_id + "</b><br />");

	out.println("<br /><b>Displaying all records:</b><br />");
	ResultSet rs = null;
	rs = s.executeQuery("SELECT author, author_id, url FROM names");
	out.println("<ol>");
	while( rs.next() )
	{
	  int id = rs.getInt("author_id");
	  String author = rs.getString("author");
	  String url = rs.getString("url");
	  out.println("<li>ID = " + id + ", Author = "
	    + author + ", URL = " + url + "</li>");
	}
	out.println("</ol>");
	rs.close();
			
	conn.close();
   }
   catch (Exception err)
   {
	out.println("SQL error.<br />");
   }   
%>
</body>
</html>