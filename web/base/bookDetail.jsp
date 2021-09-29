<%-- 
    Document   : bookDetail
    Created on : Sep 20, 2021, 3:04:56 PM
    Author     : sonthanhnguyen
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book detail</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="./assest/css/utils/footer.css">
        <link rel="stylesheet" href="./assest/css/utils/base.css">
        <link rel="stylesheet" href="./assest/css/base/bookDetail.css">
    </head>
    <body>
        <div id="header">
            <s:include value="../util/header.jsp"/>
        </div>
        <div id="content" class="container">
            <h1 class="text-center">Book detail</h2>
                <div class="book-detail mt-5">
                    <img src="<%=request.getContextPath()%>/<s:property value='image'/>" width="300px" height="500px">
                    <div class="book-info">
                        <div class="info-row">
                            <h2>Name</h2>
                            <p><s:property value="name"/></p>
                        </div>
                        <div class="info-row">
                            <h2>Author</h2>
                            <p>${author}</p>
                        </div>
                        <div class="info-row description">
                            <h2>Description</h2>
                            <p><s:property value="description"/></p>
                        </div>

                    </div>
                </div>
                <div class="mt-5">
                    <h4>User Comment</h4>
                </div>
                <s:iterator value="commentList" id="comment">
                    <div class="comment-row mt-2 ">
                        <div class="comment col-11">
                            <h5 class="user-comment">${comment.username}</h5>
                            <p class="contend-comment"><s:property value="#comment.commentContent" /></p>
                        </div>
                        <s:if test="%{#session.username.equals(#comment.username) or #session.isAdmin.equals('true') }">
                            <form action="deleteComment" method="post">
                                <input type="hidden" name="bookID" value="<s:property value="bookID" />" >
                                <input type="hidden" name="commentID" value="<s:property value='#comment.commentID'/>" >
                                <button type="submit" class="delete-button">                                
                                    <i  class="bi bi-trash mt-3 ml-5"></i>
                                </button>
                            </form>
                        </s:if>
                    </div>
                </s:iterator>
                <form action="createComment" method="post">
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">Your comment</label>
                        <input type="hidden" name="bookID" value="<s:property value="bookID" />" >
                        <input type="hidden" name="userID" value="<s:property value="%{#session.userID}"/>" >
                        <textarea class="form-control" name="commentContent" rows="3"></textarea>
                        <s:iterator value="actionMessages">
                            <s:property/><br/>
                        </s:iterator>
                        <s:iterator value="actionErrors">
                            <s:property/><br/>
                        </s:iterator>
                        <button type="submit" class="btn btn-primary mt-3">Comment</button>
                    </div>
                </form>

        </div>
        <footer class="">
            <s:include value="../util/footer.jsp"/>

        </footer>
    </body>
</html>
