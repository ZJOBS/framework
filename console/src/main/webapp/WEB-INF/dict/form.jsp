<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<html>
<body>
<form class="form-horizontal" role="form">
    <zj:iinput name="dictId" text="编号" hide="hide"/>
    <zj:iinput name="parentId" text="父编号"/>
    <zj:iinput name="code" text="编码"/>
    <zj:iinput name="name" text="名称"/>
    <zj:iinput name="value" text="值"/>
    <zj:iswitch name="activating" text="激活"></zj:iswitch>
</form>
</body>
</html>
