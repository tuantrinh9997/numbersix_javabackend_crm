<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="root" value="${pageContext.request.contextPath }" />
<!-- App Settings FAB -->
<div id="app-settings" hidden>
    <app-settings layout-active="fixed" :layout-location="{
  'default': 'index.html',
  'fixed': 'dashboard.html',
  'fluid': 'fluid-dashboard.html',
  'mini': 'mini-dashboard.html'}">
    </app-settings>
</div>
<!-- jQuery -->
<script src="${root}/assets/vendor/jquery.min.js"></script>

<!-- Bootstrap -->
<script src="${root}/assets/vendor/popper.min.js"></script>
<script src="${root}/assets/vendor/bootstrap.min.js"></script>

<!-- Perfect Scrollbar -->
<script src="${root}/assets/vendor/perfect-scrollbar.min.js"></script>

<!-- DOM Factory -->
<script src="${root}/assets/vendor/dom-factory.js"></script>

<!-- MDK -->
<script src="${root}/assets/vendor/material-design-kit.js"></script>

<!-- App -->
<script src="${root}/assets/js/toggle-check-all.js"></script>
<script src="${root}/assets/js/check-selected-row.js"></script>
<script src="${root}/assets/js/dropdown.js"></script>
<script src="${root}/assets/js/sidebar-mini.js"></script>
<script src="${root}/assets/js/app.js"></script>

<!-- App Settings (safe to remove) -->
<script src="${root}/assets/js/app-settings.js"></script>

<!-- Flatpickr -->
<script src="${root}/assets/vendor/flatpickr/flatpickr.min.js"></script>
<script src="${root}/assets/js/flatpickr.js"></script>

<!-- Global Settings -->
<script src="${root}/assets/js/settings.js"></script>