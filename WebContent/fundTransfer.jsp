<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="navbar.jsp" %>
<div class="mt-5 pt-5 container">
  <div class="row">
    <div class="offset-md-3 col-12 col-md-6">
      <p class="text-center text-monospace text-black-50">Enter recivers details</p>
            <%

  String error=(String) request.getAttribute("error");
  if(error!=null){
	  out.print(error);
  }
  %>
      <form action="FundTransfer" method="post" class="needs-validation" novalidate>
        <div class="form-group">
          <label for="ifsc">IFSC number:</label>
          <input type="text" class="form-control" id="ifsc" placeholder="Enter IFSC number" name="ifsc" required>
          <div class="invalid-feedback">Please Enter valid IFSC code.</div>
        </div>

        <div class="form-group">
          <label for="anum">Account number:</label>
          <input type="text" class="form-control" pattern="^[0-9]{10}" id="anum" placeholder="Enter Account number"
            name="anum" required>
          <div class="invalid-feedback">Please Enter valid account number.</div>
        </div>

        <div class="form-group">
          <label for="amount">Amount:</label>
          <input type="text" class="form-control" pattern="^[0-9]*" id="amount" placeholder="Enter Amount" name="amount"
            required>
          <div class="invalid-feedback">Please valid Amount.</div>
        </div>

        <div class="form-group">
          <label for="tpin">Transaction pin:</label>
          <input type="password" class="form-control" id="tpin" pattern="^[0-9]{5}"
            placeholder="Enter Transaction password" name="tpin" required>
          <div class="invalid-feedback">Please Enter valid Tpin.</div>
        </div>
        <button type="submit" class="btn btn-success w-100">Transfer</button>
      </form>
    </div>
  </div>
</div>
<script>
var element = document.getElementById("nav2");
element.classList.add("active");
</script>