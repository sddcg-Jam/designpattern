<%--
  ~ Copyright (c) 博学谷 http://www.boxuegu.com
  ~ @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
  --%>

<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="description" content="设计模式之策略模式">
    <meta name="keywords" content="设计模式之策略模式">
    <meta name="viewport"
          content="width=device-width, initial-scale=1">
    <title>设计模式之策略模式</title>
    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">
    <!-- No Baidu Siteapp-->
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <meta name="mobile-web-app-capable" content="yes">

    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileColor" content="#0e90d2">

    <link rel="stylesheet" href="//cdn.amazeui.org/amazeui/2.7.2/css/amazeui.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js" type="text/javascript"></script>
    <style type="text/css">
        .am-panel {
            margin-bottom: 5px;
        }
    </style>
</head>
<body>

<div class=".am-container .am-center" id="accordion">
    <h1> 博学谷进阶公开课：设计模式之策略模式</h1>
    <div class="am-panel am-panel-primary">
        <div class="am-panel-hd">
            <h3 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#do-not-say-1'}">课程步骤</h3>
        </div>
        <div id="do-not-say-1" class="am-panel-collapse am-collapse">
            <div class="am-panel-bd">
                <ul>
                    <li>1、从一个电商案例开始<br/>
                        - 需求变更<br/>
                        - 代码重构<br/>
                    </li>
                    <li>2、理解策略模式<br/>
                        - 定义<br/>
                        - 场景<br/>
                    </li>
                    <li>3、策略模式在JDK代码中的应用<br/>
                        - ThreadPoolExecutor<br/>
                        - JAVA AWT 中的 LayoutManager<br/>
                        - Collections排序中的应用<br/>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="am-panel  am-panel-primary">
        <div class="am-panel-hd">
            <h3 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#do-not-say-2'}">
                第一版需求</h3>
        </div>
        <div id="do-not-say-2" class="am-panel-collapse am-collapse">
            <div class="am-panel-bd">
                V1：一个电商网站，Apple iPhone XR价格为固定值7100元
            </div>
        </div>
    </div>
    <div class="am-panel  am-panel-primary">
        <div class="am-panel-hd">
            <h3 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#do-not-say-3'}">
                第二版需求</h3>
        </div>
        <div id="do-not-say-3" class="am-panel-collapse am-collapse">
            <div class="am-panel-bd">
                V2：区分新用户、老用户，老用户九折优惠
            </div>
        </div>
    </div>
    <div class="am-panel  am-panel-primary">
        <div class="am-panel-hd">
            <h3 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#do-not-say-4'}">
                第三版需求</h3>
        </div>
        <div id="do-not-say-4" class="am-panel-collapse am-collapse">
            <div class="am-panel-bd">
                V3：增加VIP用户，vip用户8折
            </div>
        </div>
    </div>
    <div class="am-panel  am-panel-primary">
        <div class="am-panel-hd">
            <h3 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#do-not-say-5'}">
                第四版需求</h3>
        </div>
        <div id="do-not-say-5" class="am-panel-collapse am-collapse">
            <div class="am-panel-bd">
                V4：增加MVP用户，vip用户7折
            </div>
        </div>
    </div>
    <div class="am-panel  am-panel-primary">
        <div class="am-panel-hd">
            <h3 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#do-not-say-7'}">
                第五版需求</h3>
        </div>
        <div id="do-not-say-7" class="am-panel-collapse am-collapse">
            <div class="am-panel-bd">
                V5：增加邮费，新客户、老客户邮费10.11元，VIP客户9.11元，MVP客户0.11元。
            </div>
        </div>
    </div>
</div>

<div class="am-panel am-panel-primary">
    <div class="am-panel-hd">
        <h3 class="am-panel-title" data-am-collapse="{target: '#do-not-say-6'}">
            电商案例演示</h3>
    </div>
    <div id="do-not-say-6" class="am-panel-collapse am-collapse am-in">
        <div class="am-panel-bd">
            <div style="text-align: center;">
                Apple iPhone XR (A2108) 256GB ，售价<b>7100.00</b>元<br/>
                您的身份对应的价格为：<b><label id="price">--</label></b></br>
                <%--  选择身份：
                    <input type="radio" name="customerType" value="新客户" checked/>新客户
                    <input type="radio" name="customerType" value="老客户"/>老客户
                 <input type="radio" name="customerType" value="VIP客户"/>VIP客户
                 <input type="radio" name="customerType" value="MVP客户"/>MVP客户--%>
                <br/>
                <button type="button" class="am-btn am-btn-primary btn-loading-quote"
                        data-am-loading="{spinner: 'circle-o-notch', loadingText: '计算中...', resetText: '计算折扣'}">
                    计算折扣
                </button>
                <br/>
            </div>
        </div>
    </div>
</div>
<script src="http://cdn.amazeui.org/amazeui/2.7.2/js/amazeui.min.js"></script>
<script>
    //提交服务器
    $('.btn-loading-quote').click(function () {
        var $btn = $(this)
        $btn.button('loading');
        var data = $('input[type="radio"][name="customerType"]:checked').val(); // 获取一组radio被选中项的值
        //获取数据提交到服务器端
        $.post("/getMyQuotation", {'customerType': data}, function (result) {
            $("#price").html(result);
        });
        setTimeout(function () {
            $btn.button('reset');
        }, 500);
    });
</script>
</body>
</html>