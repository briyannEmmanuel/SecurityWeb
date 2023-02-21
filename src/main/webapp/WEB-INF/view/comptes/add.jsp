<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"></jsp:include>

	
	<div class="container col-md-5"> 
         <div class="card"> 
             <div class="card-header">
                 <h6 class="m-0 font-weight-bold text-primary">Formulaire d'ajout de Compte</h6>
             </div>
		
			 <form method="post" >
			 
                   <!-- User Name -->
                   
                   <div class="form-floating mb-3">   
                   	<input class="form-control" id="libelle" type="text" name="username" placeholder="User Name" required autofocus/>
                   </div>
                   <!-- Password -->
                   
                   <div class="form-floating mb-3">   
                   	<input class="form-control" id="libelle" type="password" name="password" placeholder="Password" required autofocus/>
                   </div>
				  <div class="form-floating mb-3">
				    <select id="disabledSelect" class="form-contol" multiple aria-label="multiple select" name="droit">
						<c:forEach var="droit" items="${listdroit}">
				
						  <option class="form-control" value='<c:out value="${droit.id}" />'><c:out value="${droit.name}" /></option>
						</c:forEach>
					 </select>
				  </div>
                       <!-- Bouton  Ajouter-->

                  <div class="flex items-center justify-end mt-4">
                      <input type="submit" class="btn btn-primary" value="Ajouter"/>
                  </div>
			 </form>
			 
         </div>
     </div>
           
<jsp:include page="../footer.jsp"></jsp:include>