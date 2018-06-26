<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<html>
<body>
    <form class="form-horizontal" role="form" enctype="multipart/form-data">
        <div class="form-group hide">
            <label class="col-sm-3 control-label no-padding-right"> 编号 </label>
            <div class="col-sm-9">
                    <input name="menuId" type="text" class="col-xs-10 col-sm-5">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label no-padding-right">父编号</label>
            <div class="col-sm-9">
                <input name="parentId" type="text" class="col-xs-10 col-sm-5">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label no-padding-right">名称</label>
            <div class="col-sm-9">
                    <input name="name" type="text" class="col-xs-10 col-sm-5">
            </div>
        </div>
            <div>
                    <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">URL</label>
                            <div class="col-sm-9">
                                    <input name="url" type="text" class="col-xs-10 col-sm-5">
                            </div>
                    </div>
            </div>
            <div>
                    <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">image</label>
                            <div class="col-sm-9">
                                    <input name="image" type="text" class="col-xs-10 col-sm-5">
                            </div>
                    </div>
            </div>

            <zj:iswitch name="activating" text="启用"/>
            <zj:iswitch name="leaf" text="子节点"/>
    </form>
</body>
</html>
