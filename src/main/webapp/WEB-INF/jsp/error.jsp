<%@ page isErrorPage="true" %>
S'ha produït l'error <i><%= exception %></i>.
<pre>
<%@ page import="java.io.*" %>
<% exception.printStackTrace(new PrintWriter(out)); %>
</pre>
</body>