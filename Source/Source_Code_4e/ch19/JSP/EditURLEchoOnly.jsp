<html>
<title>Edit URL: Echo submitted values</title>
<body>
<h2>Edit URL</h2>

<p>
This version of EditURL.jsp simply echoes back to the
user the values that were entered in the textboxes.
</p>

<%
   String url = request.getParameter("URL");
   String stringID = request.getParameter("AuthorID");
   int author_id = Integer.parseInt(stringID);
   out.println("The submitted author ID is: " + author_id);
   out.println("<br/>");
   out.println("The submitted URL is: " + url);
%>
</body>
</html>