<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login</title>

    <!-- Custom fonts for this template-->
    <link href="resource/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="resource/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">
	<section class="vh-100">
	  <div class="container py-5 h-100">
	    <div class="row d-flex align-items-center justify-content-center h-100">
	      <div class="col-md-8 col-lg-7 col-xl-6">
	        <img src="resource/img/draw2.png"
	          class="img-fluid" alt="Phone image">
	      </div>
	      <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
	        <form class="user" action="login" name="login" method="post">
	          <!-- Email input -->
	          <div class="form-group">
                  <input type="text" class="form-control form-control-lg"
                      id="username" aria-describedby="emailHelp" name="username"
                      placeholder="username">
              </div>
              
	          <!-- Password input -->
              <div class="form-group">
                  <input type="password" class="form-control form-control-lg"
                      id="exampleInputPassword" name="password" placeholder="Password">
              </div>
	
	
	          <!-- Submit button -->
	          <button type="submit" class="btn btn-primary btn-lg btn-block">Login</button>
	
	        </form>
	      </div>
	    </div>
	  </div>
	</section>


    <!-- Bootstrap core JavaScript-->
    <script src="resource/vendor/jquery/jquery.min.js"></script>
    <script src="resource/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="resource/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="resource/js/sb-admin-2.min.js"></script>

</body>

</html>