<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Login | By Code Info</title>
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
      rel="stylesheet"
    />
    <link href="resources/static/css/login_form.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <div class="login-box">
      <h1>Login</h1>
      <form action="products?size=10&page=1" method="post">
<!-- 			<input type="text" name="searchInput" onkeyup="doAjax()"> <br> -->
<!-- 			<span id="result">1</span>  -->
			<label>Login</label>
			<input type="text" name="Login"> <br>
			<label>Password</label>
			<input type="password" name="Pass"> <br> 
			<button type="submit">Submit</button>
		</form>
    </div>
    <p class="para-2">
      Not have an account? <a href="registration_form">Sign Up Here</a>
    </p>
  </body>
</html>
