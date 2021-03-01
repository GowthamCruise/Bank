<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="employeeNavbar.jsp" %>
<div class="mt-5 pt-5 container">
  <P class="text-monospace text-center text-warning font-weight-bold h1">Create Account</P>
  <%

  String error=(String) request.getAttribute("error");
  if(error!=null){
	  out.print(error);
  }
  %>
  <form action="createAccount" method="post" class="needs-validation" novalidate>
    <div class="form-row">
      
      <div class="col-12 col-lg-6 pl-3 pr-5">
        <div class="form-group">
          <label class="text-warning font-weight-bold" for="Name">Full Name:</label><span class="text-danger">*</span>
          <input type="text" class="form-control text-warning font-weight-bolder" id="name" name="name" required>
          <div class="invalid-feedback">Please Enter Name.</div>
        </div>
      </div>

      <div class="col-12 col-lg-6 pl-3 pr-5">
        <div class="form-group">
          <label class="text-warning font-weight-bold" for="Fname">Father Name:<span class="text-danger">*</span></label>
          <input type="text" class="form-control text-warning font-weight-bolder" id="fatherName" name="fatherName"
            required>
          <div class="invalid-feedback">Please Enter Father Name.</div>
        </div>
      </div>

      <div class="col-12 col-lg-6 pl-3 pr-5">
        <div class="form-group">
          <label class="text-warning font-weight-bold">Email:<span class="text-danger">*</span></label>
          <input type="email" class="form-control text-warning font-weight-bolder" id="email" name="email" required>
          <div class="invalid-feedback">Please Enter Valid Email.</div>
        </div>
      </div>

      <div class="col-12 col-lg-6 pl-3 pr-5">
        <div class="form-group">
          <label class="text-warning font-weight-bold">Phone:<span class="text-danger">*</span></label>
          <input type="text" class="form-control text-warning font-weight-bolder" pattern="^[0-9]{10}" id="Phone"
            name="phone" required>
          <div class="invalid-feedback">Please Enter Valid phone number without country code.</div>
        </div>
      </div>

      <div class="col-12 col-lg-6 pl-3 pr-5">
        <div class="form-group">
          <label class="text-warning font-weight-bold">Aadhaar Number:<span class="text-danger">*</span></label>
          <input type="text" pattern="^[0-9]{12}" class="form-control text-warning font-weight-bolder"
            id="aadhaarNumber" name="aadhaarNumber" required>
          <div class="invalid-feedback">Please Enter Valid Aadhaar number.</div>
        </div>
      </div>

      <div class="col-12 col-lg-6 pl-3 pr-5">
        <div class="form-group">
          <label class="text-warning font-weight-bold">PAN Number:</label>
          <input type="text" class="form-control text-warning font-weight-bolder" id="panNumber" name="panNumber">
        </div>
      </div>

      <div class="col-12 col-lg-6 pl-3 pr-5">
        <div class="form-group">
          <label class="text-warning font-weight-bold">Account Type:<span class="text-danger">*</span></label>
          <select class="form-control text-warning font-weight-bolder" name="accountType" id="accountType" required>
           <option value="">Select account Type</option>
            <option value="saving">Savings Account</option>
            <option value="current">Current Account</option>
          </select>
          <div class="invalid-feedback">Please Select account type.</div>
        </div>
      </div>

      <div class="col-12 col-lg-6 pl-3 pr-5">
        <div class="form-group">
          <label class="text-warning font-weight-bold">Address Line-1:<span class="text-danger">*</span></label>
          <input type="text" class="form-control text-warning font-weight-bolder" id="line1" name="line1" required>
          <div class="invalid-feedback">Please Enter Address line-1.</div>
        </div>
      </div>
      <div class="col-12 col-lg-6 pl-3 pr-5">
        <div class="form-group">
          <label class="text-warning font-weight-bold">Address Line-2:</label>
          <input type="text" class="form-control text-warning font-weight-bolder" id="line2" name="line2">
        </div>
      </div>
      <div class="col-12 col-lg-6 pl-3 pr-5">
        <div class="form-group">
          <label class="text-warning font-weight-bold">City:<span class="text-danger">*</span></label>
          <input type="text" class="form-control text-warning font-weight-bolder" id="city" name="city" required>
          <div class="invalid-feedback">Please Enter City Name.</div>
        </div>
      </div>
      <div class="col-12 col-lg-6 pl-3 pr-5">
        <div class="form-group">
          <label class="text-warning font-weight-bold">State:<span class="text-danger">*</span></label>
          <select class="form-control text-warning font-weight-bolder" id="state" name="state" required>
          	<option value="">select the state</option>
            <option value="Tamil nadu">Tamil Nadu</option>
            <option value="kerala">kerala</option>
            <option value="Goa">Goa</option>
          </select>
          <div class="invalid-feedback">Please Select State.</div>
        </div>
      </div>
      <div class="col-12 col-lg-6 pl-3 pr-5">
        <div class="form-group">
          <label class="text-warning font-weight-bold">Zipcode:<span class="text-danger">*</span></label>
          <input type="text" class="form-control text-warning font-weight-bolder" pattern="^[0-9]{6}" id="zipcode"
            name="zipcode" required>
          <div class="invalid-feedback">Please Enter Zipcode.</div>
        </div>
      </div>
      <div class="col-12 pl-3 pr-5">
        <button class="btn btn-outline-warning w-100" type="submit">Create Account</button>
      </div>
    </div>
  </form>
</div>
<script>
var element = document.getElementById("nav2");
element.classList.add("active");
</script>