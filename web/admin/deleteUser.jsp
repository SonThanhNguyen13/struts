<%-- 
    Document   : deleteUser
    Created on : Sep 16, 2021, 9:36:32 AM
    Author     : sonthanhnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete User</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="../assest/css/utils/footer.css">
        <link rel="stylesheet" href="../assest/css/utils/base.css">
        <link rel="stylesheet" href="../assest/css/admin/deleteUser.css">
    </head>
    <body>
        <div id="header">
            <s:include value="../util/header.jsp"/>
        </div>
        <div id="content" class="container text-center">
            <form action="deleteUser" method="POST" class="delete-form">
                <h2>Are you sure you want to delete user "<s:property value="username"/>" ?</h2>
                <s:textfield type="hidden" name="userID"/>
                <button class="btn btn-success mt-5" value="submit" type="submit">Confirm</button>
                <a href="/Library/admin/userList" class="btn btn-danger mt-5 ml-2">
                    Cancel
                </a>
            </form>

        </div>
        <footer class="fixed-bottom">
            <s:include value="../util/footer.jsp"/>
        </footer>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


    </body>
</html>
