
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
function login1()
{
	var username=document.getElementById("username").value;
	var password=document.getElementById("password").value;
	var string;
	alert("login...");
	xhr=new XMLHttpRequest();
	var url="http://192.168.50.184:8090/SecureLogin?user="+username+"&pass="+password;
	xhr.open("GET",url,true);
	xhr.setRequestHeader("Content-type", "application/json");  alert(url);
	
	xhr.onreadystatechange=function()
	{
		if(xhr.readyState==4 && xhr.status==200)
		 { 
            //alert(xhr.responseText);
             document.getElementById("div11").style.display="none";
            document.getElementById("div12").innerHTML=xhr.responseText;
		 }
	}
	xhr.send();
}



</script>



</head>
<body>
 <div id="div11" style="height: 150px; width: 100%; background-color: gray;"><h1>SmarTek&nbsp;&nbsp;&nbsp;Consultency &nbsp;&nbsp;&nbsp;Service </h1>
              <br/><h4>Student&nbsp;&nbsp;&nbsp; Management &nbsp;&nbsp;&nbsp; System</h4></div> <br/>
	 
	 <table style="left: 30%">
	 <tr><td>Login Here</td></tr>
	 <tr> <td>User Id  </td><td> <input type="text" id="username" class="form-control"/>   </td></tr>
	 <tr> <td>Password </td><td> <input type="text" id="password" class="form-control"/>   </td></tr>
	 <tr> <td>  </td><td> <button onclick="login1() ">Login</button>  </td></tr>
	 </table>
	 
	 <p id="p1"></p>
	 
	 <div id="div12"></div>
	

</body>
</html>