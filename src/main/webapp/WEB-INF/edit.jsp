<%@ page language="java" contentType="title/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form.   anytime we use :, it taps into these tags-->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit album</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <!-- POST encodes data whereas GET shows data on Https/SSL -->
    <main id="content">
        <div id="page_header">
            <img src="/images/logo.png">
            <a href="/album/add">Update album</a>
        </div>
            <form:form action="/album/update" method="POST" modelAttribute="album"> <!-- this album here matches the last "album" in modelAttribute("album") album album in the controller-->
                <input type="hidden" name="id" value="<c:out value='${album.id}'/>">
                <form:label path="title" for="title">Title <!-- path matches the attribute in model.java -->
                    <form:errors path="title"/>
                    <form:input type="text" path="title"/>
                </form:label>
                <button>Update</button>
            </form:form>
        <div id="active_area">

        </div>

    </main>
    <div></div>

   
</body>
</html>