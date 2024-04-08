<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="java.util.List"
         import="it.contrader.dto.UrineTestDTO"%>
         <%@ page import="it.contrader.dto.UserDTO" %>
         <%@ page import="java.time.LocalTime" %>
      <%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Esami delle Urine</title>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>
    <%UserDTO user = (UserDTO) request.getSession().getAttribute("user");%>

    <% if(user.getUsertype().toString().equals("USER")){ %>
        <%@ include file="../css/navbarUser.jsp" %>
    <% }else if(user.getUsertype().toString().equals("ADMIN")){ %>
          <%@ include file="../css/navbarAdmin.jsp" %>
    <% }else{ %>
           <%@ include file="../css/navbarSuper.jsp" %>
    <% } %>


<div class="main container d-flex justify-content-center align-items-center vh-100">


  <form class="w-75 my-3 border border-primary p-5 rounded-4" action="/urinetest/update" method="post">
  <%UrineTestDTO urineTest = (UrineTestDTO) request.getSession().getAttribute("dto");%>

    <h1 id="title" class="my-2 pb-3 d-flex justify-content-center" style="color: #002B7E;">Esami delle urine</h1>
        <input type="hidden" name="mode" value="update">
        <input type="hidden" name="idAdmin" value="<%=urineTest.getIdAdmin()%>">
        <input type="hidden" name="idUser" value="<%=urineTest.getIdUser()%>">
        <input type="hidden" name="id" value="<%=urineTest.getId()%>">
         <input type="hidden" name="isChecked" value="<%=urineTest.getIsChecked()%>">



        <div class="row mb-3">
            <label for="color" class="col-sm-2 col-form-label" style="color: #002B7E;">Colore</label>
            <div class="col-sm-10">
               <input type="number" step="any" id="color" name="color" min="1" max="10" value="<%=urineTest.getColor()%>" class="form-control">
            </div>
        </div>
          <div class="row mb-3">
            <label for="ph" class="col-sm-2 col-form-label">PH</label>
            <div class="col-sm-10">
               <input type="number" step="any" id="ph" name="ph" min="0" max="14" value="<%=urineTest.getPh()%>" class="form-control">
            </div>
          </div>
        <div class="row mb-3">
            <label for="protein" class="col-sm-2 col-form-label">Proteine</label>
            <div class="col-sm-10">
                <input type="number" step="any" id="protein" name="protein" min="0" max="35" value="<%=urineTest.getProtein()%>" class="form-control">
            </div>
        </div>
          <div class="row mb-3">
            <label for="hemoglobin" class="col-sm-2 col-form-label" style="color: #002B7E;">Emoglobina</label>
            <div class="col-sm-10">
              <input class="form-control" type="number" step="any" id="hemoglobin" name="hemoglobin" min="0" max="50" value="<%=urineTest.getHemoglobin()%>" class="form-control">
            </div>
          </div>
          <div class="row mb-3">

            <label for="dateInsert" class="col-sm-2 col-form-label" style="color: #002B7E;">Data</label>
            <div class="col-sm-10">
              <input class="form-control" type="date" id="dateInsert" name="dateInsert" class="form-control" value="<%= java.time.LocalDate.now() %>">
            </div>
          </div>


                <div class="button-wrapper d-flex justify-content-center">
                  <button type="submit" class="btn btn-primary btn-lg"  >Modifica dati</button>
                </div>
              </form>

            </div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>
