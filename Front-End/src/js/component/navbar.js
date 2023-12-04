import React from "react";
import { Link } from "react-router-dom";
import { FaSearch } from "react-icons/fa";
import { CiDeliveryTruck, CiUser, CiShoppingBasket } from "react-icons/ci";
import { CiSearch } from "react-icons/ci";

export const Navbar = () => {
	return (
		<nav className="navbar navbar-light bg-light">
			<div className=" col">
				<div className="nav-despacho ">
					info despacho
				</div>

				<div className="d-flex bg-secondary justify-content-between">
					<Link to="/" className="navbar-brand">
						<h3 className="logo">OPAL</h3>
					</Link>
					<div className="d-flex">
						<form class="d-flex" role="search">
							<input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
							<FaSearch />
						</form>
						<div>
							<CiDeliveryTruck />
							<CiUser />
							<CiShoppingBasket />
						</div>
					</div>


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
