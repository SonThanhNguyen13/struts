<%-- 
    Document   : HelloWorld
    Created on : Sep 13, 2021, 9:56:12 AM
    Author     : sonthanhnguyen
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Home</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="./assest/css/utils/footer.css">
        <link rel="stylesheet" href="./assest/css/base/index.css"/>
        <link rel="stylesheet" href="./assest/css/utils/base.css"/>
    </head>
    <body>
        <div id="header">
            <s:include value="../util/header.jsp"/>
        </div>
        <div id="content" class="container">
            <div class="search-form">
                <form class="form-inline justify-content-end" method="get" action="/Library/search">
                    <input class="form-control mr-sm-2" name="keyword" type="text" placeholder="Search for books" width="200px">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
            <s:if test="%{keyword!=null}">
                <h1 class="text-center">You search for <s:property value="keyword" /></h1>
                <s:if test="%{bookList.size() == 0}">
                    <h1 class="text-center">Not found </h1>
                    <footer class="fixed-bottom">
                        <s:include value="../util/footer.jsp"/>
                    </footer>
                </s:if>
                <s:else>
                    <div class="all-books d-flex">
                        <s:iterator value="bookList" id="book">
                            <a href="/Library/bookDetail?bookID=<s:property value='#book.id'/>" class="col-3">
                                <div class="card book">
                                    <img class="card-img-top"src="<%=request.getContextPath()%>/<s:property value='#book.image'/>" alt="Book image" height="331px">
                                    <div class="card-body">
                                        <p class="card-text"><s:property value="#book.name" /></p>
                                        <p class="card-text">Author: ${book.author}</p>
                                    </div>
                                </div>
                            </a>
                        </s:iterator>
                    </div>
                </div>
            <footer>
                <s:include value="../util/footer.jsp"/>
            </footer>
        </s:else>
    </s:if>
    <s:else>
        <h1 class="text-center">All books</h1>
        <div class="all-books d-flex">
            <s:iterator value="bookList" id="book">
                <a href="/Library/bookDetail?bookID=<s:property value='#book.id'/>" class="col-3">
                    <div class="card book">
                        <img class="card-img-top"src="<%=request.getContextPath()%>/<s:property value='#book.image'/>" alt="Book image" height="331px">
                        <div class="card-body">
                            <p class="card-text"><s:property value="#book.name" /></p>
                            <p class="card-text">Author: ${book.author}</p>
                        </div>
                    </div>
                </a>
            </s:iterator>
        </div>
    </div>
    <footer>
        <s:include value="../util/footer.jsp"/>
    </footer>
</s:else>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>