import React, { useContext } from 'react'
import { CiHeart } from 'react-icons/ci'
import { BiMessage } from "react-icons/bi";
import { Link, useParams } from 'react-router-dom';
import { Context } from '../../store/appContext';


const ProductCard = ({ item }) => {
    const { store, actions } = useContext(Context);

    const { id } = useParams();

    const productId = 1
    
    
    return (

        <Link to={"/detalleProducto" + productId} className='linkStyle' onClick={()=>{actions.getProductById(item.nombre, item.id)}}>

            <div  className='card-slide'>
                {/* <img src="" alt="product-image" className="product--image" />         */}
                <img src={item.imagen[0]} className=" product--image" alt="product image" />
                <div className='title-wrap'>
                    <h6>{item.title}</h6>
                </div>
                <hr />
                <h6 className='price'>{item.price}</h6>
                <p>descripcion articulo..</p>
                <CiHeart />
                <BiMessage />
                {/*dejar comentario eliminar modificar agregar*/}
                <button onClick={() => { actions.addCarrito(item) }}>agregar al carrito</button>
            </div>
        </Link >

    )
}

export default ProductCard