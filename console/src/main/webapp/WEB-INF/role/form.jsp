<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<html>
<body>
<form class="form-horizontal" role="form">
    <zj:iinput name="roleId" text="编号" hide="hide"/>
    <zj:iinput name="name" text="角色名称"/>
    <zj:iswitch name="activating" text="激活"></zj:iswitch>
    <zj:iinput name="description" text="描述"/>
</form>
</body>
</html>
