import React from "react";
import { Link } from "react-router-dom";
import { FaSearch } from "react-icons/fa";
import { CiDeliveryTruck, CiUser, CiShoppingBasket } from "react-icons/ci";
import { CiSearch } from "react-icons/ci";

export const Navbar = () => {
	return (
		<nav className="navbar navbar-light bg-light shadow ">
			<div className=" col">
				<div className="nav-despacho d-flex justify-content-center">
				<CiDeliveryTruck />
					<span className="px-1">Despacho gratis por compras sobre $0000</span>
				</div>

				<div className="d-flex  justify-content-between">
					{/* ESTA PARTE ES FIXED O STICKY */}
					<Link to="/" className="navbar-brand">
						<h3 className="logo">OPAL</h3>
					</Link>
					<div className="d-flex justify-content-between align-items-center">
						<form class="d-flex justify-content-between" role="search">
							<input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
							<FaSearch className="m-4" />
						</form>
						<div>
							<CiDeliveryTruck className="nav-iconos mx-4" />
							<CiUser  className="nav-iconos  mx-4" />
							<CiShoppingBasket  className="nav-iconos  mx-4" />
						</div>
					</div>


				</div>
				<div className="nav-categorias ">
					<div>NEW</div>
					<div>HOMBRE</div>
					<div>MUJER</div>
					<div>ACCESORIOS</div>
					<div>SALE</div>

				</div>


			</div>

			{/* <div className="ml-auto">
				<Link to="/demo">
					<button className="btn btn-primary">Check the Context in action</button>
				</Link>
			</div> */}
		</nav>
	);
};
