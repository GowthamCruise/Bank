<% 
	if(session.getAttribute("cif")==null){
		response.sendRedirect("index.jsp");
	}
%>




<head>
  <meta charset="ISO-8859-1" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css" />
  <link rel="icon" type="image/ico" href="img/icon.png" />
  <script src="Bootstrap/js/jquery.min.js"></script>
  <script src="Bootstrap/js/popper.min.js"></script>
  <script src="Bootstrap/js/bootstrap.min.js"></script>
  <script>
    // Disable form submissions if there are invalid fields
    (function () {
      'use strict';
      window.addEventListener('load', function () {
        // Get the forms we want to add validation styles to
        var forms = document.getElementsByClassName('needs-validation');
        // Loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, function (form) {
          form.addEventListener('submit', function (event) {
            if (form.checkValidity() === false) {
              event.preventDefault();
              event.stopPropagation();
            }
            form.classList.add('was-validated');
          }, false);
        });
      }, false);
    })();
  </script>
  <title>Ybank of India</title>
</head>
<nav class="navbar bg-secondary navbar-dark fixed-top">
  <!-- Brand -->
  <a class="navbar-brand" href="#">YBank of India</a>

  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav text-center">
      <li class="nav-item" id="nav1">
        <a class="nav-link" href="home.jsp">Home</a>
      </li>
      <li class="nav-item" id="nav2">
        <a class="nav-link" href="fundTransfer.jsp">Fund Transfer</a>
      </li>
      <li class="nav-item" id="nav3" >
        <a class="nav-link" href="changePassword.jsp">Change Password</a>
      </li>
      <li class="nav-item" id="nav4">
        <a class="nav-link" href="changePin.jsp">Change Tpin</a>
      </li>
      <li class="nav-item" id="nav5">
        <a class="nav-link" href="quickView.jsp">Quick Transcation view</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="logout">Logout</a>
      </li>
    </ul>
  </div>
</nav>