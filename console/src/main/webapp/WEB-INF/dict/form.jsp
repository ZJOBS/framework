<%--
  Created by IntelliJ IDEA.
  User: jiezhang
  Date: 2017/9/25
  Time: 下午10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form class="form-horizontal" role="form" enctype="multipart/form-data">
    <div class="form-group hide">
        <label class="col-sm-3 control-label no-padding-right">父编号</label>
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

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right">启用</label>
        <div class="col-xs-3">
            <label>
                <input name="activating" class="ace ace-switch ace-switch-4" type="checkbox">
                <span class="lbl"></span>
            </label>
        </div>
    </div>
</form>
</body>
</html>