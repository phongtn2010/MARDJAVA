<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!-- BEGIN HEADER MENU -->
<div class="page-header-menu">
    <div class="container-fluid">         
        <div class="hor-menu  ">
            <ul class="nav navbar-nav">
                <c:forEach items="${tabs}" var="tab">
                    <li class="menu-dropdown classic-menu-dropdown">
                        <a href="${tab.tabPath}">                            
                            ${tab.tabName}
                            <span class="arrow"></span>
                        </a>
                        <c:if test="${tab.children != null}">
                            <ul class="dropdown-menu pull-left">
                                <c:forEach items="${tab.children}" var="tabChild1">
                                    <c:if test="${tabChild1.children != null}">
                                        <li class="dropdown-submenu submenu-after">
                                            <a href="${tabChild1.tabPath}" class="nav-link nav-toggle ">
                                                ${tabChild1.tabName}
                                                <span class="arrow"></span>
                                            </a> 
                                            <ul class="dropdown-menu pull-left">
                                                <c:forEach items="${tabChild1.children}" var="tabChild2">
                                                    <c:if test="${tabChild2.children != null}">
                                                        <li class="dropdown-submenu submenu-after">
                                                            <a href="${tabChild2.tabPath}" class="nav-link nav-toggle ">
                                                                ${tabChild2.tabName}
                                                                <span class="arrow"></span>   
                                                            </a>

                                                            <ul class="dropdown-menu">
                                                                <c:forEach items="${tabChild2.children}" var="tabChild3">
                                                                    <li class="">
                                                                        <a href="${tabChild3.tabPath}" class="nav-link "> ${tabChild3.tabName} </a>
                                                                    </li>
                                                                </c:forEach>
                                                            </ul>
                                                        </li>
                                                    </c:if>
                                                    <c:if test="${tabChild2.children == null}">
                                                        <li class="dropdown-submenu">
                                                            <a href="${tabChild2.tabPath}" class="nav-link nav-toggle ">
                                                                ${tabChild2.tabName}
                                                                <span class="arrow"></span>   
                                                            </a>
                                                        </li>
                                                    </c:if>
                                                </c:forEach>
                                            </ul>
                                        </li>
                                    </c:if>
                                    <c:if test="${tabChild1.children == null}">
                                        <li class="dropdown-submenu">
                                            <a href="${tabChild1.tabPath}" class="nav-link nav-toggle ">
                                                ${tabChild1.tabName}
                                                <span class="arrow"></span>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </c:if>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>