<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>成功</title>
    <style>
        *{
            padding:0;
            margin:0;
            font-family:"微软雅黑";
        }
        .header{
            height:72px;
            background:#458fce ;
        }
        .header .logo{
            color:#fff ;
            line-height:70px;
            font-size:30px;
            margin-left:20px;
            display:inline-block;
            text-align:center;

        }
        a {
            color: #000 ;
            text-decoration: none ;
        }
        .header .login{
            float:right;
            color:#fff ;
            line-height:72px;
            margin-right:2px;
            display:inline-block;
        }
        .banner{
            height:380px;
            background: #ddd;
        }
        .body{
            border: 1px solid red;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="logo">web实践</div>
    <div class ="login">
        <a href ="javascript:void(0)">登录成功</a>
    </div>
</div>
</body>
</html>