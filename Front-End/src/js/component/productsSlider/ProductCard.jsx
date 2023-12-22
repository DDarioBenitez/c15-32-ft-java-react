import React, { useContext } from 'react'
import { CiHeart, CiSquareMinus, CiSquarePlus } from 'react-icons/ci'
import { BiMessage } from "react-icons/bi";
import { Link, useParams } from 'react-router-dom';
import { Context } from '../../store/appContext';


const ProductCard = ({ item }) => {
    const { store, actions } = useContext(Context);

    const { id } = useParams();

    const productId = 1
    const counter = 1;


    return (
        <div className='card-slide'>
            {/* <img src="" alt="product-image" className="product--image" />         */}
            <Link to={"/detalleProducto" + productId} className='linkStyle' onClick={() => { actions.getProductById(item.nombre, item.id) }}>
                <img src={item.imagen[0]} className=" product--image" alt="product image" />
            </Link >

            <div className='title-wrap'>
                <h6>{item.title}</h6>
            </div>
            <hr />
            <h6 className='price'>{item.price}</h6>
            <p>descripcion articulo..</p>
            <CiHeart />
            <BiMessage />
            <hr />
                < div className='d-flex '>
                <CiSquareMinus className='carrito-icono' onClick={()=> counter > 1 ? counter-- : null} />
                {/* si es mayor a 1 resta sino no hace nada */}
                <span className='mx-2'>{counter}</span>
                <CiSquarePlus className='carrito-icono' onClick={()=> counter++} />
                {/* funcion para agregar productos al carrito  */}

                </div>
                <h6 className="card-text fw-light">
                    $ {item.precio * counter}
                </h6>
            {/* actions.modificarCantidad() */}
            {/*dejar comentario eliminar modificar agregar*/}
            <button onClick={() => { actions.addCarrito(item) }}>agregar al carrito</button>
        </div>

    )
}

export default ProductCard