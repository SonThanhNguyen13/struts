<%-- 
    Document   : updateUser
    Created on : Sep 15, 2021, 9:57:37 AM
    Author     : sonthanhnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update user</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="./assest/css/utils/footer.css">
    <link rel="stylesheet" href="./assest/css/utils/base.css">
    <link rel="stylesheet" href="./assest/css/admin/updateUser.css">
</head>
<body>
    <div id="header">
        <s:include value="../util/header.jsp"/>
    </div>
    <div id="content" class="container">
    </div>
    <div class="container">
        <form action="updateUser" method="POST"  enctype="multipart/form-data">
            <h3 class="text-center">Update user</h3>
            <div class="update-form">
                <div class="form-left col-6 text-center">        
                    <label for="avatar" class="label">Avatar:</label><br/>
                    <img src="<%=request.getContextPath()%>/<s:property value='avatar'/>" width="200px" height="400px" class="mb-1" /><br/>
                    <s:file name="userImage"/><br/>
                </div>
                <div class="form-right">        
                    <s:textfield type="hidden" name="userID"/>
                    <div class="form-group">
                        <label for="username">Username</label>
                        <s:textfield name="username" cssClass="form-control" readonly="true" size="100" />
                    </div>
                    <div class="form-group">
                        <label for="username">Password</label>
                        <s:password name="password" cssClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="username">Retype Password</label>
                        <s:password name="retypePassword" cssClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="username">Email</label>
                        <s:textfield name="email" cssClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="username">Name</label>
                        <s:textfield name="name" cssClass="form-control"/><br/>
                    </div>
                </div>
            </div>
            <div class="text-center">                
                <s:iterator value="actionMessages">
                    <s:property/><br/>
                </s:iterator>
                <s:iterator value="actionErrors">
                    <s:property/><br/>
                </s:iterator>
                <button class="btn btn-primary mt-1" value="submit" type="submit">Submit</button>
            </div>
        </form>

    </div>
    <footer class="fixed-bottom">
        <s:include value="../util/footer.jsp"/>
    </footer>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</body>



