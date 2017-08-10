<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="/WEB-INF/common/index.jsp"></jsp:include>
    <meta charset="UTF-8">
    <title>商品</title>
    <style type="text/css">
        #page_button {
            position: relative;
            top: 350px;
        }

        .context {
            width: 98%;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
    <script type="text/javascript">
    </script>
</head>
<body>
<jsp:include page="/WEB-INF/common/header/index.jsp"></jsp:include>
<div class="context">

    <div id="button" class="form-inline">
        <div class="form-group">
            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#addModal">添加</button>
        </div>
    </div>

    <div id="search" class="form-inline">
        <div class="form-group">
            <label for="name">姓名</label>
            <input id="name" name="name" type="text" class="form-control">
        </div>
        <div class="form-group">
            <label for="type">类型</label>
            <input id="type" name="type" type="text" class="form-control">
        </div>
        <div class="form-group">
            <label for="isActivating">是否激活</label>
            <input id="isActivating" name="isActivating" type="text" class="form-control">
        </div>
        <div class="form-group">
            <a class="btn btn-info" href="#">搜索</a>
        </div>
    </div>
    <div class="table-responsive">
        <table class="table table-hover">
            <thead>
            <tr>
                <td>编号</td>
                <td>名称</td>
                <td>操作</td>
            </tr>
            </thead>
            <c:forEach var="product" items="${page.results}">
                <tr>
                <tr>
                    <td>${product.productId}</td>
                    <td>${product.name}</td>
                    <td><button type="button" class="btn btn-danger">删除</button></td>
                </div>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="page_button">
        <form class="form-inline">
            <div class="form-group">
                <c:choose>
                    <c:when test="${page.currentPage<=1}">
                        <a class="btn btn-default" disabled="disabled" href="#">上一页</a>
                    </c:when>
                    <c:when test="${page.currentPage>1}">
                        <a class="btn btn-info" href="queryUser.do?currentPage=${page.currentPage-1}">上一页</a>
                    </c:when>
                </c:choose>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" value="${page.currentPage }"/>
            </div>
            <div class="form-group">
                <c:choose>
                    <c:when test="${page.currentPage<page.totalPage}">
                        <a class="btn btn-info" href="queryUser.do?currentPage=${page.currentPage+1}">下一页</a>
                    </c:when>
                    <c:when test="${page.currentPage>=page.totalPage}">
                        <a class="btn btn-default" disabled="disabled" href="#">下一页</a>
                    </c:when>
                </c:choose>
            </div>
        </form>
    </div>
</div>


<!-- add -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form class="form-horizontal" action="${pageContext.request.contextPath}/product/add.do"
                  enctype="multipart/form-data">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="addModalLabel">添加商品</h4>
                </div>

                <%--具体添加的参数--%>

                <div class="modal-body">
                    <div class="form-group">
                        <label for="input_Name" class="col-sm-2 control-label">商品名称</label>

                        <div class="col-sm-4">
                            <input name="name" type="name" class="form-control" id="input_Name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="input_price" class="col-sm-2 control-label">价格</label>

                        <div class="col-sm-4">
                            <input name="price" type="text" class="form-control" id="input_price">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="input_categoryId" class="col-sm-2 control-label">类别</label>

                        <div class="col-sm-4">
                            <input name="categoryId" type="text" class="form-control" id="input_categoryId">
                        </div>
                    </div>
                    <%--<div class="form-group">--%>
                    <%--<label for="input_File" class="col-sm-2 control-label">图片</label>--%>
                    <%--<div class="col-sm-4">--%>
                    <%--<input type="file" id="input_File">--%>
                    <%--</div>--%>
                    <%--</div>--%>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button id="addSave" type="submit" class="btn btn-primary">保存</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>