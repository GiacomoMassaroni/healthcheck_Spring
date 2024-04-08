<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
	<%@ page import = "it.contrader.dto.UrineTestDTO"%>

<!DOCTYPE html>
<html>
<head>
<title>UrineTest Manager</title>
    <meta charset="ISO-8859-1">
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


<div class=" container">
<nav  class="navbar px-3 mx-5 rounded-bottom " style="background-color: #e3f2fd;">
  <div class="container-fluid d-flex justify-content-center">
    <div class="d-flex justify-content-center" id="navbarSupportedContent">

      <%if(user.getUsertype().toString().equals("USER")){ %>

      <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
        Inserisci
      </button>


      <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalLabel">Aggiungi Referto</h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/urinetest/insert" method="post">

            <div class="modal-body">

             		<h1 id="title"> Inserisci </h1>

             		<input type="hidden" name="isChecked" value=false>
             		<input type="hidden" name="idUser" value="<%=user.getId()%>">
             		<div class="mb-3">
                      <label for="color" class="form-label">Inserisci Colore </label>
                      <input type="number" step="any" id="color" name="color" min="1" max="10" placeholder="Inserisci il colore..." required class="form-control">
                    </div>
                    <div class="mb-3">
                       <label for="user" class="form-label">Inserisci PH </label>
                       <input type="number" step="any" id="ph" name="ph" min="0" max="14" placeholder="Inserisci il ph..." required class="form-control">
                    </div>
                    <div class="mb-3">
                      <label for="pass" class="form-label">Inserisci Proteine </label>
                       <input type="number" step="any" id="protein" name="protein" min="0" max="35" placeholder="Inserisci le proteine..." required class="form-control">
                    </div>
                     <div class="mb-3">
                        <label for="pass" class="form-label">Emoglobina </label>
                        <input class="form-control" type="number" step="any" id="hemo" name="hemoglobin" min="0" max="50" placeholder="Inserisci Emoglobina..." required>
                     </div>
                    <div class="mb-3">
                      <label for="pass" class="form-label">Dottore</label>
                      <input class="form-control" type="number" id="idA" name="idAdmin" placeholder="Inserisci Id Dottore..." required>
                    </div>
                     <div class="mb-3">
                        <label for="pass" class="form-label">Inserisci Data </label>
                        <input class="form-control" type="date" id="data" name="dateInsert" placeholder="Inserisci Data..." required>
                     </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Chiudi</button>
              <button type="submit" class="btn btn-primary">Inserisci</button>
            </div>
            </form>
          </div>
        </div>
      </div>
<% } %>
      <form class="d-flex mx-3" action="/urinetest/search" method="get">
               <select id="type" name="month" class="form-select me-2 w-50" aria-label="Search">
                      <option value="01">Gennaio</option>
                      <option value="02">Febbraio</option>
                      <option value="03">Marzo</option>
                      <option value="04">Aprile</option>
                      <option value="05">Maggio</option>
                      <option value="06">Giugno</option>
                      <option value="07">Luglio</option>
                      <option value="08">Agosto</option>
                      <option value="09">Settembre</option>
                      <option value="10">Ottobre</option>
                      <option value="11">Novembre</option>
                      <option value="12">Dicembre</option>
           </select>

        <input class="form-control me-2 w-25" type="number" name="year" placeholder="Anno" aria-label="Search" min="2000" required>
        <button class="btn btn-outline-primary" type="submit">Cerca</button>
      </form>
    </div>
  </div>
</nav>




<div class="main  d-flex flex-column justify-content-center align-items-center mvh-100">
	<%
		List<UrineTestDTO> list = (List<UrineTestDTO>) request.getSession().getAttribute("list");
	%>

    <h1 class="my-5 text-center" style="color: #002B7E;">Esami urine</h1>

	<table class="table table-hover mx-3">
		<thead>
			<tr>
			    <th class="text-primary-emphasis" scope="col">Referto</th>
					<th class="text-primary-emphasis" scope="col">
                		<%if( user.getUsertype().toString().equals("ADMIN") ){%>
                		Paziente
                		<%} else if(user.getUsertype().toString().equals("USER")){%>
                        Dottore
                		<%} else {%>
                		Dottore
                        </th>
                        <th>
                        Paziente
                        <%}%>
                		</th>

                <th class="text-primary-emphasis" scope="col">Stato</th>
                <th class="text-primary-emphasis" scope="col">Data</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<%
			for (UrineTestDTO u : list) {
		%>
		<tr>
			<th scope="row">
				<%=u.getId()%>
			</th>
            <td>
                <%if(user.getUsertype().toString().equals("ADMIN") ) { %>
                    <%=u.getIdUser()%>
                <% } else if(user.getUsertype().toString().equals("USER")) { %>
                    <%=u.getDoctorName()%>
                <% } else { %>
                    <%=u.getIdAdmin()%>
                    </td>
                    <td>
                    <%=u.getIdUser()%>
                <%}%>
            </td>

            <td>
                <%if(u.getIsChecked()){ %>
                    Validato
                <% } else { %>
                    Da validare
                <%}%>
            </td>

            <td><%=u.getDateInsert()%></td>

			<td class="d-flex justify-content-end">
			<a class="btn btn-outline-success mx-1" href="/urinetest/read?id=<%=u.getId()%>">Visualizza</a>



			<%if(!u.getIsChecked()){%>
                <a class="btn btn-outline-primary mx-1" href="/urinetest/preupdate?id=<%=u.getId()%>">Modifica</a>

                   <!-- Button trigger modal -->
                        <button type="button" class="btn btn-outline-danger mx-1" data-bs-toggle="modal" data-bs-target=#modalDelete<%=u.getId()%>>
                          Cancella
                        </button>

                        <!-- Modal -->
                        <div class="modal fade" id=modalDelete<%=u.getId()%> tabindex="-1" aria-labelledby=modalDelete<%=u.getId()%> aria-hidden="true">
                          <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                              <div class="modal-header">
                                <h1 class="modal-title fs-5" id="exampleModalLabel">Elimina Referto</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                              </div>

                              <div class="modal-body">
                                <p>Sei sicuro di voler eliminare il referto?</p>
                              </div>
                              <div class="modal-footer">
                                <a class="btn btn-primary" href="/urinetest/delete?id=<%=u.getId()%>">Si</a>
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                              </div>

                            </div>
                          </div>
                        </div>
            <% } %>



                    <%if(!u.getIsChecked() && !user.getUsertype().toString().equals("USER")){%>
                        <form action="/urinetest/check" method="post">
                            <input type="hidden" name="id" value="<%=u.getId()%>">
                            <input type="hidden" name="color" value="<%=u.getColor()%>">
                            <input type="hidden" name="ph" value="<%=u.getPh()%>">
                            <input type="hidden" name="protein" value="<%=u.getProtein()%>">
                            <input type="hidden" name="hemoglobin" value="<%=u.getHemoglobin()%>">
                            <input type="hidden" name="idAdmin" value="<%=u.getIdAdmin()%>">
                            <input type="hidden" name="idUser" value="<%=u.getIdUser()%>">
                            <input type="hidden" name="isChecked" value="true">
                            <input type="hidden" name="dateInsert" value="<%=u.getDateInsert()%>">
                            <button type="submit" class="btn btn-outline-primary mx-1" >Valida</button>
                        </form>
                    <%}%>

            </td>

		</tr>
		</tbody>
		<%
			}
		%>
	</table>
</div>
</div>
<%@ include file="../css/footer.jsp" %>
</body>
</html>