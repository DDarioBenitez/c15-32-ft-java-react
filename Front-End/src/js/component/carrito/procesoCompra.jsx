import React, { useContext, useEffect } from 'react'
import {Link} from "react-router-dom";
import { CiSquareMinus, CiSquarePlus } from 'react-icons/ci'
import { IoCloseOutline } from "react-icons/io5";
import { HiOutlineLockClosed } from "react-icons/hi2";
import Subtitulo from '../landingPage/subtitulo.jsx';
import CardCompra from './cardCompra.jsx';
import { Context } from '../../store/appContext';
import { request } from "../../services/AxiosService";



const ProcesoCompra = () => {
    //detalles de compra desde backend
    const { store, actions } = useContext(Context);


    useEffect(() =>
    {
        store.carrito =
        [
            {
                "id": 3,
                "nombre": "Camisa Basica Recta Mujer Sweet Portel",
                "precio": 2200,
                "imagen": [
                    "https://http2.mlstatic.com/D_NQ_NP_862731-MLA72204366605_102023-O.webp",
                    "https://http2.mlstatic.com/D_NQ_NP_640885-MLA72204209867_102023-O.webp"
                ],
                "cantidad": 2,
                "talle": [
                    "L",
                    "XL",
                    "SM"
                ],
                "color": [
                    "Blanco"
                ]
            },
            {
                "id": 4,
                "nombre": "Vestido Doha Batik De Mujer 47 Street",
                "precio": 2300,
                "imagen": [
                    "https://http2.mlstatic.com/D_NQ_NP_637740-MLA52028206523_102022-O.webp",
                    "https://http2.mlstatic.com/D_NQ_NP_822093-MLA52028206530_102022-O.webp",
                    "https://http2.mlstatic.com/D_NQ_NP_860255-MLA52028206522_102022-O.webp"
                ],
                "cantidad": 1,
                "talle": [
                    "L",
                    "XL",
                    "SM"
                ],
                "color": [
                    "Blanco"
                ]
            },
            {
                "id": 2,
                "nombre": "Chomba Vatiare Beige",
                "precio": 3800,
                "imagen": [
                    "https://http2.mlstatic.com/D_NQ_NP_600131-MLA51483246856_092022-O.webp",
                    "https://http2.mlstatic.com/D_NQ_NP_997054-MLA51483246859_092022-O.webp",
                    "https://http2.mlstatic.com/D_NQ_NP_822922-MLA51483246854_092022-O.webp"
                ],
                "cantidad": 1,
                "talle": [
                    "L",
                    "XL",
                    "SM"
                ],
                "color": [
                    "Blanco"
                ]
            }
        ];

        [
            {
                "productoId": 3,
                "cantidad": 2,
                "precioTotal": 4400
            },
            {
                "productoId": 4,
                "cantidad": 1,
                "precioTotal": 2300
            },
            {
                "productoId": 2,
                "cantidad": 1,
                "precioTotal": 3800
            }
        ]

        
    }, []);

    const comprar = async e =>
    {
        const carrito = store.carrito.map(producto =>
        {
            const item = {productoId: producto.id, cantidad: producto.cantidad, precioTotal: producto.precio * producto.cantidad};
            return item;
        });
        

        const res = await fetch("http://c15-32-ft-java-react-production.up.railway.app/api/transaccion/checkout", {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({"detalles": carrito})
        })
        const data = await res.json()
        console.log(data);
    }

    return (

        <div>
            <div className="text-center">
                <Subtitulo texto={'PROCESO DE COMPRA'} />
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
                    {
                        store.carrito.map((item, i) => {
                            return (
                                <CardCompra item={item} key={i}/>
                            )
                        })
                    }

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
                <button type='button' className='btn btn-primary btn-lg' onClick={comprar}>Comprar</button>
                <HiOutlineLockClosed /> <span className='py-5'>Pago seguro</span>
            </div>
        </div>
    )
}

export default ProcesoCompra