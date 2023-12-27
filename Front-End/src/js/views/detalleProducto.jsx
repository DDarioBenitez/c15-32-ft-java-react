import React, { useEffect } from 'react'
import { Link, useParams } from 'react-router-dom'
import { Context } from "../store/appContext";
import { useContext } from "react";
import '../../styles/detalles.css';
import { CiHeart, CiSquareMinus, CiSquarePlus } from 'react-icons/ci';
import Form from 'react-bootstrap/Form';




const DetalleProducto = () => {
    const { store, actions } = useContext(Context);
    const { id } = useParams();
    // useEffect(() => {
    //     actions.getOneProduct(id)
    // }, [])
    const producto = store.OneProduct
    console.log(store.OneProduct?.nombre, 'ooooppp');



    return (
        <>
            <div className='page-wraper  m-5 '>

                <div className='d-flex justify-content-center border border-secondary detalle-producto text-uppercase'>
                    <div className=' detalle-producto-img d-flex justify-content-center col-6'>
                        <img src={store.OneProduct?.imagen[0]} alt="producto" />
                    </div>
                    <div className='detalle-producto-info col-6 text-uppercase'>
                        <div>{store.OneProduct?.nombre}  </div>
                        <div>{store.OneProduct?.descripcion}</div>
                        <hr/>
                        <div className="slide-card-cantidad text-uppercase">
                            <CiHeart className='carrito-icono card-text' onClick={() => { actions.addCarrito() }} />
                            <span className='mx-2'>agregar a favoritos</span>
                        </div>
                        <Form.Select className="talle-select text-uppercase" size="sm" aria-label="Default select example">
                            <option>Talle</option>
                            <option value="1">S</option>
                            <option value="2">M</option>
                            <option value="3">L</option>
                            <option value="4">XL</option>

                        </Form.Select>
                        < div className='d-flex card-text'>
                            <h6 className="fs-5 text-secondary me-4">
                                $ {store.OneProduct?.precio}
                            </h6>
                            <div className="slide-card-cantidad">
                                <CiSquareMinus className='carrito-icono card-text' onClick={() => { actions.addCarrito() }} />
                                <span className='mx-2'>1</span>
                                <CiSquarePlus className='carrito-icono card-text' onClick={() => { actions.addCarrito() }} />
                            </div>
                        </div>
                        <div className='d-flex detalle-btn'>
                            <button className="card-link btn btn-outline-dark text-uppercase" onClick={() => { actions.addCarrito(producto) }}>agregar al carrito</button>
                        </div>

                        {/* <div>{store.OneProduct?.talle[0]}</div>
                        <div>{store.OneProduct?.talle[1]}</div>
                        <div>{store.OneProduct?.talle[2]}</div> */}

                    </div>


                </div>
            </div>

        </>
    )
}

export default DetalleProducto

{/* <div className="wrapper">
<div className="container main">
    <div className="row">
        <div className="col-md-6 side-image">
        <img src={store.product.imagen[0]} />
            <div className="col-md-6 right">
                <div className="title">
                    <h5>{store.product.nombre}</h5>
                </div>
                <div className="cuerpo">
                <h6>{store.product.descripcion}</h6>

                    <h5>{store.product.precio}</h5>
                    {/* <img src="../rigo-baby.jpg" alt="" />
                    <img src="../rigo-baby.jpg" alt="" /> 
//                     <h6>Guia de Talles</h6>
//                 </div>
//                 <div className="pie">
//                     < div className='d-flex justify-content-center'>
//                         <CiSquareMinus className='carrito-icono' onClick={() => { actions.addCarrito() }} />
//                         <span className='mx-2'>1</span>
//                         <CiSquarePlus className='carrito-icono' onClick={() => { actions.addCarrito() }} />
//                     </div>
//                     <button className="btn btn-dark">Añadir aL carrito</button>
//                 </div>
//                 <div className="cardPie w-50">
//                     <p>Recibe el mismo día comprando antes de las 13:00pm
//                     </p>
//                 </div>
//             </div>

//         </div>
//     </div>
// </div>
// </div> */}


// {store.product?.nombre == nombre ?
//     (
//         <div className='container  pt-3 mt-2 '>
//             <div className="d-flex justify-content-around mb-2 container">
//                 <div className='col-6'>
//                     <img src={props.imagen} alt="" className='img-fluid' />
//                 </div>
//                 <div className='col-6 px-3'>
//                     <span className='text-uppercase d-flex text-start my-4'>{item?.nombre}</span>
//                     <p className='text-uppercase fs-4'> {item?.description}</p>

//                     <select class="form-select card-text" aria-label="Default select example">
//                         <option selected>talle</option>
//                         <option defaultValue="1">{item.talle[0]}</option>
//                         <option value="2">{item.talle[1]}</option>
//                         <option value="3">{item.talle[2]}</option>
//                     </select>

//                     <select class="form-select card-text" aria-label="Default select example">
//                         <option selected>talle</option>
//                         <option defaultValue={item.color[0]}>{item.color[0]}</option>
//                         <option value={item.color[0]}>{item.color[1]}</option>
//                         <option value={item.color[0]}>{item.color[2]}</option>

//                     </select>

//                     <div className='d-flex align-items-center carrito-cantidad'>
//                         <h6><CiSquareMinus className='carrito-icono' /></h6>
//                         {/* funcion para quitar productos del carrito */}
//                         <h6 className='p-2'>{item.cantidad}</h6>
//                         <h6><CiSquarePlus className='carrito-icono' /></h6>
//                         {/* funcion para agregar productos al carrito */}
//                     </div>

//                     <p className='text-uppercase fs-4'> {item?.precio}</p>
//                     <p className='text-uppercase fs-4'> {item?.total}</p>

//                     <div className="total-cantidad"></div>
//                 </div>
//             </div>

//         </div>
//     )
//             :
//     (
//         <Cargando />
//     )
// Name}


