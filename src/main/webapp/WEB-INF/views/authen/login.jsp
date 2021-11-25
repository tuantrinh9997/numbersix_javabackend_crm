<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<title>Login Page</title>
<body>
<h4 class="m-0">Welcome back!</h4>
    <p class="mb-5">Login to access your account </p>

    <form method="post" action="" novalidate>
        <div class="form-group">
            <label class="text-label" for="email_2">Email Address:</label>
            <div class="input-group input-group-merge">
                <input id="username" type="email" required="required" class="form-control form-control-prepended" placeholder="johndoe.com" name="username">
                <div class="input-group-prepend">
                    <div class="input-group-text">
                        <span class="far fa-user"></span>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="text-label" for="password_2">Password:</label>
            <div class="input-group input-group-merge">
                <input id="password_2" type="password" required="required" class="form-control form-control-prepended" placeholder="Enter your password" name="password">
                <div class="input-group-prepend">
                    <div class="input-group-text">
                        <span class="fa fa-key"></span>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-group mb-5">
            <div class="custom-control custom-checkbox">
                <input type="checkbox" class="custom-control-input" checked id="remember">
                <label class="custom-control-label" for="remember">Remember me</label>
            </div>
        </div>
        <div class="form-group text-center">
            <button class="btn btn-primary mb-5" type="submit">Login</button><br>
            <a href="">Forgot password?</a> <br> Don't have an account? <a class="text-body text-underline" href="signup.html">Sign up!</a>
        </div>
    </form>
</body>