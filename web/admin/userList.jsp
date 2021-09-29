<%-- 
    Document   : userList
    Created on : Sep 15, 2021, 8:55:07 AM
    Author     : sonthanhnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="../assest/css/utils/footer.css">
        <link rel="stylesheet" href="../assest/css/utils/base.css">
    </head>
    <body>
        <div id="header">
            <s:include value="../util/header.jsp"/>
        </div>
        <div id="content" class="container">
            <div class="text-right">
                <a href="/Library/admin/createUserPage">Create user</a>
            </div>
            <h2 class="text-center">User List</h2>
            <table  class="table  table-bordered table-hover">
                <thead class="table-dark text-center">
                    <tr>
                        <td>#</td>
                        <td>Username</td>
                        <td>Is admin</td>
                        <td>Email</td>
                        <td>Name</td>
                        <td>Avatar</td>
                        <td>Action</td>
                    </tr>
                </thead>
                <s:iterator value="userList" id="user">
                    <tr class="text-center">
                        <td><s:property value="#user.id" /></td>
                        <td>${user.username}</td>
                        <td>${user.isAdmin}</td>
                        <td>${user.email}</td>
                        <td>${user.name}</td>
                        <td class="text-center"><img src="<%=request.getContextPath()%>/<s:property value='avatar'/>" width="100px" height="150px"/></td>
                        <td>
                            <div class="text-center">
                                <a href="/Library/admin/updateUserPage?userID=<s:property value='#user.id'/>">
                                    <button type="button" class="btn btn-primary align-middle">Update</button>
                                </a>
                                <a href="/Library/admin/deleteUserPage?userID=<s:property value='#user.id'/>">
                                    <button type="button" class="btn btn-danger">Delete</button>
                                </a>
                            </div>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </div>

        <footer>
            <s:include value="../util/footer.jsp"/>
        </footer>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>
