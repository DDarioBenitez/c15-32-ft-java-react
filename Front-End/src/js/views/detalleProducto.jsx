import React, { useEffect } from 'react'
import { Link, useParams } from 'react-router-dom'
import { Context } from "../store/appContext";
import { useContext } from "react";

const DetalleProducto = (props) => {
    const { store, actions } = useContext(Context);
    const { id, nombre } = useParams();

    useEffect(() => {
        actions.getProductById(id, nombre)//byuid? byurl
    }, [])

    return (
        <>

            {store.product?.nombre == nombre ?
                (
                    <div className='container  pt-3 mt-2 '>
                        <div className="d-flex justify-content-around mb-2 container">
                            <div className='col-6'>
                                <img src={props.imagen} alt="" className='img-fluid' />
                            </div>
                            <div className='col-6 px-3'>
                                <span className='text-uppercase d-flex text-start my-4'>{item?.nombre}</span>
                                <p className='text-uppercase fs-4'> {item?.description}</p>

                                <select class="form-select card-text" aria-label="Default select example">
                                    <option selected>talle</option>
                                    <option defaultValue="1">{item.talle[0]}</option>
                                    <option value="2">{item.talle[1]}</option>
                                    <option value="3">{item.talle[2]}</option>
                                </select>

                                <select class="form-select card-text" aria-label="Default select example">
                                    <option selected>talle</option>
                                    <option defaultValue={item.color[0]}>{item.color[0]}</option>
                                    <option value={item.color[0]}>{item.color[1]}</option>
                                    <option value={item.color[0]}>{item.color[2]}</option>
                                
                                </select>

                                <div className='d-flex align-items-center carrito-cantidad'>
                                    <h6><CiSquareMinus className='carrito-icono' /></h6>
                                    {/* funcion para quitar productos del carrito */}
                                    <h6 className='p-2'>{item.cantidad}</h6>
                                    <h6><CiSquarePlus className='carrito-icono' /></h6>
                                    {/* funcion para agregar productos al carrito */}
                                </div>

                                <p className='text-uppercase fs-4'> {item?.precio}</p>
                                <p className='text-uppercase fs-4'> {item?.total}</p>

                                <div className="total-cantidad"></div>
                            </div>
                        </div>

                    </div>
                )
                        :
                (
                    <Cargando />
                )
            }

        </>
    )
}

export default DetalleProducto





