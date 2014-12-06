<%@ page language="java" import="java.util.*" 
	import ="org.openhmis.vo.*,
			java.util.*,
			javax.ws.rs.core.MediaType,
			javax.xml.bind.JAXBElement,			
			com.sun.jersey.api.client.*"
pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>Open HMIS Client</title>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
  </head>
<%
	String todo = request.getParameter("todo") == null ? "":request.getParameter("todo");
	String key = request.getParameter("key") == null ? "0":request.getParameter("key");
	String name = request.getParameter("name") == null ? "1":request.getParameter("name");	
	String eth_key = request.getParameter("eth_key") == null ? "":request.getParameter("eth_key");
	String gen_key = request.getParameter("gen_key") == null ? "":request.getParameter("gen_key");
	String rac_key = request.getParameter("rac_key") == null ? "":request.getParameter("rac_key");
	String description = request.getParameter("description") == null ? "1":request.getParameter("description");
	String active = request.getParameter("active") == null ? "":request.getParameter("active");
	String ethnicity = request.getParameter("ethnicity") == null ? "":request.getParameter("ethnicity");
	String gender = request.getParameter("gender") == null ? "":request.getParameter("gender");
	String middleInitial = request.getParameter("middleInitial") == null ? "":request.getParameter("middleInitial");
	String ssn = request.getParameter("ssn") == null ? "":request.getParameter("ssn");
	String dob = request.getParameter("dob") == null ? "":request.getParameter("dob");
	String firstName = request.getParameter("firstName") == null ? "":request.getParameter("firstName");
	String lastName = request.getParameter("lastName") == null ? "":request.getParameter("lastName");
	String veteranStatus = request.getParameter("veteranStatus") == null ? "":request.getParameter("veteranStatus");
	String disablingCondition = request.getParameter("disablingCondition") == null ? "":request.getParameter("disablingCondition");

	Client c = null;
	WebResource r = null;	
	ClientResponse resp =null;
	String content ="";

	if ("cbk".equals(todo)){
		//response.sendRedirect("/HMIS-API/services/clients/client/" + key);
		c = Client.create();
		r = c.resource("http://108.59.80.159:8080/HMIS-API/services/clients/client/");
		//resp = r.path(key).);
		content = r.path(key).get(String.class);

	} else if ("cbn".equals(todo))
		response.sendRedirect("/HMIS-API/services/clients/lastName/" + name);
	else if ("ae".equals(todo)){
		c = Client.create();
        	r = c.resource("http://108.59.80.159:8080/HMIS-API/services/ethnicities/addEthnicity");
        	EthnicityVO vo = new EthnicityVO(eth_key,description,active);
        	resp = r.path("").accept(MediaType.APPLICATION_XML).post(ClientResponse.class, vo);
	} else if ("ag".equals(todo)){
                c = Client.create();
                r = c.resource("http://108.59.80.159:8080/HMIS-API/services/genders/addGender");
                GenderVO vo = new GenderVO(gen_key,description,active);
                resp = r.path("").accept(MediaType.APPLICATION_XML).post(ClientResponse.class, vo);
	} else if ("ar".equals(todo)){
                c = Client.create();
               	r = c.resource("http://108.59.80.159:8080/HMIS-API/services/races/addRace");
                RaceVO vo = new RaceVO(rac_key,description,active);
                resp = r.path("").accept(MediaType.APPLICATION_XML).post(ClientResponse.class, vo);

  	} else if ("acl".equals(todo)){
		c = Client.create();
        	r = c.resource("http://108.59.80.159:8080/HMIS-API/services/clients/addClient");
        	EthnicityVO evo = new EthnicityVO("C","Caucasian","Y");
        	GenderVO gvo = new GenderVO("M","Male","Y");
        	RaceVO[] races = {new RaceVO("C"," Caucasian","Y")};
        	ClientVO vo = new ClientVO(0,firstName,lastName,middleInitial,ssn,dob,veteranStatus,disablingCondition);
        	vo.setEthnicityVO(evo);
        	vo.setGenderVO(gvo);
        	vo.setRacesVO(Arrays.asList(races));
        	resp = r.path("").accept(MediaType.APPLICATION_XML).post(ClientResponse.class, vo);
  	}
	if(resp != null)
		out.println("<hr>Webservice response: " + resp.getStatus() + "<hr><br>");
	else
		out.println("<hr>Webservice response: <br><pre>" + content + "</pre><hr><br>");
%>


  <body>
 Use Browser Back Button to come back to: <%= basePath %><br>
    Client Menu <br>
    <ul>
    	<li>Clients
    		<ul>
    			<li>by key
    			<form action="index.jsp">
    			Enter Key:<input type='text' name='key' value="2"><input type='submit' name='Enter'>
    			<input type='hidden' name='todo' value='cbk'>	
    			</form>
    			</li>
    			<li>By Last Name:
    			<form action="index.jsp">
    			Enter Last Name:<input type='text' name='name'><input type='submit' name='Enter'>
    			<input type='hidden' name='todo' value='cbn'>	
    			</form>	
    		 	</li>		
    			<li>add new client
    			<form action="index.jsp">
			<table>
  			<tr><td>Ethnicity:</td><td>Caucasian is the only available ethnicity</td></tr>
                        <tr><td>Gender:</td><td>Male is the only available gender</td></tr>
                        <tr><td>First Name:</td><td><input type='text' name='firstName'> (Max String length:45)</td></tr>
			<tr><td>Middle Initial:</td><td><input type='text' name='middleInitial'></td></tr>
                        <tr><td>Last Name:</td><td><input type='text' name='lastName'> (Max String length:45)</td></tr>
                        <tr><td>SSN:</td><td><input type='text' name='ssn'> (format: 016664518)</td></tr>
                        <tr><td>DOB:</td><td><input type='text' name='dob'> (format: MMDDYYYY ie 10121962 for Oct 12 1962)</td></tr>
                        <tr><td>Veteran Status:</td><td><input type='text' name='veteranStatus'> (Max String length:45)</td></tr>
                        <tr><td>Disabling Condition:</td><td><input type='text' name='disablingCondition'> (Max String length:45)</td></tr>
			</table>
                        <input type='hidden' name='todo' value='acl'><input type='submit' value='Enter'>
			</form>
    			</li>
    			
    		</ul>
    	</li>
    	<li>
    		Ethnicity
    		<ul>
    			<li><a href='/HMIS-API/services/ethnicities'>List all</a></li>
    			<li>Add new Ethnicity 
    				<form action="index.jsp">
    			Ethnicity Key (string < 20 ):<input type='text' name='eth_key'>
    			Description (string <255 ):<input type='text' name='description'>
    			Active (string < 20 ):<input type='text' name='active'>
    			<input type='hidden' name='todo' value='ae'><input type='submit' value='Enter'>	
    			</form>
    			</li>	
    		</ul>
    	</li>
    	<li>
    		Gender
    		<ul>
    			<li><a href='/HMIS-API/services/genders'>List all</a></li>
    			<li>Add new gender 
    				<form action="index.jsp">
    			Gender Key (string < 20 ):<input type='text' name='gen_key'>
    			Description (string <255 ):<input type='text' name='description'>
    			Active (string < 20 ):<input type='text' name='active'>
    			<input type='hidden' name='todo' value='ag'><input type='submit' value='Enter'>	
    			</form>
    			</li>	
    		</ul>
    	</li>	
	<li>
                Race
                <ul>
                        <li><a href='/HMIS-API/services/races'>List all</a></li>
                </ul>
        </li>


    </ul>
  </body>
</html>

