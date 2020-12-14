<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/views/pages/mic/03/template_table.jsp"></jsp:include>

<script type="text/javascript" src="<c:url value="/app/mic/04/i18n/language-en.js?v=${ version }"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/04/i18n/language-vi.js?v=${ version }"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/04/model/TbdHoSo04.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/04/model/TbdNguoiThamDinh04.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/04/model/TbdDinhKem04.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/04/model/HoSoDTO.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/04/model/KetQuaXuLy04DTO.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/04/model/SearchFormModel.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/04/model/TbdYeuCauSuaGP04.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/04/model/TbdDinhKemYCSGP04.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/03/module/md5.min.js"/>"></script>
