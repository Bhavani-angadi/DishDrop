<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login | Dish Drop</title>
    <link rel="stylesheet" href="login.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600&display=swap" rel="stylesheet">
</head>
<body>

    <header class="header">
        <div class="container">
            <h1 class="heading">DISH DROP</h1>
            <h2 class="sub-heading">Drop it like it's hot!</h2>
        </div>
    </header>

    <div class="main-content">
        <div class="container">
            <div class="login-form">
                <h1>Login</h1>
                <form action="Login" method="post" id="loginForm">
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" id="email" name="email" placeholder="Enter your email" required>
                    </div>
                    <div class="form-group">
                        <label for="pwd">Password</label>
                        <input type="password" id="pwd" name="pwd" placeholder="Enter your password" required>
                    </div>
                    <div class="form-group">
                        <label>
                            <input type="checkbox" name="remember"> Remember me
                        </label>
                        <a href="#" class="forgot-password">Forgot password?</a>
                    </div>
                    <div class="form-group">
                        <button type="submit"  class="btn-login">LOGIN</button>
                    </div>
                </form>
                <p>Are you a new user? <a href="signup.jsp" class="register-link">REGISTER</a></p>
            </div>
        </div>
    </div>

    <footer class="footer">
        <div class="container">
            <p>&copy; 2024 Dish Drop. All rights reserved.</p>
        </div>
    </footer>

</body>
</html>