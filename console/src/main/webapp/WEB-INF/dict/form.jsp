<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<html>
<body>
<form class="form-horizontal" role="form" enctype="multipart/form-data">
    <div class="form-group hide">
        <label class="col-sm-3 control-label no-padding-right">编号</label>
        <div class="col-sm-9">
            <input name="dictId" type="text" class="col-xs-10 col-sm-5">
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right">父编号</label>
        <div class="col-sm-9">
            <input name="parentId" type="text" class="col-xs-10 col-sm-5">
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right">编码</label>
        <div class="col-sm-9">
            <input name="code" type="text" class="col-xs-10 col-sm-5">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right">名称</label>
        <div class="col-sm-9">
            <input name="name" type="text" class="col-xs-10 col-sm-5">
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right">值</label>
        <div class="col-sm-9">
            <input name="value" type="text" class="col-xs-10 col-sm-5">
        </div>
    </div>
    <zj:iswitch name="activating" text="激活"></zj:iswitch>
</form>
</body>
</html>
