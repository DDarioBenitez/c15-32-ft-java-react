import React from "react";
import "../../styles/home.css";
import SlidePrincipal from "../component/headerSlide/SlidePrincipal.jsx";
import Colecciones from "../component/galeria/Colecciones.jsx";
import Registro from "../component/perfil/registro.jsx";
import Subtitulo from "../component/landingPage/subtitulo.jsx";
import ProductsSlider from "../component/productsSlider/productsSlider.jsx";
import { CiAlarmOff } from "react-icons/ci";
import SlideCards from "../component/landingPage/SlideCards.jsx";


export const Home = () => (

	
	<div className="text-center">
		<SlidePrincipal />
		<Subtitulo texto={'NEW'} />
		<ProductsSlider />
		<Subtitulo texto={'COLECCIONES'} />
		<Colecciones />
		<Subtitulo texto={'SALE'} />
		<ProductsSlider />
		<Registro />
	</div>
);
