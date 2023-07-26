<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.sarvar.hotelbooking.model.Room" %>
<%@ page import="uz.sarvar.hotelbooking.model.Hotel" %>
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
                <label>Type of room</label>
                <br>
                <select class="form-control" name="status" required>
                    <option value="STANDARD">Standard</option>
                    <option value="DELUXE">Deluxe</option>
                    <option value="PREMIUM">Premium</option>
                </select>
                <label class="btns">Number of beds</label>
                <input class="form-control" type="number" name="numberOfBeds" required>
                <label class="btns">Start date</label>

                <input class="form-control" type="date" name="startDate" required>
                <label class="btns">End date</label>

                <input class="form-control" type="date" name="endDate" required>

                <label class="btns">First name</label>

                <input class="form-control" type="text" name="firstName" required>
                <label class="btns">Surname</label>

                <input class="form-control" type="text" name="surname" required>
                <label class="btns">Phone number</label>

                <input class="form-control" type="number" name="phoneNumber" required>
                <label class="btns">E-mail</label>

                <input class="form-control" type="text" name="email" required>
                <br>
                <div class="d-flex justify-content-center w-100">
                    <button type="submit" class="btn btn-primary text-center" style="width: 100%">Booking</button>
                </div>
            </form>
        </div>
        <div class="col-sm-12 col-md-6 row scrollable">
            <% List<Room> stringList = (List<Room>) request.getAttribute("lists");%>
            <% for (Room s : stringList) {%>
            <div class="col-md-12 p-2">
                <img src="<%=s.getPhotoLink() %>" alt="image not found" height="250px" width="100%">
                <div class="d-flex justify-content-between mt-2 ">
                    <div class="fw-bolder">Room number</div>
                    <div>
                        <%=s.getRoomNumber()%>
                    </div>
                </div>

                <div class="d-flex justify-content-between mt-2 ">
                    <div class="fw-bolder">Type of room</div>
                    <div>
                        <%=s.getStatusOfRoom()%>
                    </div>
                </div>
                <div class="d-flex justify-content-between mt-2 ">
                    <div class="fw-bolder">Number of beds</div>
                    <div>
                        <%=s.getNumberOfBeds()%>
                    </div>
                </div>
                <div class="d-flex justify-content-between mt-2 ">
                    <div class="fw-bolder">Size (square meter)</div>
                    <div>
                        <%=s.getSquare()%>
                    </div>
                </div>
                <div class="d-flex justify-content-between mt-2 ">
                    <div class="fw-bolder">Average price for a day (in USA dollars)</div>
                    <div>
                        <%=s.getPrice()%>
                    </div>
                </div>
            </div>
            <%
                }
                ;
            %>

        </div>

        <div class="col-sm-12 col-md-3 row">
            <% Hotel hotel = (Hotel) request.getAttribute("hotelInfo");%>

            <div class="shadow p-2">
                <img src="<%=hotel.getPhotoLink() %>" alt="image not found" width="100%">
                <div>
                    <div class="p-3 d-flex justify-content-between">
                        <div class="fw-bolder">Name</div>
                        <div><%=hotel.getName()%></div>
                    </div>
                    <div class="p-3 d-flex justify-content-between">
                        <div class="fw-bolder">Phone Number</div>
                        <div><%=hotel.getPhoneNumber()%></div>
                    </div>
                    <div class="p-3 d-flex justify-content-between">
                        <div class="fw-bolder">Email</div>
                        <div><%=hotel.getEmail()%></div>
                    </div>
                    <div class="p-3 d-flex justify-content-between">
                        <div class="fw-bolder">Address</div>
                        <div><%=hotel.getAddress()%></div>
                    </div>

                    <div class="p-2 mt-5  d-flex justify-content-between">
                        <div><h6><%=hotel.getDescription()%> </h6></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>