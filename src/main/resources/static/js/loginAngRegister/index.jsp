<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="<%=request.getContextPath()%>/js/loginAngRegister/css/base.css"/>
 <link rel="stylesheet" href="<%=request.getContextPath()%>/js/loginAngRegister/css/login.css"/>
</head>
<body>
<div id="main">
    <div id="header">
    </div>
    <div class="container">
        <div class="bgPic"><img src="<%=request.getContextPath()%>/js/loginAngRegister/img/register/b3_1.jpg" alt=""/></div>
        <div class="register">
            <div class="title">
                <span>登录</span>
                <a href="register.html">去注册</a>
            </div>
            <form autocomplete="off">
                <div class="default">
                    <p>请输入用户名或手机号码</p>
                    <input id="uname" name="uname" data-form="uname" type="text" />
                    <label for="uname">用户名/手机</label>
                </div>
                <div class="default">
                    <p>请输入账号密码</p>
                    <input id="upwd" name="upwd" data-form="upwd" type="password"/>
                    <label for="upwd">密码</label>
                </div>
                <div class="submit">
                        <span class="notice">
                            <a href="#">忘记密码</a>
                        </span>
                    <button class="s_hover" type="button">登录</button>
                </div>
            </form>
            <div class="other_login">
                <div class="log">
                    <span>社交账号登录</span>
                </div>
                <div class="icon">
                    <ul>
                         <li data-log="icon" class="i_hover">
                            <img data-icon="wx" src="<%=request.getContextPath()%>/js/loginAngRegister/img/register/wx.png" alt=""/>
                            <span class="prompt" >微信登录</span>
                        </li>
                        <li data-log="icon" class="i_hover">
                            <img data-icon="qq" src="<%=request.getContextPath()%>/js/loginAngRegister/img/register/qq.png" alt=""/>
                            <span class="prompt" >QQ登录</span>
                        </li>
                        <li data-log="icon" class="i_hover">
                            <img data-icon="wb" src="<%=request.getContextPath()%>/js/loginAngRegister/img/register/wb.png" alt=""/>
                            <span class="prompt" >微博登录</span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div id="footer">
    </div>
</div>
<script src="<%=request.getContextPath()%>/js/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/js/header.js"></script>
<script src="<%=request.getContextPath()%>/js/login.js"></script>

<script type="text/javascript">






</script>
</body>
</html>