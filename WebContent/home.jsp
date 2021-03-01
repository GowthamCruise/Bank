<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="navbar.jsp" %>
    <%
  	String cif=(String) session.getAttribute("cif");
    String name=(String) session.getAttribute("name");
    String fatherName=(String) session.getAttribute("fatherName");
    String accountType=(String) session.getAttribute("accountType");
    String aadhaarNumber=(String) session.getAttribute("aadhaarNumber");
    String accountNumber=(String) session.getAttribute("accountNumber");
    String balance=(String) session.getAttribute("balance");
    String email=(String) session.getAttribute("email");
    String phone=(String) session.getAttribute("phone");
    String IFSCCode =(String) session.getAttribute("IFSCCode");
    String PANNumber=(String) session.getAttribute("PANNumber");
  %>
<div class="mt-5 pt-5 container">
  <div class="row">
    <div class="col-12 col-md-6 mb-4">
      <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" class="form-control" value="<%out.print(name);%>" disabled placeholder="Name" id="name" />
      </div>
      <br>
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="text" class="form-control" disabled placeholder="Email"  value="<%out.print(email);%>" id="Email" />
      </div>
      <br>
      <div class="form-group">
        <label for="anum">Aadhaar number:</label>
        <input type="text" class="form-control" disabled placeholder="Aadhaar number" id="anum"  value="<%out.print(aadhaarNumber);%>" />
      </div>
      <br>
      <div class="form-group">
        <label for="ifsc">IFSC code:</label>
        <input type="text" class="form-control" disabled placeholder="IFSC code" id="ifsc"  value="<%out.print(IFSCCode);%>" />
      </div>
      <br>
      <div class="form-group">
        <label for="Balance">Balance:</label>
        <input type="text" class="form-control" disabled placeholder="Balance" id="Balance"  value="<%out.print(balance);%>" />
      </div>
      <br>
      <div class="form-group">
        <label for="Pannum">PAN number:</label>
        <input type="text" class="form-control" disabled placeholder="PAN number" id="Pannum"   value="<%out.print(PANNumber);%>"/>
      </div>
    </div>
    <div class="col-12 col-md-6">
      <div class="form-group">
        <label for="fname">Father Name:</label>
        <input type="text" class="form-control" disabled placeholder="Father Name" id="fname"  value="<%out.print(fatherName);%>" />
      </div>
      <br>
      <div class="form-group">
        <label for="pnum">Phone Number:</label>
        <input type="text" class="form-control" disabled placeholder="Phone number" id="pnum"  value="<%out.print(phone);%>" />
      </div>
      <br>
      <div class="form-group">
        <label for="cif">CIF:</label>
        <input type="text" class="form-control" value=" <%out.print(cif);%> " disabled placeholder="CIF" id="cif"  />
      </div>
      <br>
      <div class="form-group">
        <label for="accountnum">Account number:</label>
        <input type="text" class="form-control" disabled placeholder="Account number" id="accountnum"  value="<%out.print(accountNumber);%>" />
      </div>
      <br>
      <div class="form-group">
        <label for="accounttype">Account type:</label>
        <input type="text" class="form-control" disabled placeholder="Account type" id="accounttype"  value="<%out.print(accountType);%>" />
      </div>
    </div>
  </div>
</div>
<script>
var element = document.getElementById("nav1");
element.classList.add("active");
</script>