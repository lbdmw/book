<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城会员注册页面</title>
	<%--静态包含base标签 cass，  jquery--%>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		//页面加载完成之后
		$(function () {
			//给注册绑定单击事件
			$("#sub_btn").click(function () {
				//验证用户名：必须由字母，数字下划线组成，并且长度为5到十二位
				//1.获取用户名输入框里的内容
				var usernameText = $("#username").val();
				//2.创建正则表达式对象
				var usernamePatt=/^\w{5,12}$/;
				//3.使用test方法验证
				if (!usernamePatt.test(usernameText)){
					//4.提示用户结果
					$("span.errorMsg").text("用户名不合法");
					return false;
				}
				$("span.errorMsg").text("");
				 //const:常量  let:全局
			$("#sub_btn").click(function () {
				//验证用户名：必须由字母，数字下划线组成，并且长度为5到十二位
				//1.获取密码输入框里的内容
				var passwordText = $("#password").val();
				//2.创建正则表达式对象
				var passwordPatt=/^\w{5,12}$/;
				//3.使用test方法验证
				if (!passwordPatt.test(passwordText)){
					//4.提示用户结果
					$("span.errorMsg").text("密码不合法");
					return false;
				}
				//验证密码：必须由字母，数字下划线组成，并且长度为5到十二位
				//验证确认密码，和密码相同
				//1.获取密码内容
				var repwdText = $("#repwd").val();
				//2.和密码比较
				if (repwdText!==passwordText){
					$("span.errorMsg").text("确认密码和密码不一致");

					return  false;
				}
				//const:常量  let:全局
			});
			//邮箱
				var emailText=$("#email").val();
				var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
				if (!emailPatt.test(emailText)){
					$("span.errorMsg").text("邮箱格式不合法");
					return  false;
				}
					//验证码
				var codeText=$("#code").val();
				codeText= $.trim(codeText);
				if (codeText==null||codeText===""){
					$("span.errorMsg").text("验证码不能为空");
					return  false;
				}
			});
			$("span.errorMsg").text("");
			// 验证邮箱*****@***.com
			// 验证码：现在只需要验证已输入
		});
		//
	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册书城会员</h1>
								<span class="errorMsg"> </span>
								<span class="errorMsg1">
									<%= request.getAttribute("msg")==null?"":request.getAttribute("msg")%>
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist" >

									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username"
									<%=request.getAttribute("username")==null?"":request.getAttribute("msg")%>/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password"
											<%=request.getAttribute("password")==null?"":request.getAttribute("msg")%>/>

									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd"
											<%=request.getAttribute("password")==null?"":request.getAttribute("msg")%>/>
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   autocomplete="off" tabindex="1" name="email" id="email"
											<%=request.getAttribute("email")==null?"":request.getAttribute("msg")%>/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" name="code" style="width: 150px; " id="code"
											<%=request.getAttribute("code")==null?"":request.getAttribute("msg")%>/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%--静态包含页脚内容--%>
		<%@include file="/pages/common/footes.jsp"%>
</body>
</html>