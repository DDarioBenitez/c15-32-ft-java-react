import React from 'react'
import { CiDeliveryTruck, CiUser, CiShoppingBasket, CiTrash, CiSquarePlus, CiSquareMinus } from "react-icons/ci";
import { HiOutlineShoppingBag } from "react-icons/hi2";
import CardCarrito from './carrito/CardCarrito.jsx';

const OffCanvaCarritoRight = () => {
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
                    <CardCarrito />
                </div>

            </div>

        </>
    )
}

export default OffCanvaCarritoRight