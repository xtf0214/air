<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="common/css/sapar.css" />
<link rel="stylesheet" href="static/css/index.css" />

<title>Sapar 航空代理B2B系统</title>
</head>

<body>
<div id="container">
	<div id="hd">
    	<div class="hd-wrap clearfix">
        	<div class="top-light"></div>
            <h1 class="logo"></h1>
            <ul class="main-nav clearfix">
                <li class="current" data-src="static/system/index.html"><a href="javascript:;">系统</a></li>
                <li data-src="static/user/index.html"><a href="javascript:;">用户</a></li>
                <li data-src="static/ticket/index.html"><a href="javascript:;">机票</a></li>
                <li data-src="static/msg/index.html"><a href="javascript:;">短信</a></li>
                <li data-src="static/xingchengdan/index.html"><a href="javascript:;">行程单</a></li>
                <li data-src="static/insurance/index.html"><a href="javascript:;">保险</a></li>
                <li data-src="static/caiwu/index.html"><a href="javascript:;">财务</a></li>
            </ul>
            <div class="notice clearfix">
                <ul class="clearfix">
                    <li class="current"><a href="javascript:;">关于客票行程单打印通知</a></li>
                    <li><a href="javascript:;">关于网银付款升级通知</a></li>
                    <li><a href="javascript:;">关于客票行程单打印通知</a></li>
                </ul>
                <div class="notice-btn">
                    <a href="javascript:;" class="prev"></a>
                    <a href="javascript:;" class="next"></a>
                </div>
            </div>
            <div class="toolbar">
                <div class="login-info clearfix">
                    <div class="welcome clearfix"><span>欢迎您,</span><a href="javascript:;" class="user-name">${sessionScope.user.username}</a></div>
                    <div class="login-msg clearfix">
                        <a href="javascript:;" class="msg-txt">消息</a>
                        <a href="javascript:;" class="msg-num">10</a>
                    </div>
                </div>
                <div class="tool clearfix">
                    <a class="tips" href="javascript:;">合作须知</a>
                    <a class="tips" href="javascript:;">购票协议</a>
                    <a href="javascript:;" class="help-btn">帮助</a>
                    <a href="javascript:;" class="quit-btn exit">退出</a>
                </div>
            </div>          
        </div>
    </div>
    <div id="bd">
    	<div class="wrap clearfix">
        	

     <iframe src="static/system/index.html" id="iframe" width="100%" height="100%" frameborder="0"></iframe>
 </div>
 </div>
    <div id="ft" class="clearfix">
    	<div class="ft-left">
            <span>Sapar 航空代理B2B系统</span>
            <em>Office&nbsp;System</em>
        </div>
        <div class="ft-right">
            <span>Automation</span>
            <em>V2.0&nbsp;2014</em>
        </div>
    </div>
</div>
<div class="exitDialog">
	<div class="dialog-content">
    	<div class="ui-dialog-icon"></div>
        <div class="ui-dialog-text">
        	<p class="dialog-content">你确定要退出系统？</p>
            <p class="tips">如果是请点击“确定”，否则点“取消”</p>
            
            <div class="buttons">
                <input type="button" class="button long2 ok" value="确定" />
                <input type="button" class="button long2 normal" value="取消" />
            </div>
        </div>
        
    </div>
</div>
</body>
<script type="text/javascript" src="common/js/jquery.js"></script>
<script type="text/javascript" src="common/js/sapar.js"></script>
<script type="text/javascript" src="static/js/index.js"></script>

</html>
