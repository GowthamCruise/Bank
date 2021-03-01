<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@include file="employeeNavbar.jsp" %>
 <div class="mt-5 pt-5 container">
  <div class="row">
    <div class="offset-md-3 col-12 col-md-6">
     
      <P class="text-monospace text-center text-warning font-weight-bold h1">Add Money</P>
      <%

  String error=(String) request.getAttribute("error");
  if(error!=null){
	  out.print(error);
  }
  %>
      <form class="needs-validation" action="addMoney" method="post" novalidate>
        <div class="form-group">
          <label for="accountNumber">Account number:<span class="text-danger h4">*</span></label>
          <input type="text" class="form-control" id="accountNumber" pattern="^[0-9]{10}" placeholder="Enter Account number"  name="accountNumber" required>
          <div class="invalid-feedback">Please Enter valid Account Number.</div>
        </div>
        <div class="form-group">
          <label for="amount">Amount:<span class="text-danger">*</span></label>
          <input type="text" class="form-control" id="amount" pattern="^[0-9]*" placeholder="Enter Amount" name="amount" required>
          <div class="invalid-feedback">Please Enter valid Amount.</div>
        </div>
        <button class="btn btn-warning w-100 mt-3" type="submit">Add Money</button>
      </form>
    </div>
  </div>
</div>
<script>
var element = document.getElementById("nav4");
element.classList.add("active");
</script>