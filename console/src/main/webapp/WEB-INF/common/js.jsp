<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<script src="${contextPath}/assets/js/ace-extra.min.js"></script>
<script src="${contextPath}/assets/js/jquery-2.1.4.min.js"></script>
<script src="${contextPath}/assets/js/bootstrap.min.js"></script>
<script src="${contextPath}/assets/js/bootbox.js"></script>
<script src="${contextPath}/assets/js/ace.min.js"></script>
<script src="${contextPath}/assets/js/jquery-ui.min.js"></script>

<!-- page specific plugin scripts -->
<script src="${pageContext.request.contextPath}/assets/js/bootstrap-datepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.jqGrid.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/grid.locale-en.js"></script>

<script type="text/javascript" src="${contextPath}/component/common.js"></script>
<script type="text/javascript">
    var contextPath = "${pageContext.request.contextPath}";
</script>