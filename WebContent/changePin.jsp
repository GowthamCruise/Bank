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
      <p class="text-center text-monospace">Change Transaction pin</p>
      <% 
      if(error!=null){    	  
      out.print(error);
      }
      %>
      <form action="ChangePin" method="post" class="needs-validation" novalidate>

        <div class="form-group">
          <label for="oldpin">Old Transaction Pin</label>
          <input type="password" class="form-control" id="oldpin" placeholder="Enter old Transaction pin" name="oldpin"
            required pattern="^[0-9]{5}" >
          <div class="invalid-feedback">Please Enter valid Transaction pin.</div>
        </div>

        <div class="form-group">
          <label for="newpin">New Transaction Pin:</label>
          <input type="password" onkeyup='check();' class="form-control" id="newpin" placeholder="Enter New Transaction pin" name="newpin"
            required pattern="^[0-9]{5}" >
          <div class="invalid-feedback">Please Enter valid Transaction pin.</div>
        </div>

        <div class="form-group">
          <label for="confirmpin">Conform New Pin:</label>
          <input type="password" onkeyup='check();' class="form-control" pattern="^[0-9]{5}" id="confirmpin" placeholder="Conform pin" name="confirmpin" required>
          <span id='message'></span>
        </div>
        <button type="submit" class="btn btn-outline-secondary w-100">Change Transaction Pin</button>
      </form>
    </div>
  </div>
</div>
<script>
var element = document.getElementById("nav4");
element.classList.add("active");
  var check = function() {
  if (document.getElementById('newpin').value ==
    document.getElementById('confirmpin').value) {
    document.getElementById('message').style.color = 'green';
    document.getElementById('message').innerHTML = 'matching';
  } else {
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = 'New Pin and confirm pin must match';
  }
}
</script>