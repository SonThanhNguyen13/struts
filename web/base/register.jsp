<%-- 
    Document   : register
    Created on : Sep 14, 2021, 2:46:12 PM
    Author     : sonthanhnguyen
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Register</title>
        <s:head />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="./assest/css/base/register.css">
        <link rel="stylesheet" href="./assest/css/utils/footer.css">
        <link rel="stylesheet" href="./assest/css/utils/base.css">
    </head>
    <body>
        <div id="header">
            <s:include value="../util/header.jsp"/>
        </div>
        <div id="content"  class="container justify-content-center">
            <img src="./assest/images/book-register.jpg" width="300px" height="500px">
            <s:form action="getRegister" method="POST">
                <div class="login-form">
                    <h2 class="text-center">Register</h2>
                    <s:token />
                    <div class="form-group">                
                        <label for="exampleInputEmail1">Username</label>
                        <input type="text" class="form-control" name="username"  placeholder="Username">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" class="form-control" name="password" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" class="form-control" name="retypePassword" placeholder="Retype password">
                    </div>
                    <div class="text-center">
                        <s:iterator value="actionMessages">
                            <s:property/><br/>
                        </s:iterator>
                        <s:iterator value="actionErrors">
                            <s:property/><br/>
                        </s:iterator>
                        <button type="submit" class="btn btn-primary ">Register</button>
                    </div>

                </s:form>
            </div>
        </div>
        <div class="fixed-bottom">
            <footer>
                <s:include value="../util/footer.jsp"/>
            </footer>
        </div>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>