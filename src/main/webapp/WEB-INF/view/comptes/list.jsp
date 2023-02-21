<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"></jsp:include>
<!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Comptes</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Liste des Comptes</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Identifiant</th>
                                            <th>User Name</th>
                                            <th>Password</th>
                                            <th>Droits</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Identifiant</th>
                                            <th>User Name</th>
                                            <th>Password</th>
                                            <th>Droits</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
										<c:forEach var="compte" items="${listCompte}">
					
											<tr>
												<td><c:out value="${compte.id}" /></td>
												<td><c:out value="${compte.userName}" /></td>
												<td><c:out value="${compte.password} " /></td>
												<td>
												<c:choose>
												  <c:when test="${compte.droits[0] != null}">
												  	<c:out value="||" />
												    <c:forEach var="droit" items="${compte.droits}" >
																	<c:out value="${droit}" /> <c:out value="||" />
														</c:forEach>
												  </c:when>
												  <c:otherwise>
												    Compte sans droit
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