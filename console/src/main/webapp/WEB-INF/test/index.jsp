<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>Product</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <jsp:include page="/WEB-INF/common/style.jsp"/>
    <jsp:include page="/WEB-INF/common/js.jsp"/>

    <script>
        /*是否可以变为调用数据字典生成此方法*/
        function formatState(data, type, full) {
            return data == 0 ? '禁用' : '启用';
        };

        function formatImage(data, type, full) {
            var URL = "http://omjgaayha.bkt.clouddn.com/" + data;
            return "<img src='" + URL + "' height='50' width='50'/>"
        };
    </script>


</head>

<body class="no-skin">

<div class="main-container ace-save-state">
    <div class="main-content">
        <div class="main-content-inner">
            <div class="page-content">
                <div class="clearfix">
                    <div class="pull-right tableTools-container"></div>
                </div>
                <form class="form-horizontal" role="form" enctype="multipart/form-data">
                    <%--已完成--%>
                    <zj:iselect name="国家" code="COUNTRY"></zj:iselect>

                    <zj:icheckbox name="国家" code="COUNTRY"></zj:icheckbox>

                    <zj:iradio name="国家" code="COUNTRY"></zj:iradio>
                    <zj:iswitch name="activating"></zj:iswitch>
                    <button id="test_ben" type="button"
                            class="btn btn-minier ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"
                            role="button"><span class="ui-button-text"><i class="ace-icon fa fa-trash-o bigger-110"></i>保存</span>
                    </button>
                </form>
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->
</div><!-- /.main-container -->


</body>
</html>
