<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.sarvar.hotelbooking.model.Room" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hotel</title>
    <link rel="stylesheet" href="css/home-style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<nav class="navbar">

    <div></div>
    <div>
        <a href="login">
            <img src="css/img.png" alt="login" width="100">
        </a>
    </div>
</nav>
<br/>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12 col-md-3">
            <form action="/booking" method="post">
                <label for="">Status</label>
                <br>
                <select class="form-control" name="status" id="" required>
                    <option value="STANDARD">Standard</option>
                    <option value="DELUXE">Deluxe</option>
                    <option value="PREMIUM">Premium</option>
                </select>
                <label class="btns" for="">Number of beds</label>
                <br>
                <input class="form-control" type="number" name="numberOfBeds" required>
                <label class="btns" for="">Start date</label>
                <br>
                <input class="form-control" type="date" name="startDate" required>
                <label class="btns" for="">End date</label>
                <br>
                <input class="form-control" type="date" name="endDate" required>

                <label class="btns" >First name</label>
                <br>
                <input class="form-control" type="text" name="firstName" required>
                <label class="btns" for="">Surname</label>
                <br>
                <input class="form-control" type="text" name="surname" required>
                <label class="btns" for="">Phone number</label>
                <br>
                <input class="form-control" type="number" name="phoneNumber" required>
                <label class="btns" for="">E-mail</label>
                <br>
                <input class="form-control" type="text" name="email" required>
                <br>
                <div class="d-flex justify-content-center w-100">
                    <button type="submit" class="btn btn-primary text-center" style="width: 100%">Booking</button>
                </div>
            </form>
        </div>
        <div class="col-sm-12 col-md-9 row">
            <% List<Room> stringList = (List<Room>) request.getAttribute("lists");%>
            <% for (Room s : stringList) {%>
            <div class="col-md-4 p-3 shadow"><%=s.getNumber()%>
            </div>
            <%
                }
                ;
            %>
        </div>

    </div>
</div>


</body>
</html>