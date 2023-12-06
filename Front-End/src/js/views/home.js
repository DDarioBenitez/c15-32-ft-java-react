import React from "react";
import rigoImage from "../../img/rigo-baby.jpg";
import "../../styles/home.css";
import SlidePrincipal from "../component/SlidePrincipal.jsx";
import Colecciones from "../component/Colecciones.jsx";
import SlideCards from "../component/SlideCards.jsx";
import Sale from "../component/Sale.jsx";
import Registro from "../component/registro.jsx";

export const Home = () => (
	<div className="text-center">
		<SlidePrincipal/>
		<SlideCards/>
		<Colecciones/>
		<Sale/>
		<Registro/>
	</div>
);
