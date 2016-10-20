
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
//bind the on-change event for the input element (triggered when a file
// is chosen)
/* $(document).ready(function() {
	 alert("clicked...");
  /* $("#upload-file-input").on("change", uploadFile); */
/**
 * Upload the file sending it via Ajax at the Spring Boot server.
 */
/*  $("file-upload").click(
				 
 );
});
 */
 function uploadFile1() {
	 alert("clicked...");
	  $.ajax({
	    url: "http://192.168.50.100:8080/emp/uploadFile",
	    type: "POST",
	    data: new FormData($("#upload-file-form")[0]),
	    enctype: 'multipart/form-data',
	    processData: false,
	    contentType: false,
	    cache: false,
	    success: function (response, status, xhr) {
	      // Handle upload success
	      $("#upload-file-message").text("File succesfully uploaded");
	    },
	    error: function (response, status, xhr) {
	    	alert(xhr.status + ": " + xhr.statusText);
	      // Handle upload error
	      $("#upload-file-message").text(
	          "File not uploaded (perhaps it's too much big)");
	    }
	  });
	}
 function uploadFile() {
	 alert("123");
	 var boundary = this.generateBoundary();
	 var formData = new FormData();
	 formData.append("myFile", document.getElementById("upload-file-input").files[0]);
	    var xhr = new XMLHttpRequest;
	    xhr.open("POST", "http://192.168.50.100:8080/emp/uploadFile", true);
	    var contentType = "multipart/form-data; boundary=" + boundary;
	    xhr.setRequestHeader("Content-Type", contentType);
	    xhr.onreadystatechange = function() {
	        if (xhr.readyState === 4) {
	        	 alert("123456");
	            alert(xhr.responseText);
	        }
	    };
	    var data = this.buildMessage(formData, boundary);
	    
	    xhr.send(formData);
	}
// function uploadFile
</script>
</head>
<body>
	<form id="upload-file-form">
		<label for="upload-file-input">Upload your file:</label> <input
			id="upload-file-input" type="file" name="uploadfile" accept="*" /> <br />
		<span id="upload-file-message"></span>
		<button id="file-upload" onclick="uploadFile()">Upload</button>
	</form>
</body>
</html>