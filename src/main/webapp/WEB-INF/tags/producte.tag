<%-- 
    Document   : etiqueta
    Created on : 26/01/2012, 16:07:32
    Author     : sergi
--%>

<%@tag  body-content="empty"%>
<%-- The list of normal or fragment attributes can be specified here: --%>
<%@ attribute name="uno" required="true"%>
<%@ attribute name="dos" required="true"%>
<h1>
${uno * dos}
</h1>



