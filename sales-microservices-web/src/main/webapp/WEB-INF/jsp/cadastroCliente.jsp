<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-BR">
<body>

	<jsp:include page="header.jsp" />

	<h1>Cadastro</h1>

	<div class="containerCadastro">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">x</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>
		
		<button type="button" id="buttonSearch" class="btn btn-info" onclick="location.href='/clientes'">
				<span class="glyphicon glyphicon-search"></span> Pesquisar Clientes
			</button><br><br>

		<div class="starter-template">
			<form:form class="form-horizontal" method="post"
				modelAttribute="cliente" action="/salvarCliente">

				<spring:bind path="nome">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Nome</label>
						<div class="col-sm-4">
							<form:input path="nome" type="text" class="form-control"
								id="nome" placeholder="Nome" />
							<form:errors path="nome" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<spring:bind path="cpfCnpj">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">CPF / CNPJ</label>
						<div class="col-sm-4">
							<form:input path="cpfCnpj" type="text" class="form-control"
								id="cpfCnpj" placeholder="CPF / CNPJ" maxlength="14" />
							<form:errors path="cpfCnpj" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<spring:bind path="tipoPessoa">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Tipo Pessoa</label>
						<div class="col-sm-4">
							<form:select path="tipoPessoa" class="form-control">
								<form:options items="${tiposPessoa}" />
							</form:select>
							<form:errors path="tipoPessoa" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<br />
				<h2>Dados Cadastrais</h2>
				<spring:bind path="telefone">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Telefone</label>
						<div class="col-sm-4">
							<form:input path="telefone" type="number"
								class="form-control" id="telefone" placeholder="Telefone" maxlength="8" />
							<form:errors path="telefone" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<spring:bind path="endereco">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Endereço</label>
						<div class="col-sm-4">
							<form:input path="endereco" type="text"
								class="form-control" id="endereco" placeholder="Endereço" />
							<form:errors path="endereco" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<spring:bind path="cidade">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Cidade</label>
						<div class="col-sm-4">
							<form:input path="cidade" type="text"
								class="form-control" id="cidade" placeholder="Cidade" />
							<form:errors path="cidade" class="control-label" />
						</div>
						<label class="col-sm-1 control-label">UF</label>
						<div class="col-sm-2">
							<form:select path="UF" class="form-control">
								<form:options items="${ufs}" itemLabel="estado" />
							</form:select>
							<form:errors path="UF" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<spring:bind path="email">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Email</label>
						<div class="col-sm-4">
							<form:input path="email" type="text"
								class="form-control" id="email" placeholder="Email" />
							<form:errors path="email" class="control-label" />
						</div>
					</div>
				</spring:bind>
				<spring:bind path="valorLimiteCredito">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Limite de Crédito</label>
						<div class="col-sm-4">
							<form:input path="cidade" type="number"
								class="form-control" id="valorLimiteCredito" placeholder="valorLimiteCredito" />
							<form:errors path="valorLimiteCredito" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<div class="form-group" style="text-align: center; padding: 0 0 0 35%">
						<button type="submit" class="btn-lg btn-primary pull-left" style="width: 200px; text-align: center;">Salvar</button>
				</div>
			</form:form>
		</div>
	</div>

</body>

</html>