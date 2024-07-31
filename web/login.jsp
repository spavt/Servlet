<%--
  Created by IntelliJ IDEA.
  User: xueyuan
  Date: 2024/7/29
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            margin: 0;
            background: linear-gradient(135deg, #4a90e2, #9013fe);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .main {
            width: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .login {
            width: 360px;
            padding: 40px;
            background-color: #ffffff;
            border-radius: 25px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
            text-align: center;
        }

        h1 {
            margin-bottom: 30px;
            color: #4a90e2;
            font-size: 24px;
        }

        .loginForm {
            display: flex;
            flex-direction: column;
        }

        .usernm,
        .passwd {
            height: 45px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 0 15px;
            font-size: 16px;
        }

        .btn {
            height: 45px;
            background-color: #4a90e2;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            color: #fff;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        .btn:hover {
            background-color: #357abD;
        }

        .btn:last-of-type {
            background-color: #9013fe;
            margin-top: 10px;
        }

        .btn:last-of-type:hover {
            background-color: #7011cd;
        }

        span {
            margin: 0px;
            color: gray;
            text-align: left;
        }
        a {
            text-decoration: none;
            color: inherit;
        }
        .verify-container {
            display: flex;
            align-items: center;
        }
        .verify-container img {
            cursor: pointer;
            width: 200px;
            margin-left: 10px;
            margin-bottom: 10px;
        }
    </style>
    <title>登录</title>
</head>

<body>
<div class="main">
    <div class="login">
        <h1>登录</h1>
        <form action="islogin" method="post" class="loginForm">
            <input type="text" name="user" placeholder="用户名" class="usernm" onblur="clickUsername()" id="username">
            <span id="usernameInput"></span><br>
            <input type="password" name="pwd" placeholder="密码" class="passwd" onblur="clickPassword()" id="password">
            <span id="passwordInput"></span><br>
            <div class="verify-container">
                <input type="text" name="code" placeholder="验证码" class="usernm" id="verifyCode">
                <img src="vcode" alt="验证码" onclick="this.src=this.src+'?'+Math.random()">
            </div><br>
            <button type="submit" class="btn">登录</button>
            <button type="button" class="btn"><a href="/register.html">注册</a></button>
        </form>
    </div>
</div>
</body>

</html>
