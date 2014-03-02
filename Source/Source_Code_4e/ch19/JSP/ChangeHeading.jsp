<html>
<title>
Displaying Heading Tags with JSP
</title>

<body>
<%!
   private static final int LASTLEVEL = 6;
%>

<p>
This page usess JSP to display Heading Tags from
Level 1 to Level <%= LASTLEVEL %>
</p>

<%
    int i;
    for (i = 1; i <= LASTLEVEL; i++)
    {
    	out.println("<H" + i + ">" +
    	  "This text is in Heading Level " + i +
    	  "</H" + i + ">");
    }
    out.println("woo1");
    if (1 == 1) return;
%>
woo3<br/>
<%
out.println("woo4");
%>

</body>
</html>
