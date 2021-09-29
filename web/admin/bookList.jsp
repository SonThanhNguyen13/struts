<%-- 
    Document   : bookList
    Created on : Sep 20, 2021, 10:04:56 AM
    Author     : sonthanhnguyen
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book list</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="../assest/css/utils/footer.css">
        <link rel="stylesheet" href="../assest/css/utils/base.css">
        <link rel="stylesheet" href="../assest/css/admin/bookList.css">
    </head>
    <body>
        <div id="header">
            <s:include value="../util/header.jsp"/>
        </div>
        <div id="content" class="container">
            <div class="text-right">
                <a href="/Library/admin/createBookPage" >Create Book</a>
            </div>

            <h2 class="text-center">Book List</h2>
            <table  class="table  table-bordered table-hover">
                <thead class="table-dark text-center">
                    <tr>
                        <td scope="col">#</td>
                        <td scope="col">Name</td>
                        <td scope="col">Author</td>
                        <td scope="col">Description</td>
                        <td scope="col">Image</td>
                        <td scope="col">Action</td>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="bookList" id="book">
                        <tr class="text-center">
                            <td scope="col"><s:property value="#book.id" /></td>
                            <td>${book.name}</td>
                            <td>${book.author}</td>
                            <td>${book.description}</td>
                            <td><img src="<%=request.getContextPath()%>/<s:property value='image'/>" width="100px" height="150px"/></td>
                            <td>
                                <div class="text-center">                                
                                    <a href="/Library/admin/updateBookPage?bookID=<s:property value='#book.id'/>">
                                        <button type="button" class="btn btn-primary mt-4">Update</button>
                                    </a>
                                    <a href="/Library/admin/deleteBookPage?bookID=<s:property value='#book.id'/>">
                                        <button type="button" class="btn btn-danger mt-4">Delete</button>
                                    </a>
                                </div>

                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
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
