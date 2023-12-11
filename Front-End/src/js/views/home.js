import React from "react";
import rigoImage from "../../img/rigo-baby.jpg";
import "../../styles/home.css";
import SlidePrincipal from "../component/SlidePrincipal.jsx";
import Colecciones from "../component/Colecciones.jsx";
import SlideCards from "../component/SlideCards.jsx";
import Sale from "../component/Sale.jsx";
import Registro from "../component/registro.jsx";
import Card from "../component/card.jsx";
import Subtitulo from "../component/subtitulo.jsx";

export const Home = () => (
	<div className="text-center">
		<SlidePrincipal/>
		<Subtitulo texto={'NEW'}/>
		<SlideCards/>
		<Subtitulo texto={'COLECCIONES'}/>
		<Colecciones/>
		<Subtitulo texto={'SALE'}/>
		<Sale/>
		<Registro/>
	</div>
);
