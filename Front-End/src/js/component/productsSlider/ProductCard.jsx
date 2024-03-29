import React, { useContext } from 'react'
import { Context } from '../../store/appContext'
import { CiHeart, CiSquareMinus, CiSquarePlus } from 'react-icons/ci'
import { BiMessage } from "react-icons/bi"
import { Link, useParams } from 'react-router-dom'
import '../../../styles/productSlide.css'



const ProductCard = ({ item }) => {
    const { store, actions } = useContext(Context);

    const { id } = useParams();

    const v = store.carrito.filter(prod => prod.nombre !== item.nombre)
    let hola = v[0] === item ? store.carrito[v].cantidad : 1
    console.log(item, v[0], hola)
    // const productId = 1

    return (
        <div className='card-slide'>
            {/* <img src="" alt="product-image" className="product--image" />         */}
            <Link to={"/detalleProducto/" + item.id + "/" + item.nombre} className='linkStyle' onClick={() => { actions.getProductById(item.nombre, item.id) }}>
                <img src={item.imagen[0]} className=" product--image" alt="product image" />
            </Link >
            <div className='body-wrap'>
                <div className='title-wrap'>
                    <h6>{item.nombre}</h6>
                </div>
                {/* <CiHeart />
            <BiMessage /> */}
                <hr />
                < div className='d-flex justify-content-between'>
                    <h6 className='price'>${item.precio}</h6>
                    <div>
                        <CiSquareMinus className='carrito-icono' onClick={() => { actions.addCarrito() }} />
                        <span className='mx-2'>1</span>
                        <CiSquarePlus className='carrito-icono' onClick={() => { actions.addCarrito() }} />
                    </div>
                </div>
                <h6 className="card-text fw-light">
                    {/* $ {item.precio * cantidad} */}
                </h6>
                {/* actions.modificarCantidad() */}
                {/*dejar comentario eliminar modificar agregar*/}
                <button onClick={() => { actions.addCarrito(item) }}>agregar al carrito</button>

            </div>
        </div>

    )
}

export default ProductCard