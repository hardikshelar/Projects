<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
	integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url("cd back.jpg");
            background-repeat: no-repeat;
            background-position: center center;
            background-size: cover;
            background-color: transparent;
            /* height: 100vh; */
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 40px;
        }

        .navbar {
            position: fixed;
            top: 0;
            width: 100%;
            background-color: transparent;
            padding: 10px;
        }

        .navbar .navbar-brand img {
            width: 60px;
            height: 48px;
        }

        .login-container {
            background-color: white;
            opacity:90%;
            padding: 30px;
            border-radius: 4px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            
            
        }

        .login-container h2 {
        text-align: center;
            margin-bottom: 20px;
            opacity: 100%;
        }
		
		.login-container img{
		width: 140px;
		text-align: center;
		}
		.credentials input[type="text"]{
			width: 85%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
		}
		
         
        .credentials input[type="password"] {
            width: 95%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
		
		.fixed-prefix {
  position: absolute;
  margin-top: 40px;
  margin-left: 10px;
 
  color: Black;
  font-weight: bold;
  pointer-events: none;
  transform: translateY(-50%);
}
		
        .login-container input[type="submit"] {
            width: 49%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 10px;
            position: relative;
        }

        .login-container input[type="submit"]:hover {
            background-color: #45a049;
        }
        
        .login-container input[type="reset"] {
            width: 49%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 10px;
            position: relative;
        }

        .g-recaptcha {
            margin-top: 10px;
        }

        .error {
            color: red;
            font-size: 12px;
            margin-top: 5px;
        }
        
        .captchaerror{
        color: red;
            font-size: 12px;
            margin-top: 5px;
        }
        .navbar-brand img{
        width: 180px !important;	
        height: 65px !important;
        }
        
        
        .fa{
        
        position: absolute;
        display: flex;
        margin-left:279px;
        margin-top:-35px;
        cursor: pointer;
        }
        
        .prefix{
        padding-left: 50px;
        
        }
        
        #refreshBtn{
        
        position: absolute;
        margin-left:200px;
        margin-top:-35px;
        cursor: pointer;
       	font-size: 30px;
       	color: green;
        }
        
        #captcha {
        width: 50%;
        color: #555;
        text-align: center;
        height: 30px;
        line-height: 25px;
        letter-spacing: 10px;
        border: 1px solid #888;
        
        }
        .captchaBox input[type="text"]{
        width: 50% ;
        padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            text-align: center;
        }
        
    </style>
    
 
    
    <script>
        function showPass(){
        let password = document.getElementById("password");
        let eyeIcon = document.getElementById("eyeicon");
        if(password.type == "password"){
        password.type = "text";
        eyeIcon.classList.add("fa-eye");
                eyeIcon.classList.remove("fa-eye-slash");
	} else{
	password.type = "password";
	eyeIcon.classList.remove("fa-eye");
                eyeIcon.classList.add("fa-eye-slash");
	}
    }
        
    var temp;
    function show(){
    let captcha = document.getElementById("captcha");
    temp = "";
    let cap = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890!@#$%&*";
    
    for( i = 0; i< 6;i++){
        let random =cap.charAt(Math.floor(Math.random()*cap.length)) ;
         temp += random;
    	console.log(random);
    }
    captcha.innerText = temp;
    console.log(temp);
}
    
    
      function validateForm() {
            var password = document.getElementById("password").value;
            var errorMessage = "";
			let captcha = document.getElementById("captcha");
    let capInput = document.getElementById("capInput").value;
    		var captchaError = "";
            // Password validation criteria
            if (password.length < 8) {
                errorMessage = "Password must be at least 8 characters long.";
            } else if (!/[A-Z]/.test(password)) {
                errorMessage = "Password must contain at least one uppercase letter.";
            } else if (!/[a-z]/.test(password)) {
                errorMessage = "Password must contain at least one lowercase letter.";
            } else if (!/[0-9]/.test(password)) {
                errorMessage = "Password must contain at least one number.";
            } else if (!/[!@#$%^&*]/.test(password)) {
                errorMessage = "Password must contain at least one special character (!@#$%^&*).";
            } else if(temp != capInput){
            	captchaError = "Invalid Captcha"+temp;
            }

            // If error message exists, prevent form submission and show the message
            if (errorMessage) {
                document.getElementById("password-error").textContent = errorMessage;
                return false;
            }
            else if(captchaError){
            	document.getElementById("captcha-error").textContent = captchaError;
                return false;
            }
			

            // Clear any previous error messages if validation passes
            document.getElementById("password-error").textContent = "";
            document.getElementById("captcha-error").textContent = "";
            return true;
        }  
      
      
     function showValidationDiv(){
    	 
     }
    </script>
</head>
<body onload="show()">
    <nav class="navbar">
        <div class="container">
            <a class="navbar-brand"  href="">
                <img src="IDBI_Intech_Logo.jpg" alt="IDBI Logo">
            </a>
        </div>
    </nav>

    <div class="login-container">
    <img src="IDBI_Intech_Logo.jpg" alt="IDBI Logo">
        <h2>Login</h2>
       <%
        String errorMsg = (String) session.getAttribute("errorMsg");
        if (errorMsg != null) {
    %>
        <div style="color: red; font-weight: bold; text-align: center;">
            <%= errorMsg %>
        </div>
    <%
            session.removeAttribute("errorMsg");
        }
    %>
        <form action="/loginuser" method="post" onsubmit="return validateForm()">
        <div class="credentials">
            <label for="id">Emp Id</label>
            <!-- <span class="fixed-prefix">
            	<input type="text" id="id" name="id" placeholder="" class="prefix" required> -->
            	
            	<span style="position: absolute; margin-top: 40px; font-size:13px;
  margin-left: -32px; color: Black;">INT</span>

				<input style="padding-left: 40px;" type="text" id="id" class="login_box login required number"  autocomplete="off" for="User name" size="5" name="id" maxlength="5">
            
			<div class="showPass">
            <label for="password">Password</label>
            <input type="password" onclick="showValidationDiv()" id="password" name="password" placeholder="Enter your password" required>
            <i id="eyeicon" class="fa fa-eye-slash" onclick="showPass()" aria-hidden="true"></i>
            
            </div>
            
            <div class="passValidation" hidden="hidden">
            <ul>
            <li id="lower">At least one lowercase letter</li>
        	<li id="upper">At least one Uppercase letter</li>
        	<li id="num">At least one number</li>
            <li id="special">At least one special character</li>
            </ul>
            
            </div>
            <div id="password-error" class="error"></div>
            </div>
			 <div class="captchaBox">
				<h5 style="color: gray;">Enter Captcha</h5>
				<div id="captcha">
				</div> 
				<div class="capShow">
				<i id="refreshBtn" onclick="show()" class="fa fa-refresh" aria-hidden="true"></i>
				</div>
				
				<input type="text" id="capInput">
				<div id="captcha-error" class="captchaerror"></div>
			</div> 
          
			
           <input type="submit"  value="Login">
            <input type="reset" value="Reset">
        </form>
    </div>
</body>
</html> 