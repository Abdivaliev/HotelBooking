<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.sarvar.hotelbooking.model.Room" %>
<%@ page import="uz.sarvar.hotelbooking.model.Booking" %>
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

    </div>
</nav>
<br/>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12 col-md-3 borderRight">
            <% List<Booking> bookingList = (List<Booking>) request.getAttribute("bookings");%>
            <div class="row scrollable">
                <% for (Booking s : bookingList) {%>
                <div class="col-md-12 p-3 shadow w-100">
                    <div class="d-flex">
                        <div class="fw-bolder">First name</div>
                        <div style="margin-left: 10px">
                            <%=s.getClient().getFirstName()%>
                        </div>
                    </div>
                    <div class="d-flex">
                        <div class="fw-bolder">Surname</div>
                        <div style="margin-left: 10px">
                            <%=s.getClient().getSurname()%>
                        </div>
                    </div>
                    <div class="d-flex">
                        <div class="fw-bolder">Phone Number</div>
                        <div style="margin-left: 10px">
                            <%=s.getClient().getPhoneNumber()%>
                        </div>
                    </div>
                    <div class="d-flex">
                        <div class="fw-bolder">Phone Number</div>
                        <div style="margin-left: 10px">
                            <%=s.getClient().getPhoneNumber()%>
                        </div>
                    </div>
                    <div class="d-flex">
                        <div class="fw-bolder">Phone Number</div>
                        <div style="margin-left: 10px">
                            <%=s.getClient().getPhoneNumber()%>
                        </div>
                    </div>
                    <div class="d-flex">
                        <div class="fw-bolder">Phone Number</div>
                        <div style="margin-left: 10px">
                            <%=s.getClient().getPhoneNumber()%>
                        </div>
                    </div>
                    <div class="d-flex">
                        <div class="fw-bolder">Phone Number</div>
                        <div style="margin-left: 10px">
                            <%=s.getClient().getPhoneNumber()%>
                        </div>
                    </div>
                    <div class="d-flex">
                        <div class="fw-bolder">Phone Number</div>
                        <div style="margin-left: 10px">
                            <%=s.getClient().getPhoneNumber()%>
                        </div>
                    </div>
                </div>
                <%
                    }
                    ;
                %>
            </div>
        </div>
        <div class="col-sm-12 col-md-6 scrollable">
            <div class="col-md-12 sticky" style="height: 100px">
                <div style="height: 100px">
                    <form action="/search-filter" class="row" method="post" style="height: 100px">
                        <div class="col-md-3">
                            <label>Status</label>
                            <br>
                            <select class="form-control" name="status">
                                <option value="STANDARD">Standard</option>
                                <option value="DELUXE">Deluxe</option>
                                <option value="PREMIUM">Premium</option>
                            </select>
                        </div>
                        <div class="col-md-3">
                            <label>Start date</label>
                            <input class="form-control" type="date" name="startDate"/>
                        </div>
                        <div class="col-md-3">
                            <label>End date</label>
                            <input class="form-control" type="date" name="endDate"/>
                        </div>
                        <div class="col-md-3">
                            <label>Number of beds </label>
                            <input class="form-control" type="number" name="numberOfBeds"/>
                        </div>
                        <div class="col-md-12 mt-2 d-flex justify-content-center">
                            <button class="btn btn-primary">SEARCH</button>
                        </div>
                    </form>
                </div>
            </div>
            <% List<Room> roomlist = (List<Room>) request.getAttribute("lists");%>
            <div class="col-md-12">
                <div class="row mt-4 mb-4">
                    <% for (Room s : roomlist) {%>
                    <div class="col-md-4 p-3 shadow">
                        <img src="<%=s.getExtra() %>" alt="rasm topilmadi" width="100%">
<%--                        <img src="https://www.usatoday.com/gcdn/-mm-/05b227ad5b8ad4e9dcb53af4f31d7fbdb7fa901b/c=0-64-2119-1259/local/-/media/USATODAY/USATODAY/2014/08/13/1407953244000-177513283.jpg"--%>
<%--                             alt="booking-image" width="100%">--%>
<%--                        shundan pasti kopy qilinadi--%>
                        <div class="d-flex justify-content-between mt-2">
                            <div>Room number</div>
                            <div>
                                <%=s.getNumber()%>
                            </div>
                        </div>
<%--                        //gacha--%>
                    </div>
                    <%
                        }
                        ;
                    %>
                </div>
            </div>
        </div>
        <div class="col-sm-12 col-md-3 borderLeft scrollable">
            <div class="sticky">
                <form action="/addBooking" class="row d-flex align-items-center">
                    <div class="col">
                        <label> Booking number </label>
                        <input type="text" name="bookingNumber" class="form-control">
                    </div>
                    <div class="col">
                        <label>Room number</label>
                        <input type="text" name="roomNumber" class="form-control">
                    </div>
                    <div class="col-12 mt-3">
                        <button type="submit" class="btn btn-primary w-100">Booked</button>
                    </div>
                </form>
            </div>
            <% for (Booking s : bookingList) {%>
            <div class="col-md-12 p-3 shadow w-100">
                <div class="d-flex">
                    <div class="fw-bolder">First name</div>
                    <div style="margin-left: 10px">
                        <%=s.getClient().getFirstName()%>
                    </div>
                </div>
                <div class="d-flex">
                    <div class="fw-bolder">Surname</div>
                    <div style="margin-left: 10px">
                        <%=s.getClient().getSurname()%>
                    </div>
                </div>
                <div class="d-flex">
                    <div class="fw-bolder">Phone Number</div>
                    <div style="margin-left: 10px">
                        <%=s.getClient().getPhoneNumber()%>
                    </div>
                </div>
                <div class="d-flex">
                    <div class="fw-bolder">Phone Number</div>
                    <div style="margin-left: 10px">
                        <%=s.getClient().getPhoneNumber()%>
                    </div>
                </div>
                <div class="d-flex">
                    <div class="fw-bolder">Phone Number</div>
                    <div style="margin-left: 10px">
                        <%=s.getClient().getPhoneNumber()%>
                    </div>
                </div>
                <div class="d-flex">
                    <div class="fw-bolder">Phone Number</div>
                    <div style="margin-left: 10px">
                        <%=s.getClient().getPhoneNumber()%>
                    </div>
                </div>
                <div class="d-flex">
                    <div class="fw-bolder">Phone Number</div>
                    <div style="margin-left: 10px">
                        <%=s.getClient().getPhoneNumber()%>
                    </div>
                </div>
                <div class="d-flex">
                    <div class="fw-bolder">Phone Number</div>
                    <div style="margin-left: 10px">
                        <%=s.getClient().getPhoneNumber()%>
                    </div>
                </div>
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