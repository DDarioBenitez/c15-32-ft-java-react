import React, { useContext } from 'react'
import { Context } from '../../store/appContext';
import { useParams } from 'react-router';

import { CiSquareMinus, CiSquarePlus } from 'react-icons/ci';
import { SiGithubsponsors } from "react-icons/si";
import '../../../styles/index.css'

const Card = ({ imagen, tituloProducto, precio, cantidad, item }) => {
    const { store, actions } = useContext(Context);
    const { id } = useParams();
// console.log(item.cantidad);
    let counter = 1

    return (
        <div className="card cards col-4 mx-1" style={{ width: '14rem', height: '450px' }}>
            <img src={item.imagen[0]} className="card-img-top card-coleccion-img" alt="img-producto" />
            <div className="card-body">
                <h6 className="card-title fw-light p-2 card-coleccion titulo">{item.nombre}</h6>
                <hr />
                < div className='d-flex card-text'>

                    <h6 className="fs-5 text-secondary px-4">
                        $ {item.precio}
                    </h6>
                     <div className="slide-card-cantidad">
                          <CiSquareMinus className='carrito-icono card-text' onClick={() => { actions.addCarrito() }} />
                          <span className='mx-2'>{counter}</span>
                          <CiSquarePlus className='carrito-icono card-text' onClick={() => { actions.addCarrito() }} />
                      </div>
               </div>
               <div className='d-flex justify-content-evenly'>
                           <button className="card-link btn btn-outline-dark text-uppercase" onClick={() => { actions.addCarrito(item) }}>agregar al carrito</button> 
                      </div>

                
            </div>
        </div>
    )
}

export default Card


//             <div className="card-body d-flex justify-content-evenly">
            //     {/* <span className="card-link"><SiGithubsponsors /> </span> */}
            //     <button className="card-link btn btn-dark text-uppercase" onClick={() => { actions.addCarrito(item) }}>agregar al carrito</button> 
            //     {/* mapear estas cards y enviar la funcion con el producto como parametro */}
            // </div>
