<%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<html>
<body>
    <form class="form-horizontal" role="form">
    <zj:iinput name="menuId" text="编号" hide="hide"/>
        <zj:iinput name="parentId" text="父编号"/>
        <zj:iinput name="name" text="名称"/>
        <zj:iinput name="url" text="URL"/>
        <zj:iinput name="image" text="image"/>
            <zj:iswitch name="activating" text="启用"/>
            <zj:iswitch name="leaf" text="子节点"/>
    </form>
</body>
</html>
