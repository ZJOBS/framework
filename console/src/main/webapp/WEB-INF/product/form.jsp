<%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form class="form-horizontal" role="form" enctype="multipart/form-data">
    <zj:input name="productId" text="产品编号" hide="hide"/>
    <zj:input name="name" text="产品名称"/>
    <zj:input name="type" text="类别" hide="hide"/>
    <zj:switch name="state" text="状态"/>
    <zj:file name="file" text="图片"/>
</form>
</body>
</html>
