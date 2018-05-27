<%--
  Created by IntelliJ IDEA.
  User: jiezhang
  Date: 2017/9/25
  Time: 下午10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<html>
<body>

<form class="form-horizontal" role="form" enctype="multipart/form-data">
    <div class="form-group hide">
        <label class="col-sm-3 control-label no-padding-right"> 产品名称 </label>
        <div class="col-sm-9">
            <input name="adminId" type="text" class="col-xs-10 col-sm-5">
        </div>
    </div>


    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right">姓名</label>
        <div class="col-sm-9">
            <input name="name" type="text" class="col-xs-10 col-sm-5">
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right">激活</label>
        <div class="col-xs-3">
            <label>
                <input name="activating" class="ace ace-switch ace-switch-4" type="checkbox">
                <span class="lbl"></span>
            </label>
        </div>

        <%--<div class="col-xs-3">--%>
        <%--<label>--%>
        <%--<input name="activating" class="ace ace-switch ace-switch-4" type="checkbox">--%>
        <%--<span class="lbl"></span>--%>
        <%--</label>--%>
        <%--</div>--%>
    </div>


    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right">头像</label>
        <div class="col-xs-12 col-sm-5">
            <input name="file" type="file">
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right">描述</label>
        <div class="col-xs-12 col-sm-5">
            <textarea name="description" class="form-control" rows="3"></textarea>
        </div>
    </div>


    <%--<div class="form-group">--%>
        <%--<label class="col-sm-3 control-label no-padding-right">日期选择</label>--%>
        <%--<div class="col-xs-12 col-sm-5">--%>
            <%--<div class="input-append date date-picker">--%>
                <%--<input size="16" type="text" value="" readonly>--%>
                <%--<span class="add-on"><i class="icon-remove"></i></span>--%>
                <%--<span class="add-on"><i class="icon-calendar"></i></span>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>


    <%--<script type="text/javascript">--%>
        <%--$(function () {--%>
            <%--$(".date-picker").datetimepicker({--%>
                <%--language:'zh-CN',--%>
                <%--weekStart:1,--%>
                <%--todayHighlight:true,--%>
                <%--format: 'yyyymmddhhii',--%>
                <%--autoclose: true,--%>
                <%--pickerPosition: "bottom-right",--%>
            <%--});--%>
        <%--});--%>
    <%--</script>--%>
</form>
</body>
</html>
