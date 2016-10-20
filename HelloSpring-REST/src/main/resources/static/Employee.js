
function dateGenerator(){
	$('#dob').datepicker({
		changeMonth: true,
        changeYear: true,
        yearRange: "-100:+0",
		dateFormat: "yy-mm-dd"		
	});
}

function selectPage() {
	var select = "<div id='myDiv'><body><table class='table table-bordered'><tr><td>Employeee Id</td><td><input type='text' class='form-control' name='empid' id='empid' required></td></tr><tr><td></td><td><button class='btn btn-default' onclick='getEmployeeById()'>Get Employee</button></td></tr></table></body></div><p id='header'></p>";
	document.getElementById("para1").innerHTML = select;
}

function isValidateForm() {
	var empid = document.getElementById("id").value;
	var fname = document.getElementById("fname").value;
	var lname = document.getElementById("lname").value;
	var dob = document.getElementById("dob").value;
	var address = document.getElementById("address").value;
	var mobile = document.getElementById("mobile").value;
	if (empid == null || empid == "") {
		alert("Employee Id must be filled out");
		return false;
	}
	if (isNaN(empid)) {
		alert("Employee Id must be numeric");
		return false;
	}
	if (fname == null || fname == "") {
		alert("First Name must be filled out");
		return false;
	}
	if (lname == null || lname == "") {
		alert("Last Name must be filled out");
		return false;
	}
	if (dob == null || dob == "") {
		alert("DOB must be filled out");
		return false;
	}
	if (address == null || address == "") {
		alert("Address must be filled out");
		return false;
	}
	if (mobile == null || mobile == "") {
		alert("Mobile No must be filled out");
		return false;
	}
	if (isNaN(mobile)) {
		alert("Mobile No must be numeric");
		return false;
	}
	if (mobile.length != 10) {
		alert("Mobile no must be 10 digit only");
		return false;
	}
	return true;
}

function getEmployeeById() {
	var x = document.getElementById("empid").value;
	if (x == null || x == "")
		alert("Employee Id must be filled out");
	else if (isNaN(x))
		alert("Employee Id must be numeric");
	else {
		var emp;
		var string;
		xhr = new XMLHttpRequest();
		var url = "http://192.168.50.100:8080/emp/"
			+ document.getElementById("empid").value;
		xhr.open("GET", url, true);
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 0)
				document.getElementById("header").innerHTML = "Server is Down Please try After sometime";
			if (xhr.readyState == 4 && xhr.status == 404)
				document.getElementById("header").innerHTML = "Employee Not Exist";
			if (xhr.readyState == 4 && xhr.status == 200) {
				emp = JSON.parse(xhr.responseText);
				string = "<table class='table table-bordered'><tr><td>Emp ID</td><td>"
					+ emp.empid
					+ "</td></tr><tr><td>First Name</td><td>"
					+ emp.fname
					+ "</td></tr><tr><td>Last Name</td><td>"
					+ emp.lname
					+ "</td></tr><tr><td>Dob</td><td>"
					+ emp.dob
					+ "</td></tr><tr><td>Address</td><td>"
					+ emp.address
					+ "</td></tr><tr><td>Mobile</td><td>"
					+ emp.mobile + "</td></tr></table>";
				document.getElementById("header").innerHTML = string;
			}
		}
		xhr.send();
	}
}

function deletePage() {
	var select = "<div id='myDiv'><body><table class='table table-bordered'><tr><td>Employeee Id</td><td><input type='text' class='form-control' name='empid' id='empid'></td></tr><tr><td></td><td><button class='btn btn-default' onclick='deleteEmployeeById()'>Delete Employee</button></td></tr></table></body></div><p id='header'></p><br><p id='header2'></p>";
	document.getElementById("para1").innerHTML = select;
}

function deleteEmployeeById() {
	var x = document.getElementById("empid").value;
	if (x == null || x == "")
		alert("Employee Id must be filled out");
	else if (isNaN(x))
		alert("Employee Id must be numeric");
	else {
		var chk = confirm("Do you want to delete record?");
		if (chk == true) {
			var emp;
			xhr = new XMLHttpRequest();
			var url = "http://192.168.50.100:8080/emp/"
				+ document.getElementById("empid").value;
			xhr.open("DELETE", url, true);
			xhr.setRequestHeader("Content-type", "application/json");
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 0)
					document.getElementById("header").innerHTML = "Server is Down Please try After sometime";
				if (xhr.readyState == 4 && xhr.status == 404) {
					document.getElementById("header").innerHTML = "Employee Not Exist";
					document.getElementById("header2").innerHTML = "";
				}
				if (xhr.readyState == 4 && xhr.status == 200) {
					emp = JSON.parse(xhr.responseText);
					/* if (emp.empid == 0)
							document.getElementById("header2").innerHTML = "Employee Not Exist";
						else { */
					string = "<table class='table table-bordered'><tr><td>Emp ID</td><td>"
						+ emp.empid
						+ "</td></tr><tr><td>First Name</td><td>"
						+ emp.fname
						+ "</td></tr><tr><td>Last Name</td><td>"
						+ emp.lname
						+ "</td></tr><tr><td>Dob</td><td>"
						+ emp.dob
						+ "</td></tr><tr><td>Address</td><td>"
						+ emp.address
						+ "</td></tr><tr><td>Mobile</td><td>"
						+ emp.mobile + "</td></tr></table><br><p id='header'></p>";
					document.getElementById("para1").innerHTML = string;
					document.getElementById("header").innerHTML = "Empployee deleted";
				}
				/* } */
			}
			xhr.send();
		}

	}
}
function insertPage() {
	var select = "<div id='myDiv'><body><table class='table table-bordered'><tr><td>Emp Id</td><td><input type='text' class='form-control' name='empid' id='id' ></td> </tr>"
		+ "<tr><td>First Name</td><td><input type='text' class='form-control' name='fname' id='fname'></td> </tr><tr><td>Last Name</td><td><input type='text' class='form-control' name='lname' id='lname'></td> </tr>"
		+ "<tr><td>DOB</td><td><input class='form-control' name='dob' id='dob' readonly></td> </tr>"
		+ "<tr><td>Address</td><td><input type='text' class='form-control' name='address' id='address'></td> </tr>"
		+ "<tr><td>Mobile</td><td><input type='text' class='form-control' name='mobile' id='mobile'></td> </tr>"
		+ "<tr><td></td><td><button class='btn btn-default' onclick='addEmployee()'>Add Employee</button></td></tr></table></div><p id='header'></p>";
	document.getElementById("para1").innerHTML = select;
	dateGenerator();
}

function addEmployee() {
	if (isValidateForm()) {
		xhr = new XMLHttpRequest();
		var url = "http://192.168.50.100:8080/emp";
		xhr.open("POST", url, true);
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 0)
				document.getElementById("header").innerHTML = "Server is Down Please try After sometime";
			if (xhr.readyState == 4 && xhr.status == 200) {
				document.getElementById("para1").innerHTML = "Empployee Inserted";
			}
		}

		var data = JSON.stringify({
			"empid" : document.getElementById("id").value,
			"fname" : document.getElementById("fname").value,
			"lname" : document.getElementById("lname").value,
			"dob" : document.getElementById("dob").value,
			"address" : document.getElementById("address").value,
			"mobile" : document.getElementById("mobile").value
		});
		xhr.send(data);
	}
}

function selectAllPage() {
	var emp;
	var string = "<table class='table table-bordered'><thead><tr><th>Employee Id</th><th>First Name</th><th>Last Name</th><th>DOB</th><th>Address</th><th>Mobile</th></tr></thead><tbody>";
	xhr = new XMLHttpRequest();
	var url = "http://192.168.50.100:8080/emps";
	xhr.open("GET", url, true);
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 0)
			document.getElementById("para1").innerHTML = "Server is Down Please try After sometime";
		if (xhr.readyState == 4 && xhr.status == 200) {
			emp = JSON.parse(xhr.responseText);
			/* alert(emp[3].fname); */

			for (var i = 0; i < emp.length; i++) {
				string = string + "<tr><td>" + emp[i].empid + "</td><td>"
				+ emp[i].fname + "</td><td>" + emp[i].lname
				+ "</td><td>" + emp[i].dob + "</td><td>"
				+ emp[i].address + "</td><td>" + emp[i].mobile
				+ "</td> </tr>";
			}
			string = string + "</tbody></table>";
			document.getElementById("para1").innerHTML = string;

		}
	}
	xhr.send();
}

function updatePage() {
	var select = "<div id='myDiv'><body><table class='table table-bordered'><tr><td>Employeee Id</td><td><input type='text' class='form-control' name='empid' id='empid'></td></tr><tr><td></td><td><button class='btn btn-default' onclick='getEmployeeByIdForUpdate()'>Get Employee For Update</button></td></tr></table></body></div><p id='header'></p>";
	document.getElementById("para1").innerHTML = select;
}

function getEmployeeByIdForUpdate() {
	var x = document.getElementById("empid").value;
	if (x == null || x == "")
		alert("Employee Id must be filled out");
	else if (isNaN(x))
		alert("Employee Id must be numeric");
	else {
		var emp;
		var string = "";
		xhr = new XMLHttpRequest();
		var url = "http://192.168.50.100:8080/emp/"
			+ document.getElementById("empid").value;
		xhr.open("GET", url, true);

		xhr.setRequestHeader("Content-type", "application/json");
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 0)
				document.getElementById("header").innerHTML = "Server is Down Please try After sometime";
			if (xhr.readyState == 4 && xhr.status == 404)
				document.getElementById("header").innerHTML = "Employee Not Exist";
			if (xhr.readyState == 4 && xhr.status == 200) {
				emp = JSON.parse(xhr.responseText);
				string = "<div id='myDiv'><body><table class='table table-bordered'><tr><td>Emp Id</td><td><input type='text' class='form-control' readonly name='empid' id='id' ></td> </tr>"
					+ "<tr><td>First Name</td><td><input type='text' class='form-control' name='fname' id='fname'></td> </tr><tr><td>Last Name</td><td><input type='text' class='form-control' name='lname' id='lname'></td> </tr>"
					+ "<tr><td>DOB</td><td><input class='form-control' name='dob' id='dob' readonly></td> </tr>"
					+ "<tr><td>Address</td><td><input type='text' class='form-control' name='address' id='address'></td> </tr>"
					+ "<tr><td>Mobile</td><td><input type='text' class='form-control' name='mobile' id='mobile'></td> </tr>"
					+ "<tr><td></td><td><button class='btn btn-default' onclick='UpdateEmployee()'>Update Employee Employee</button></td></tr></table></div></p>";
				document.getElementById("header").innerHTML = string;
				dateGenerator();
				document.getElementById("id").value = emp.empid;
				document.getElementById("fname").value = emp.fname;
				document.getElementById("lname").value = emp.lname;
				document.getElementById("dob").value = emp.dob;
				document.getElementById("address").value = emp.address;
				document.getElementById("mobile").value = emp.mobile;
			}
		}

		//alert(string);
		xhr.send();
	}
}

function UpdateEmployee() {
	if (isValidateForm()) {
		xhr = new XMLHttpRequest();
		var url = "http://192.168.50.100:8080/emp/"
			+ document.getElementById("empid").value;
		xhr.open("PUT", url, true);
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 0)
				document.getElementById("header").innerHTML = "Server is Down Please try After sometime";
			if (xhr.readyState == 4 && xhr.status == 200) {
				/* var json = JSON.parse(xhr.responseText);
					console.log(json.email + ", " + json.password) */
				document.getElementById("header").innerHTML = "Empployee Updated";
			}
		}
		var data = JSON.stringify({
			"empid" : document.getElementById("id").value,
			"fname" : document.getElementById("fname").value,
			"lname" : document.getElementById("lname").value,
			"dob" : document.getElementById("dob").value,
			"address" : document.getElementById("address").value,
			"mobile" : document.getElementById("mobile").value
		});
		xhr.send(data);
	}
}