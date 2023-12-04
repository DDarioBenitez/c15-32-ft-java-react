import React from "react";
import rigoImage from "../../img/rigo-baby.jpg";
import "../../styles/home.css";
import SlidePrincipal from "../component/SlidePrincipal.jsx";
import Colecciones from "../component/Colecciones.jsx";
import SlideCards from "../component/SlideCards.jsx";
import Sale from "../component/Sale.jsx";

export const Home = () => (
	<div className="text-center mt-5">
		<SlidePrincipal/>
		<SlideCards/>
		<Colecciones/>
		<Sale/>
	</div>
);
