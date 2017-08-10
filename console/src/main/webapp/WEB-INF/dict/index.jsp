<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="/WEB-INF/common/index.jsp"></jsp:include>
    <meta charset="UTF-8">
    <title>HOME</title>

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/font-awesome/4.5.0/css/font-awesome.min.css"/>
    <!-- page specific plugin styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery-ui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-datepicker3.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ui.jqgrid.min.css"/>

    <!-- text fonts -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fonts.googleapis.com.css"/>

    <!-- ace styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.min.css" class="ace-main-stylesheet"
          id="main-ace-style"/>

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-part2.min.css"
          class="ace-main-stylesheet"/>
    <![endif]-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-skins.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-rtl.min.css"/>

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-ie.min.css"/>
    <![endif]-->

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
    <!-- page specific plugin scripts -->
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap-datepicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery.jqGrid.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/grid.locale-en.js"></script>
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
                        <zj:tablecolumn id="dict" caption="数据字典信息维护" queryurl="/queryDict.do"
                                        editurl="/updateOrDeleteDict.do"
                                        columntitle="'编号','编码','名称','值','是否启用'"
                                        columnname="{key:true,name:'dictId', index:'dictId', sorttype:'int', editable:false,hidden:true},{name: 'code', index: 'code', width: 150, editable: true, editoptions: {size: '20', maxlength: '30'}},{name: 'name',index: 'name',width: 70,editable: true,editoptions: {value: 'true:false'}},{name: 'value', index: 'value', width: 150, editable: true, editoptions: {size: '20', maxlength: '30'}},{name: 'activating',index: 'activating',width: 70,editable: true,edittype: 'checkbox',editoptions: {value: 'true:false'},unformat: aceSwitch}"
                                        columnformat="[{name:'activating',type:'checkbox'}]"></zj:tablecolumn>

                    </div>
                </div>
            </div>
            <!-- PAGE CONTENT ENDS -->
        </div><!-- /.col -->
    </div><!-- /.row -->
</div><!-- /.page-content -->
</div>
</div>
</body>
</html>