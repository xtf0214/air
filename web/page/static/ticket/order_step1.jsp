<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=emulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/air/page/common/css/sapar.css"/>
    <link rel="stylesheet" type="text/css" href="/air/page/common/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/air/page/static/ticket/css/query_order_step.css"/>
    <script type="text/javascript" src="/air/page/common/js/jquery.js"></script>
    <script type="text/javascript" src="/air/page/common/js/sapar.js"></script>
    <script type="text/javascript" src="/air/page/common/js/WdatePicker.js"></script>
    <title>机票查询</title>
</head>

<body>
<div id="saper-container">
    <div id="saper-hd"></div>
    <div id="saper-bd">
        <div class="subfiled clearfix">
            <h2>机票查询</h2>
        </div>
        <div class="subfiled-content">
            <div class="steps">
                <ol>
                    <li class="active">
                        <i>1</i>
                        <span class="tsl">查询航班</span>
                    </li>
                    <li>
                        <i>2</i>
                        <span class="tsl">预订机票</span>
                    </li>
                    <li>
                        <i>√</i>
                        <span class="tsl">完成预订</span>
                    </li>
                </ol>
            </div>

            <form name="f1" id="f1" action="/air/fsearch">
                <div class="search-box clearfix">

                    <div class="content">
                        <div class="kv-item clearfix">
                            <label>出发城市：</label>
                            <div class="kv-item-content">
                                <input type="text" placeholder="出发城市">
                            </div>
                        </div>
                        <div class="kv-item clearfix">
                            <label>到达城市：</label>
                            <div class="kv-item-content">
                                <input type="text" placeholder="到达城市">
                            </div>
                        </div>
                        <div class="kv-item clearfix">
                            <label>出发日期：</label>
                            <div class="kv-item-content">
                                <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
                                       placeholder="出发日期">
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="sapar-btn sapar-btn-recom query-btn">查询</button>
                </div>
            </form>

            <div class="subfiled-style2 clearfix">
                <h2>查询结果：</h2>
            </div>
            <!--表格开始-->
            <div class="table">

                <!--表格具体内容-->
                <div class="table-box">
                    <table>
                        <thead>
                        <tr>
                            <th>日期</th>
                            <th>航班号</th>
                            <th>出发城市</th>
                            <th>到达城市</th>
                            <th>起飞时间</th>
                            <th>到达时间</th>
                            <th>票价</th>
                            <th>余票</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${fs}" var="f">
                            <tr>
                                <td>${f.flightDate}</td>
                                <td>${f.flightNum}</td>
                                <td>${f.startCity}</td>
                                <td>${f.endCity}</td>
                                <td>${f.startTime}</td>
                                <td>${f.endTime}</td>
                                <td>${f.ticket}</td>
                                <td>${f.ticket}席</td>
                                <td>
                                    <a href="order_step2.html" class="">预订机票</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div><!--表格结束-->
        </div>
    </div>
    <div id="saper-ft"></div>
</div>

</body>

</html>