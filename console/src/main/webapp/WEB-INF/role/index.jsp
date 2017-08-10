<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="/WEB-INF/common/meta.jsp"/>
    <title>Role</title>
    <jsp:include page="/WEB-INF/common/style.jsp"/>
    <style type="text/css">
        /*#page_button {*/
        /*position: relative;*/
        /*top: 350px;*/
        /*}*/

        .context {
            width: 98%;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
    <jsp:include page="/WEB-INF/common/js.jsp"/>
</head>
<body class="no-skin">
<div class="page-content">
    <div class="page-header"></div><!-- /.page-header -->
    <div class="row">
        <div class="col-xs-12">
            <!-- PAGE CONTENT BEGINS -->
            <div class="row">
                <div class="col-xs-12">
                    <div>
                        <%--在这里添加select对象 ，以js对象存在，下面的columname中引入；使用不方便--%>
                        <zj:tablecolumn id="role" caption="菜单信息维护" queryurl="/queryRole.do"
                                        editurl="/updateOrDeleteRole.do"
                                        columntitle="'编号','名称','是否启用'"
                                        columnname="{key:true,name:'roleId', index:'roleId', sorttype:'int', editable:false,hidden:true},{name: 'name',index: 'name',width: 70,editable: true,editoptions: {value: 'true:false'}},{name: 'activating',index: 'activating',width: 70,editable: true,edittype: 'checkbox',editoptions: {value: 'true:false'},unformat: aceSwitch}"
                                        columnformat="[{name:'activating',type:'checkbox'}]"/>
                    </div>
                </div>
            </div>
            <!-- PAGE CONTENT ENDS -->
        </div><!-- /.col -->
    </div><!-- /.row -->
</div><!-- /.page-content -->
</body>
</html>