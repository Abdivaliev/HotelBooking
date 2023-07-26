<%--
  Created by IntelliJ IDEA.
  User: sarva
  Date: 7/25/2023
  Time: 11:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
    <link rel="stylesheet" href="css/home-style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body class="w-100 h-100 d-flex justify-content-center align-items-center">
<div>
    <%String text = (String) request.getAttribute("message");%>
    <img src="https://cdn-icons-png.flaticon.com/512/148/148767.png"
         alt="success-image" width="300px">
    <h3 class="text-center"><%=text%>
    </h3>
</div>
</body>
</html>
