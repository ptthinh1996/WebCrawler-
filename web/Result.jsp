<%@ page import="com.crawler.core.Tour" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <title>Result</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>


        .header {
            position: relative;
            z-index: 2;
        }

        .sticky {
            position: fixed;
            top: 0;
            width: 100%;
        }

        .sticky + .content {
            padding-top: 102px;
        }

        .navbar {
            overflow: hidden;
            background-color: #333;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .result-bar {
            margin-bottom: 0;
            background-color: greenyellow;
            color: #fff;
            height: 70px;
            text-align: center;
        }

        footer {
            background-color: #f2f2f2;
            padding: 25px;
            position: fixed;
            bottom: 0%;
            width: 100%;
            color: #fff;
            background-color: greenyellow;
        }
    </style>
</head>
<body style="background-attachment: fixed" background="background.jpg">
<div></div>
<div class="result-bar">
    <div class="container text-center">
        <h2>Có ?? kết quả tìm kiếm
            <%
                String keyword = (String) request.getAttribute("keyword");
                out.println(keyword);
            %>
        </h2>
    </div>
</div>

<div class="header" id="myHeader">
    <div class="container">
        <div class="navbar">
            <div class="row">
                <div class="col-sm-4">
                    <p>Đất Việt</p>
                </div>
                <div class="col-sm-4">
                    <p>Sài Gòn Tourist</p>
                </div>
                <div class="col-sm-4">
                    <p>Kim Liên tourist</p>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="content">
    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <c:forEach items="${tours1}" var="tour">
                    <div class="panel panel-primary">
                        <div class="panel-heading" style="min-height: 70px">${tour.name}</div>
                        <div class="panel-body">${tour.price}</div>
                        <div class="panel-footer"><a title="Đến trang web" href="${tour.link}">Chi tiết</a></div>
                    </div>
                </c:forEach>
            </div>
            <div class="col-sm-4">
                <c:forEach items="${tours2}" var="tour">
                    <div class="panel panel-primary">
                        <div class="panel-heading" style="min-height: 70px">${tour.name}</div>
                        <div class="panel-body">${tour.price}</div>
                        <div class="panel-footer"><a title="Đến trang web" href="${tour.link}">Chi tiết</a></div>
                    </div>
                </c:forEach>
            </div>
            <div class="col-sm-4">
                <c:forEach items="${tours3}" var="tour">
                    <div class="panel panel-primary">
                        <div class="panel-heading" style="min-height: 70px">${tour.name}</div>
                        <div class="panel-body">${tour.price}</div>
                        <div class="panel-footer"><a title="Đến trang web" href="${tour.link}">Chi tiết</a></div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<div style="height: 170px"></div>
<br >

<footer class="container-fluid text-center">
    <p>Tiếp tục tìm kiếm</p>
    <form class="form-inline" action="/DemoWebCrawler" method="post">Nhập địa điểm
        <input type="text" class="form-control" size="50" placeholder="Địa điểm cần tìm" value="" name="key">
        <button type="submit" class="btn btn-default">Tìm kiếm</button>
    </form>
</footer>

<script>
    window.onscroll = function () {
        myFunction()
    };

    var header = document.getElementById("myHeader");
    var sticky = header.offsetTop;

    function myFunction() {
        if (window.pageYOffset >= sticky) {
            header.classList.add("sticky");
        } else {
            header.classList.remove("sticky");
        }
    }
</script>
</body>
</html>