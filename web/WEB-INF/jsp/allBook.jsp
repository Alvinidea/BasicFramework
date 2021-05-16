<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <small> 书籍列表 ------ 显示所有书籍 </small>
            </h1>
        </div>
        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增书籍</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">查看所有书籍</a>
            </div>
            <div class="col-md-8 column">
                <form class="form-inline" action="${pageContext.request.contextPath}/book/queryBook" mothod="get">
                    <span style="color:red;font-weight: bold">${error}</span>
                    <input type="text" name="queryBookName" class="form-control" placeholder="请输入要查询的书籍名称"/>
                    <input type="submit" value="查询" class="btn btn-primary"/>
                </form>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                    <th> 编号</th>
                    <th> 名称</th>
                    <th> 数量</th>
                    <th> 详情</th>
                    <th> 操作</th>
                </thead>
                <tbody>
                    <c:forEach  items="${list}" var="book">
                        <tr>
                            <td>${book.bookID}</td>
                            <td>${book.bookName}</td>
                            <td>${book.bookCounts}</td>
                            <td>${book.detail}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/book/toUpdatePage?id=${book.bookID}" > 修改 </a>
                                 |
                                <a href="${pageContext.request.contextPath}/book/delBook/${book.bookID}" > 删除 </a>
                            </td>
                        </tr>
                    </c:forEach>
                <%--
                Q1：JSP中foreach可以获取到list值，但是不能迭代显示？？？
                    解决: 本页面首部添加：
                        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

                Q2：又出现：无法在web.xml或使用此应用程序部署的jar文件中解析绝对
                    uri：[http://java.sun.com/jsp/jstl/core]解决方法
                    解决:
                        1. Tomcat 中 D:\env\Tomcat\apache-tomcat-9.0.45\lib 中加入 jstl-1.2.jar
                        2. pom.xml 中加入 jstl-1.2.jar
                            <!-- jsp 的标签包 -->
                            <dependency>
                                <groupId>jstl</groupId>
                                <artifactId>jstl</artifactId>
                                <version>1.2</version>
                            </dependency>
                --%>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
