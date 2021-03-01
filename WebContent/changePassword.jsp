<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="navbar.jsp" %>

<%

  String error=(String) request.getAttribute("error");
  if(error!=null){
	  out.print(error);
  }
  %>
<!-- code start here -->
<div class="mt-5 pt-5 container">
  <div class="row">
    <div class="offset-md-3 col-12 col-md-6">
      <p class="text-center text-monospace">Change Password</p>
      
      <% 
      if(error!=null){    	  
      out.print(error);
      }
      %>
      <form action="changePassword" method="post" class="needs-validation" novalidate>
        <div class="form-group">
          <label for="password">Old Password</label>
          <input type="password" class="form-control" id="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
            placeholder="Enter old password" name="password" required>
          <div class="invalid-feedback">Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more character.</div>
        </div>

        <div class="form-group">
          <label for="newpassword">New Password:</label>
          <input type="password" class="form-control" id="newpassword" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
            placeholder="Enter New password" name="newpassword" required onkeyup='check();' >
          <div class="invalid-feedback">Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more character.</div>
        </div>

        <div class="form-group">
          <label for="confirmpassword">Confirm New Password:</label>
          <input type="password" class="form-control" id="confirmpassword"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
            placeholder="Confirm password" name="confirmpassword" onkeyup='check();' required>
          <span id='message'></span>
        </div>
        <button type="submit" class="btn btn-success w-100">Change Password</button>
      </form>
    </div>
  </div>
</div>
<script>
var element = document.getElementById("nav3");
element.classList.add("active");
  var check = function() {
  if (document.getElementById('newpassword').value ==
    document.getElementById('confirmpassword').value) {
    document.getElementById('message').style.color = 'green';
    document.getElementById('message').innerHTML = 'matching';
  } else {
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = 'New Password and confirm password must match';
  }
}
</script>