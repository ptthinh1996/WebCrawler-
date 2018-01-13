<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <!-- Theme Made By www.w3schools.com - No Copyright -->
    <title>Index</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .jumbotron {
            background-color: #f4511e;
            color: #fff;
        }
    </style>
</head>
<body>

<div class="jumbotron text-center">
    <h1>DEMO THU THẬP CÁC CHUYẾN DU LỊCH NỘI ĐỊA</h1>
    <p></p>
    <form class="form-inline" action="/DemoWebCrawler" method="post">
        <div class="input-group">
            <input type="text" class="form-control" size="50" placeholder="Địa điểm cần tìm" required value=""
                   name="key">
            <div class="input-group-btn">
                <button type="submit" class="btn btn-danger">Tìm kiếm</button>
            </div>
        </div>
        <div class="input-group">
            <input style="margin-left: 10px" type="radio" name="place" value="bac" checked> Miền Bắc
            <input style="margin-left: 10px" type="radio" name="place" value="trung"> Miền Trung
            <input style="margin-left: 10px" type="radio" name="place" value="nam"> Miền Nam
        </div>
    </form>
</div>

<div class="container-fluid text-center bg-grey">
    <h2>Từ các trang web</h2>
    <div class="row text-center">
        <div class="col-sm-4">
            <div class="thumbnail">
                <img src="vietravel.jpg" alt="Paris">
                <p><strong>Vietravel</strong></p>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="thumbnail">
                <img src="saigon.jpg" alt="New York">
                <p><strong>Saigon Tourist</strong></p>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="thumbnail">
                <img src="kimlien.jpg" alt="San Francisco">
                <p><strong>Kimlien Tourist</strong></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>