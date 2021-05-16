<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Chaofan
  Date: 2021/5/15
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示页面</title>
    <link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header"></div>
            <h1>
                <small> 新增书籍 </small>
            </h1>
        </div>
    </div>
    <%--
    Request processing failed; nested exception is
            org.springframework.dao.DataIntegrityViolationException:
            未设置name属性，报错
    --%>
    <form action="${pageContext.request.contextPath}/book/addBook" method="post">
        <div class="form-group">
            <label for="bookName"> 书籍名称 </label>
            <input type="text" class="form-control" name="bookName" id="bookName" placeholder="书籍名称">
        </div>
        <div class="form-group">
            <label for="bookCounts"> 书籍数目 </label>
            <input type="text" class="form-control" name="bookCounts" id="bookCounts" placeholder="书籍数目">
        </div>

        <div class="form-group">
            <label for="detail"> 书籍细节 </label>
            <input type="text" class="form-control" name="detail" id="detail" placeholder="书籍细节">
        </div>
        <input type="submit" class="form-control" value="添加"/>
    </form>
</div>

</body>
</html>
