import React, { Component } from "react";
import OpalRrss from "./opalRrss.jsx";
import { Link } from "react-router-dom";

export const Footer = () => (
	<footer className="footer mt-auto pb-3 text-center d-flex flex-column">

		<OpalRrss />
		<div className="d-flex justify-content-center">
			<div className="justify-content-evenly">
			<p className="m-4 fw-lighter fs-6 ">
				<Link to="/hombre" className="p-link ">
					HOMBRE
				</Link>
			</p>

				<Link to="/mujer" className="p-link ">
					<p className="m-4 fw-lighter fs-6 ">MUJER</p>
				</Link>

				<Link to="/accesorios" className="p-link ">
					<p className="m-4 fw-lighter fs-6 ">ACCESORIOS</p>
				</Link>

				<Link to="/sale" className="p-link ">
					<p className="m-4 fw-lighter fs-6 ">SALE</p>
				</Link>
			</div>
			<div className="justify-content-evenly">
				<p className="m-4 fw-lighter fs-6 ">CONSULTAS</p>
				<p className="m-4 fw-lighter fs-6 ">MIS PEDIDOS</p>
				<Link to="/sale" className="p-link ">
				<p className="m-4 fw-lighter fs-6 ">SEGUIR MI PEDIDO</p>
				</Link>

				<p className="m-4 fw-lighter fs-6 ">DESCARGA TU BOLETA AQUÍ</p>
			</div>
			<div className="justify-content-evenly">
				<p className="m-4 fw-lighter fs-6 ">MIS FAVORITOS</p>
				<p className="m-4 fw-lighter fs-6 ">GUÍA DE TALLAS</p>
				<p className="m-4 fw-lighter fs-6 ">NOSOTROS</p>
				<p className="m-4 fw-lighter fs-6 ">PREGUNTAS FRECUENTES</p>
			</div>
			<div className="justify-content-evenly">
				<p className="m-4 fw-lighter fs-6 ">INFORMACIÓN</p>
				<p className="m-4 fw-lighter fs-6 ">CENTRO DE AYUDA</p>
				<p className="m-4 fw-lighter fs-6 ">POLÍTICA DE PRIVACIDAD</p>
				<p className="m-4 fw-lighter fs-6 ">TÉRMINOS Y CONDICIONES</p>

			</div>
			<div className="justify-content-evenly">
				<p className="m-4 fw-lighter fs-6 ">DESPACHO</p>
				<p className="m-4 fw-lighter fs-6 ">GARANTÍA Y DEVOLUCIONES</p>
				<p className="m-4 fw-lighter fs-6 ">CYBER</p>
			</div>
		</div>

	</footer >
);
