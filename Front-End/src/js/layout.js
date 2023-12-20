import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import ScrollToTop from "./component/scrollToTop";

import { Home } from "./views/home";
import injectContext from "./store/appContext";

import { Navbar } from "./component/navbar";
import { Footer } from "./component/footer";
import SeguimientoPedido from "./views/seguimientoPedido.jsx";
import Perfil from "./component/perfil.jsx";
import ColeccionDinamica from "./component/ColeccionDinamica.jsx";
import Registro from "./component/registro.jsx";
import Login from "./component/login.jsx";


//create your first component
const Layout = () => {
	//the basename is used when your project is published in a subdirectory and not in the root of the domain
	// you can set the basename on the .env file located at the root of this project, E.g: BASENAME=/react-hello-webapp/
	const basename = process.env.BASENAME || "";

	return (
		<div>
			<BrowserRouter basename={basename}>
				<ScrollToTop>
					<Navbar />
					<Routes>
						<Route path="/" element={<Home />} />
						<Route path="/seguimientoPedido" element={<SeguimientoPedido />} />

						<Route path=":coleccion" element={<ColeccionDinamica />} />
						{/* <Route path="/hombre" element={<ColeccionDinamica />} />
						<Route path="/mujer" element={<ColeccionDinamica />} />
						<Route path="/accesorios" element={<ColeccionDinamica />} />
						<Route path="/sale" element={<ColeccionDinamica />} /> */}

						<Route path="/perfil/:id" element={<Perfil />} />
						<Route exact path="/registro" element={<Registro/>}/>
						<Route exact path="/login" element={<Login/>}/>
						<Route path="*" element={<h1>Not found!</h1>} />
					</Routes>
					<Footer />
				</ScrollToTop>
			</BrowserRouter>
		</div>
	);
};

export default injectContext(Layout);
