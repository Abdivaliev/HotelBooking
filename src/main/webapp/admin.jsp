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
    <% List<Booking> bookingList = (List<Booking>) request.getAttribute("bookings");%>
    <div class="row">
        <div class="col-sm-12 col-md-3 borderLeft scrollable">
            <div class="sticky py-3">
                <form action="/reservation" class="row d-flex align-items-center" method="post">
                    <div class="col">
                        <label> Booking ID </label>
                        <input type="text" name="bookingNumber" class="form-control">
                    </div>
                    <div class="col">
                        <label>Room number</label>
                        <input type="number" name="roomNumber" class="form-control">
                    </div>
                    <div class="col-12 mt-3">
                        <button type="submit" class="btn btn-primary w-100">Booked</button>
                    </div>
                </form>
            </div>
            <% for (Booking s : bookingList) {%>
            <div class="col-md-12 p-3 shadow w-100">
                <div class="d-flex justify-content-between">
                    <div class="fw-bolder">Booking ID</div>
                    <div style="margin-left: 10px">
                        <%=s.getId()%>
                    </div>
                </div>
                <div class="d-flex justify-content-between">
                    <div class="fw-bolder">Type Of room</div>
                    <div style="margin-left: 10px">
                        <%=s.getStatusRoom()%>
                    </div>
                </div>
                <div class="d-flex justify-content-between">
                    <div class="fw-bolder">Number of beds</div>
                    <div style="margin-left: 10px">
                        <%=s.getNumberOfBeds()%>
                    </div>
                </div>
                <div class="d-flex justify-content-between">
                    <div class="fw-bolder">From</div>
                    <div style="margin-left: 10px">
                        <%=s.getStartDate()%>
                    </div>
                </div>
                <div class="d-flex justify-content-between">
                    <div class="fw-bolder">To</div>
                    <div style="margin-left: 10px">
                        <%=s.getEndDate()%>
                    </div>
                </div>
                <div class="d-flex justify-content-between">
                    <div class="fw-bolder">First name</div>
                    <div style="margin-left: 10px">
                        <%=s.getClient().getFirstName()%>
                    </div>
                </div>
                <div class="d-flex justify-content-between">
                    <div class="fw-bolder">Surname</div>
                    <div style="margin-left: 10px">
                        <%=s.getClient().getSurname()%>
                    </div>
                </div>
                <div class="d-flex justify-content-between">
                    <div class="fw-bolder">Phone number</div>
                    <div style="margin-left: 10px">
                        <%=s.getClient().getPhoneNumber()%>
                    </div>
                </div>
                <div class="d-flex justify-content-between">
                    <div class="fw-bolder">Email</div>
                    <div style="margin-left: 10px">
                        <%=s.getClient().getEmail()%>
                    </div>
                </div>


            </div>
            <%
                }
                ;
            %>
        </div>
        <div class="col-sm-12 col-md-6 scrollable">
            <div class="col-md-12 sticky py-3">
                <div >
                    <form action="/filter" class="row" method="post" style="height: 100px">
                        <div class="col-md-3">
                            <label>Type of room</label>
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
                        <img src="<%=s.getPhotoLink() %>" alt="image not found" width="100%">

                        <div class="d-flex justify-content-between mt-2 ">
                            <div class="fw-bolder">Room number</div>
                            <div>
                                <%=s.getRoomNumber()%>
                            </div>
                        </div>

                        <div class="d-flex justify-content-between mt-2 ">
                            <div class="fw-bolder">Type of Room</div>
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
                            <div class="fw-bolder">Size(square meter)</div>
                            <div>
                                <%=s.getSquare()%>
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
        <div class="col-sm-12 col-md-3 borderRight">
            <div class="row scrollable">
                <div class="sticky py-3">
                    <form action="/addBooking" class="row d-flex align-items-center">
                        <div class="col">
                            <label> Reservation number </label>
                            <input type="text" name="bookingNumber" class="form-control">
                        </div>
                        <div class="col">
                            <label>Customer name</label>
                            <input type="number" name="customerName" class="form-control">
                        </div>
                        <div class="col-12 mt-3">
                            <button type="submit" class="btn btn-primary w-100">Search</button>
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
</div>


</body>
</html>