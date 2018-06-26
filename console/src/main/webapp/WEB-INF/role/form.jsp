<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<html>
<body>
<form class="form-horizontal" role="form" enctype="multipart/form-data">
    <div class="form-group hide">
        <label class="col-sm-3 control-label no-padding-right"> 产品名称 </label>
        <div class="col-sm-9">
            <input name="roleId" type="text" class="col-xs-10 col-sm-5">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right">角色名称</label>
        <div class="col-sm-9">
            <input name="name" type="text" class="col-xs-10 col-sm-5">
        </div>
    </div>
    <zj:iswitch name="activating" text="激活"></zj:iswitch>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right">描述</label>
        <div class="col-xs-12 col-sm-5">
            <textarea name="description" class="form-control" rows="3"></textarea>
        </div>
    </div>
</form>
</body>
</html>
