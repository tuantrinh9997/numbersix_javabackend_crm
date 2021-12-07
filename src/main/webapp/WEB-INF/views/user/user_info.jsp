<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<body>
	<div class="container page__heading-container">
		<div class="page__heading">
			<div class="d-flex align-items-center">
				<div>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb mb-0">
							<li class="breadcrumb-item"><a href="${root}/user">User</a></li>
							<li class="breadcrumb-item active" aria-current="page">Find
							</li>
						</ol>
					</nav>
					<h1 class="m-0">Information user</h1>
				</div>

			</div>
		</div>
	</div>
	<div class="container page__container">
		<h1>Name: ${user.name}</h1>
		<h1>Emai: ${user.email}</h1>
		<h1>Password: ${user.password}</h1>
		<h1>Phone: ${user.phone}</h1>
		<h1>Address: ${user.address}</h1>
		<h1>Chuc vu: ${user.role.name}</h1>
		<h1>Description: ${user.role.description}</h1>
	</div>
</body>
