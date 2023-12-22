import React from 'react'
import { CiSquareMinus, CiSquarePlus } from 'react-icons/ci'
import { IoCloseOutline } from "react-icons/io5";
import { HiOutlineLockClosed } from "react-icons/hi2";
import Subtitulo from '../landingPage/subtitulo.jsx';
import CardCompra from './cardCompra.jsx';

const ProcesoCompra = () => {
    //detalles de compra desde backend

    return (

        <div className='container-fluid'>
            <div className="text-center">
                <Subtitulo texto={'CARRITO DE COMPRA'} />
            </div>
            <table className="table border text-uppercase px-5 py-5">
                <thead>
                    <tr>
                        <th scope="col text-uppercase">producto</th>
                        <th scope="col text-uppercase">precio</th>
                        <th scope="col text-uppercase">cantidad</th>
                        <th scope="col text-uppercase">total</th>
                    </tr>
                </thead>
                <tbody className="table-group-divider">
                    <CardCompra />
                    <tr>
                        <th scope="row">titulo producto</th>
                        <td>$0000</td>
                        <td>
                            <CiSquareMinus className='carrito-icono' />
                            {/* funcion para quitar productos del carrito con post */}
                            <span className='mx-2'>1</span>
                            <CiSquarePlus className='carrito-icono' />
                            {/* funcion para agregar productos al carrito con post */}
                        </td>

                        <td>$0000
                            <span className='ms-4'><IoCloseOutline /></span>
                        </td>
                        {/* funcion para eliminar productos del carrito con post */}
                    </tr>
                    <tr>
                        <th scope="row">titulo producto</th>
                        <td>$0000</td>
                        <td>
                            <CiSquareMinus className='carrito-icono' />
                            {/* funcion para quitar productos del carrito con post */}
                            <span className='mx-2'>1</span>
                            <CiSquarePlus className='carrito-icono' />
                            {/* funcion para agregar productos al carrito con post */}
                        </td>
                        <td>$0000
                            <span className='ms-4'><IoCloseOutline /></span>
                        </td>
                        {/* funcion para eliminar productos del carrito con post */}

                    </tr>
                    <tr>
                        <th scope="row">titulo producto</th>
                        <td>$0000</td>
                        <td>
                            <CiSquareMinus className='carrito-icono' />
                            {/* funcion para quitar productos del carrito con post */}
                            <span className='mx-2'>1</span>
                            <CiSquarePlus className='carrito-icono' />
                            {/* funcion para agregar productos al carrito con post */}
                        </td>
                        <td>$0000
                            <span className='ms-4'><IoCloseOutline /></span>
                        </td>
                        {/* funcion para eliminar productos del carrito con post */}

                    </tr>

                    <tr className='total-carrito'>

                        <th scope="row">
                            <span>total carrito</span>
                        </th>

                        <td>$0000</td>
                        {/* funcion para sumar productos del carrito con post */}

                    </tr>

                </tbody>
            </table>
            <div className='pago-seguro'>
                <HiOutlineLockClosed /> <span className='py-5'>Pago seguro</span>
            </div>

        </div>
    )
}

export default ProcesoCompra