<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"></jsp:include>
<!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Droits</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Liste des Droits</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Identifiant</th>
                                            <th>Droit</th>
                                            <th>Users Name</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Identifiant</th>
                                            <th>Droit</th>
                                            <th>Users Name</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                    	<c:forEach var="droit" items="${listDroit}">
											<tr>
												<td><c:out value="${droit.id}" /></td>
												<td><c:out value="${droit.name}" /></td>
												<td>
												<c:choose>
												  <c:when test="${droit.comptes[0] != null}">
												  	<c:out value="||" />
												    <c:forEach var="compte" items="${droit.comptes}" >
																	<c:out value="${compte}" /> <c:out value="||" />
														</c:forEach>
												  </c:when>
												  <c:otherwise>
												    Droit non Attribué
												  </c:otherwise>
												</c:choose>
												
												</td>
					
											</tr>
										</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->


<jsp:include page="../footer.jsp"></jsp:include>
		