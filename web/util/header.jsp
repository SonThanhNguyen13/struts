<%-- 
    Document   : header
    Created on : Sep 20, 2021, 4:44:17 PM
    Author     : sonthanhnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="/Library/home">
            <img class="logo" src="<%=request.getContextPath()%>/assest/images/book-logo.png" width="50px" height="50px">
            Library
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/Library/home">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item"><a class="nav-link" href="#">Services</a></li>
                <li class="nav-item"><a class="nav-link" href="#">About</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Terms</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Privacy Policy</a></li>
            </ul>
            <% if (session.getAttribute("username") != null) { %>
            <span class="pl-2 pr-2" style="color:white;"> Welcome <s:property value="%{#session.username}"/> </span>
            <% if (session.getAttribute("isAdmin").equals("true")) {%>
            <span class="pl-2 pr-2"><a href="<%=request.getContextPath()%>/admin/userList">Show users</a></span>
            <span class="pl-2 pr-2"><a href="<%=request.getContextPath()%>/admin/bookList">Show books</a></span>
            <% }%>
            <span class="pl-2 pr-2"><a href="<%=request.getContextPath()%>/updateUserPage?userID=<s:property value="%{#session.userID}"/>">User account</a></span>
            <span class="pl-2 pr-2"><a href="logout">Logout</a></span>
            <% } else {%>
            <span class="pl-2 pr-2" style="color:white;">Welcome Guest</span>
            <span class="pl-2 pr-2"><a href="login">Login</a></span>
            <span class="pl-2 pr-2"><a href="register">Register</a></span>
            <% }%>
        </div>
    </nav>
</html>
