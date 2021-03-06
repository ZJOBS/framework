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
        function formatActivating(data, type, full) {
            return data == 0 ? '禁用' : '启用';
        };

        function showMenu() {
            return "<a class='green showMenu' href='#' > <i class='ace-icon fa fa-bars bigger-130'></i> </a>";
        }
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
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-header">
                                    权限信息管理
                                </div>
                                <div>
                                    <div id="search" class="ibox-tools">
                                        <input placeholder="名称" id="name" type="text" name="name"
                                               class="col-xs-10 col-sm-1"/>
                                        <a id="btn_search" class="btn btn-primary btn-sm" href="javascript:void(0)"><i
                                                class="fa fa-search"></i>搜索</a>
                                        <a id="btn_clear_search" class="btn btn-primary btn-sm"
                                           href="javascript:void(0)"><i class="fa fa-search"></i>清空</a>
                                        <a id="add" class="btn btn-primary btn-sm" href="javascript:void(0)"><i
                                                class="fa fa-plus"></i>添加</a>
                                    </div>

                                    <zj:tableColumn id="role" key="roleId" defaultOperation="YES"
                                                    search="#search"
                                                    queryUrl="/queryRole.do"
                                                    addUrl="/addRole.do"
                                                    editUrl="/updateRole.do"
                                                    deleteUrl="/deleteRole.do"
                                                    columnTitle="编号,名称,是否启用"
                                                    columnName="{'mData': 'roleId'},{'mData': 'name'},{'mData': 'activating','type':'checkbox'}"
                                                    columnFormat="{'aTargets': 2, 'mRender': formatActivating}"
                                                    customOperation="showMenu()"
                                                    formId="dialog-confirm"
                                    />
                                </div>
                            </div>
                        </div>
                        <!-- PAGE CONTENT ENDS -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->

    <%--<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">--%>
    <%--<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>--%>
    <%--</a>--%>


    <div id="delete" class="hide">
        <div class="alert alert-danger bigger-110">
            确认要删除么？
        </div>
    </div>
    <div id="dialog-confirm" class="hide">
        <jsp:include page="/WEB-INF/role/form.jsp"/>
    </div>

    <div id="dialog-bindAndUnbind">
        <zj:bindAndUnbind id="roleBindMenu"
                          sourceTableId="role"
                          awakenPosition=".showMenu"
                          keyName="roleId"
                          relationName="menuId"
                          leftQueryUrl="/queryRoleBindMenu.do"
                          deleteUrl="/unbindRoleMenu.do"
                          rightQueryUrl="/queryRoleNotBindMenu.do"
                          addUrl="/bindRoleMenu.do"
                          columnTitle="编号,名称,地址,是否启用,是否子节点"
                          columnName="{'mData': 'menuId'},{'mData': 'name'},{'mData': 'url'},{'mData': 'activating'},{'mData': 'leaf','type':'checkbox'}"
        />
    </div>
</div><!-- /.main-container -->
</body>
</html>