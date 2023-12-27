import React, { useContext } from 'react'
import { CiHeart, CiSquareMinus, CiSquarePlus } from 'react-icons/ci'
import { BiMessage } from "react-icons/bi";
import { Link, useParams } from 'react-router-dom';
import { Context } from '../../store/appContext';


const ProductCardGaleria = ({ item }) => {
    const { store, actions } = useContext(Context);

    const { id } = useParams();

    const productId = 1
    const counter = 1

    
    return (
        <div className='card-slide-galeria col-sm-12 col-md-4 col-lg-3 m-3'>
            {/* <img src="" alt="product-image" className="product--image" />         */}
            <Link to={"/detalleProducto/" + item.id } className='linkStyle' onClick={()=> actions.getOneProduct(item.id)}>
                <img src={item.imagen[0]} className=" product-image-galeria" alt="product image" />
            </Link >
            <div className='title-wrap my-2'>
                <h6>{item.nombre}</h6>
            </div>
            <hr />
            < div className='d-flex justify-content-center card-text'>
                <h6 className="fs-5 text-secondary px-4">
                    $ {item.precio}
                </h6>
                <div className="slide-card-cantidad">
                    <CiSquareMinus className='fs-5 carrito-icono' onClick={() => { actions.addCarrito() }} />
                    <span className='mx-2'>{counter}</span>
                    <CiSquarePlus className=' fs-5 carrito-icono' onClick={() => { actions.addCarrito() }} />
                </div>
            </div>
            <button className='text-uppercase' onClick={() => { actions.addCarrito(item) }}>agregar al carrito</button>
        </div>

    )
}

export default ProductCardGaleria

{/* < div className='d-flex justify-content-center'>
<CiSquareMinus className='carrito-icono' onClick={() => { actions.addCarrito() }} />
<span className='mx-2'>1</span>
<CiSquarePlus className='carrito-icono' onClick={() => { actions.addCarrito() }} />
</div>
<h6 className="card-text fw-light">
{/* $ {item.precio * cantidad} */}
// </h6> */}
{/* actions.modificarCantidad() */ }
{/*dejar comentario eliminar modificar agregar*/ }
