import React from 'react'

import perfilImagen from '../../img/rigo-baby.jpg'
import '../../styles/index.css'
import {Link} from 'react-router-dom'

const Sidebar =() => {

  return (
    
   <div>
     <div className='sidebar'>
    <div className='imgContent'>
    <img src={perfilImagen} class="img-fluid rounded-circle avatar mr-2"></img>
   <h4 > Hola!</h4>
    </div>
    </div>
    <ul>
    <li>
      <h5>Mi Cuenta </h5>
    </li>
    <li>
      <Link to="/infoPersonal" >Informacion Personal </Link>
    </li>
    <li>
    <Link to="/direcciones"  >Direcciones </Link>
    </li>
    <li>
    <Link to="/autenticacion"  >Autenticacion </Link>
    </li>
    <li>
    <Link to="/tarjetas"  >Tarjetas de credito </Link>
    </li>
    <li>
    <h5 > Mis pedidos</h5>
    </li>
        

    <li>
    <Link to="/pedidos"  >Pedidos realizados </Link>
    </li>

    <li>
    <Link to="/">Salir </Link>
    </li>
    </ul>
    </div>

  )
}


export default Sidebar



