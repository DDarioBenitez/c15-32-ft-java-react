import React from "react";
import { Link } from "react-router-dom";
import { FaSearch } from "react-icons/fa";
import { CiDeliveryTruck, CiUser, CiShoppingBasket } from "react-icons/ci";
import { HiOutlineTruck } from "react-icons/hi2";
import OffCanvaCarritoRight from "../carrito/offCanvaCarritoRight.jsx";
import LoginModal from "./loginModal.jsx";



export const Navbar = () => {
	return (
		<nav className="navbar navbar-light bg-light shadow py-0">
			<div className=" col">
				{/* primer navbar DESPACHO */}

				<div className="nav-despacho d-flex justify-content-center">
					<CiDeliveryTruck />
					<span className="px-1">Despacho gratis por compras sobre $20.000</span>
				</div>

				{/* segundo navbar NAV MENU */}

				<div className="d-flex align-items-end justify-content-between">
					{/* ESTA PARTE ES FIXED O STICKY */}
					<Link to="/" className="navbar-brand ms-2">
						<h3 className="logo">OPAL</h3>
					</Link>
					<div className="d-flex justify-content-between align-items-center">
						{/* busqueda de productos */}
						<form className="d-flex justify-content-between " role="search">
							<input className="form-control nav-search-form" type="search" placeholder="BUSCA TU PRODUCTO" aria-label="Search" />
							<FaSearch className="m-4" />
						</form>
						<div>
							{/* lleva a vista seguimiento de pedido  */}
							<Link to="/SeguimientoPedido" className="linkStyle">
								<button type="button" className="btn ">
									<CiDeliveryTruck className="nav-iconos fs-5 " />
								</button>
							</Link>
							{/* loginmodal tiene que mostrar micuenta o log In  */}
							<LoginModal className="nav-iconos " />
							{/* despliega carrito de compras */}
							<OffCanvaCarritoRight className="nav-iconos" />
						</div>
					</div>

				</div>

				{/* Tercer navbar COLECCIONES */}

				<div className="nav-categorias ">

					<Link to="/new" className="linkStyle">
						<div>NEW</div>
					</Link>

					<Link to="/hombre" className="linkStyle">
						<div>HOMBRE</div>
					</Link>

					<Link to="/mujer" className="linkStyle">
						<div>MUJER</div>
					</Link>

					<Link to="/accesorios" className="linkStyle">
						<div>ACCESORIOS</div>
					</Link>

					<Link to="/sale" className="linkStyle">
						<div>SALE</div>
					</Link>

				</div>
			</div>

		</nav>
	);
};
