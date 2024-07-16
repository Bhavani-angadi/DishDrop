<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register | Dish Drop</title>
    <link rel="stylesheet" href="signup.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600&display=swap" rel="stylesheet">
</head>
<body>

 <script>
        window.onload = function() {
            const urlParams = new URLSearchParams(window.location.search);
            const error = urlParams.get('error');
            if (error) {
                if (error === 'password') {
                    alert('Password and Confirm Password do not match.');
                } else if (error === 'database') {
                    alert('Failed to register. Please try again.');
                }
            }
        }
    </script>
    
    <header class="header">
        <div class="container">
            <h1 class="heading">DISH DROP</h1>
            <h2 class="sub-heading">Drop it like it's hot!</h2>
        </div>
    </header>

    <div class="main-content">
        <div class="container">
            <div class="form-container">
                <h1>Register</h1>
                <form action="Register" method="post">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" id="name" name="name" required placeholder="Ex. Bhavani">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <div class="input-with-icon">
                            <input type="email" id="email" name="email" required placeholder="Ex. abc@gmail.com">
                            <img src="right.jpg" alt="Valid" class="valid-icon" width="20px" height="20px">
                            <img src="warning.jpg" alt="Invalid" class="invalid-icon" width="20px" height="20px">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pwd">Password</label>
                        <input type="password" id="pwd" name="pwd" required>
                    </div>
                    <div class="form-group">
                        <label for="pwd">Confirm Password</label>
                        <input type="password" id="cpwd" name="cpwd" required>
                    </div>
                    <div class="form-group">
                        <label for="address">Address</label>
                        <input type="text" id="address" name="address" required>
                    </div>
                    <div class="form-group">
                        <label for="role">Role</label>
                        <input type="radio" id="role" name="role" value="customer" required>customer<br>
                        <input type="radio" id="role" name="role" value="restaurantAgent" required>restaurantAgent<br>
                        <input type="radio" id="role" name="role" value="deliveryAgent" required>deliveryAgent<br>
                        <input type="radio" id="role" name="role" value="systemAgent" required>systemAgent
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn-submit">Register</button>
                    </div>
                </form>
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