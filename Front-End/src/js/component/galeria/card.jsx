import React from 'react'
import { CiSquareMinus, CiSquarePlus } from 'react-icons/ci';
import { SiGithubsponsors } from "react-icons/si";

const Card = ({ imagen, tituloProducto, precio, cantidad, item }) => {

    let counter = 1

    return (
        <div className="card cards col-4 mx-1" style={{ width: '14rem', height: '450px' }}>
            <img src={imagen} className="card-img-top card-coleccion" alt="img-producto" />
            <div className="card-body">
                <h6 className="card-title fw-light mt-2">{tituloProducto}</h6>
                <hr />
                < div className='d-flex '>
                <CiSquareMinus className='carrito-icono' onClick={()=> counter > 1 ? counter-- : null} />
                {/* si es mayor a 1 resta sino no hace nada */}
                <span className='mx-2'>{counter}</span>
                <CiSquarePlus className='carrito-icono' onClick={()=> counter++} />
                {/* funcion para agregar productos al carrito  */}

                </div>
                <h6 className="card-text fw-light">
                    $ {precio * counter}
                </h6>
            </div>
            <div className="card-body">
                <div className="card-link"><SiGithubsponsors /> </div>
                <div className="card-link" onClick={()=>{actions.addCarrito(tituloProducto)}}>agregar al carrito</div> 
                {/* mapear estas cards y enviar la funcion con el producto como parametro */}
            </div>
        </div>
    )
}

export default Card