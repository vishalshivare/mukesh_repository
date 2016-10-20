<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">

/* function uploadPage() {
    var select = "<div><body><h2>File Upload Example</h2><form id='form2' method='post' action='upload' enctype='multipart/form-data'>"
                 + "Select a file : <input name='file' id='file' type='file' size='45'/><br/><input type='submit' value='Upload File' name='submit'/></form>"
                 + "<div id='result'></div></body></div><h1 id='p2'></h1>";
    document.getElementById("p1").innerHTML = select;
}  */


</script>


<body>

<!-- Upload file form -->
<form action="upload" method="POST" enctype="multipart/form-data" >
 Select a file :   <input type="file" id="file" name="file" accept="image/*">
                   <input type="submit">
</form>
</body>
</html>



