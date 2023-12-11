import React from "react";
import { Link } from "react-router-dom";
import { FaSearch } from "react-icons/fa";
import { CiDeliveryTruck, CiUser, CiShoppingBasket } from "react-icons/ci";
import OffCanvaCarritoRight from "./offCanvaCarritoRight.jsx";
import LoginModal from "./loginModal.jsx";



export const Navbar = () => {
	return (
		<nav className="navbar navbar-light bg-light shadow py-0">
			<div className=" col">
				<div className="nav-despacho d-flex justify-content-center">
					<CiDeliveryTruck />
					<span className="px-1">Despacho gratis por compras sobre $0000</span>
				</div>

				<div className="d-flex align-items-end justify-content-between">
					{/* ESTA PARTE ES FIXED O STICKY */}
					<Link to="/" className="navbar-brand">
						<h3 className="logo">OPAL</h3>
					</Link>
					<div className="d-flex justify-content-between align-items-center">
						<form className="d-flex justify-content-between " role="search">
							<input className="form-control nav-search-form" type="search" placeholder="BUSCA TU PRODUCTO" aria-label="Search" />
							<FaSearch className="m-4" />
						</form>
						<div>
							<Link to="/SeguimientoPedido" className="linkStyle">
								<CiDeliveryTruck className="nav-iconos mx-4 linkStyle" />
                            </Link>
							<LoginModal className="nav-iconos mx-4" />
							{/* <CiUser  className="nav-iconos  mx-4" /> */}
							<OffCanvaCarritoRight />
							{/* <CiShoppingBasket  className="nav-iconos  mx-4" /> */}
						</div>
					</div>


				</div>
				<div className="nav-categorias ">
					{/* <div>NEW</div>
					<div>HOMBRE</div>
					<div>MUJER</div>
					<div>ACCESORIOS</div>
					<div>SALE</div> */}
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

			{/* <div className="ml-auto">
				<Link to="/demo">
					<button className="btn btn-primary">Check the Context in action</button>
				</Link>
			</div> */}
		</nav>
	);
};
