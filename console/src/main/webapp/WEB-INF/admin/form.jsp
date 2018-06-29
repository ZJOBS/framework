<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<html>
<body>
<form class="form-horizontal" role="form" enctype="multipart/form-data">

    <zj:input name="adminId" text="管理员ID" hide="hide"/>
    <zj:input name="name" text="姓名"/>
    <zj:switch name="activating" text="激活"/>
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right">头像</label>
        <div class="col-xs-12 col-sm-5">
            <input name="file" type="file">
        </div>
    </div>
    <zj:input name="description" text="描述"/>
</form>
</body>
</html>
