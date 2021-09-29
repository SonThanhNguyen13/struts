<%-- 
    Document   : createUser
    Created on : Sep 15, 2021, 11:54:17 AM
    Author     : sonthanhnguyen
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create user</title>
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
            <s:form action="createUser" method="POST" enctype="multipart/form-data">
                <h3>Create User</h3>
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" name="username" placeholder="">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" name="password" placeholder="">
                </div>
                <div class="form-group">
                    <label for="password">Retype password</label>
                    <input type="password" class="form-control" name="retypePassword" placeholder="">
                </div>
                <div class="form-check form-check-inline mt-3 mb-3">
                    <input class="form-check-input" type="checkbox" name="isAdmin">
                    <label class="form-check-label" for="inlineCheckbox1">Is admin</label>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" name="email" placeholder="">
                </div>
                <div class="form-group">
                    <label for="username">name</label>
                    <input type="text" class="form-control" name="name" placeholder="">
                </div>
                <div class="input-group mb-3 mt-5">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroupFileAddon01">Avatar</span>
                    </div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" name="userImage">
                        <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
                    </div>
                </div>
                <div class="text-center mt-3">
                    <button class="btn btn-primary text-center" value="submit" type="submit">Submit</button>
                </div>
            </s:form>
            <div>
                <s:actionerror />
            </div>
            <div>
                <s:actionmessage />
            </div>
        </div>

        <footer class="">
            <s:include value="../util/footer.jsp"/>
        </footer>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>
