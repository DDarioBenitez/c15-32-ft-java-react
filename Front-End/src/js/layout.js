import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import ScrollToTop from "./component/scrollToTop";

import { Home } from "./views/home";
import { Navbar } from "./component/nav/navbar.js";
import { Footer } from "./component/footer/footer.js";
import injectContext from "./store/appContext";
import SeguimientoPedido from "./views/seguimientoPedido.jsx"
import ColeccionDinamica from "./component/galeria/ColeccionDinamica.jsx";
import Perfil from "./component/perfil/perfil.jsx";
import Registro from "./component/perfil/registro.jsx";
import Login from "./component/nav/login.jsx";
import OpalRrss from "./component/footer/opalRrss.jsx";

Footer

import NotFound from "./component/notFound.jsx";
import ProcesoCompra from "./component/carrito/procesoCompra.jsx";
// import { Navbar } from "./component/navbar";
// import { Footer } from "./component/footer";
// import SeguimientoPedido from "./views/seguimientoPedido.jsx";
// import Perfil from "./component/perfil.jsx";
// import ColeccionDinamica from "./component/ColeccionDinamica.jsx";
// import Registro from "./component/registro.jsx";
// import Login from "./component/login.jsx";
// import OpalRrss from "./component/footer/opalRrss.jsx";
// import NotFound from "./component/notFound.jsx";


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
						<Route path="/perfil/:id" element={<Perfil />} />
						<Route exact path="/registro" element={<Registro />}/>
						<Route exact path="/login" element={<Login />}/>
						<Route exact path="/procesoCompra" element={<ProcesoCompra />}/>
						<Route path="*" element={<NotFound/>} />
					</Routes>
					<OpalRrss />
					<Footer />
				</ScrollToTop>
			</BrowserRouter>
		</div>
	);
};

export default injectContext(Layout);
