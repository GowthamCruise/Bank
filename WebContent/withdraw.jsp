<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="employeeNavbar.jsp" %>
<div class="mt-5 pt-5 container">
  <div class="row">
    <div class="offset-md-3 col-12 col-md-6">
      <P class="text-monospace text-center text-warning font-weight-bold h1">withdraw Money</P>
      <%

  String error=(String) request.getAttribute("error");
  if(error!=null){
	  out.print(error);
  }
  %>
      <form class="needs-validation" action="withdraw" method="post" novalidate>
        <div class="form-group">
          <label for="ifsc">Account number:</label>
          <input type="text" class="form-control" id="accountNumber" placeholder="Enter Account number" name="accountNumber" required>
          <div class="invalid-feedback">Please Enter valid Account Number.</div>
        </div>
        <div class="form-group">
          <label for="ifsc">Amount:</label>
          <input type="text" class="form-control" id="amount" placeholder="Enter Amount" name="amount" required>
          <div class="invalid-feedback">Please Enter valid Amount.</div>
        </div>
        <button class="btn btn-warning w-100 mt-3" type="submit">Withdraw Money</button>
      </form>
    </div>
  </div>
</div>
<script>
var element = document.getElementById("nav3");
element.classList.add("active");
</script>