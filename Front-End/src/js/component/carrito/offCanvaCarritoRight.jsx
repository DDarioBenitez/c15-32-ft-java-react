import React, { useContext } from 'react';
import { Context } from '../../store/appContext.js';
import { CiDeliveryTruck, CiUser, CiShoppingBasket, CiTrash, CiSquarePlus, CiSquareMinus } from "react-icons/ci";
import { HiOutlineShoppingBag } from "react-icons/hi2";
import CardCarrito from './CardCarrito.jsx';
import { Link } from 'react-router-dom';

const OffCanvaCarritoRight = () => {
    const { store, actions } = useContext(Context);
    // traer producto agregado a carrito desde backend en cardCarrito


    return (
        <>
            <button className="btn " type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
                <HiOutlineShoppingBag />
            </button>

            <div className="offcanvas offcanvas-end" tabIndex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
                <div className="offcanvas-header">
                    <h6 className="offcanvas-title" id="offcanvasRightLabel">ARTICULOS EN EL CARRITO</h6>
                    <button type="button" className="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div className="offcanvas-body">
                {
                    store.carrito.map((item, i)=>{
                        return(
                            <CardCarrito item={item} key={i}/>
                        )
                    })
                }
                </div>
                <hr />
                <div className="text-uppercase float-left fs-bolder p-3">total: $ total detalles endpoint </div>

                <div className='d-flex flex-column mb-4'>

                    <button className="btn btn-outline-dark text-uppercase m-2 btnLight-linkStyle">
                        <Link className='linkStyle' to="/">
                            <span>seguir comprando</span>
                        </Link>
                    </button>

                    <button className="btn btn-dark text-uppercase m-2 ">
                        <Link className='btnDark-linkStyle text-light ' to="/procesoCompra">
                            <span>ir a pagar</span>
                        </Link>
                    </button>

                    {/* link a pag pago */}
                </div>
            </div>

        </>
    )
}

export default OffCanvaCarritoRight