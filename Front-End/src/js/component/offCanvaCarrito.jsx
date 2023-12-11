import React from 'react'
import { CiDeliveryTruck, CiUser, CiShoppingBasket, CiTrash, CiSquarePlus, CiSquareMinus } from "react-icons/ci";

const OffCanvaCarrito = () => {
    return (
        <>
            <button className="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasTop" aria-controls="offcanvasTop">
                <CiShoppingBasket />
            </button>

            <div className="offcanvas offcanvas-top" tabindex="-1" id="offcanvasTop" aria-labelledby="offcanvasTopLabel">
                <div className="offcanvas-header">
                    <h5 className="offcanvas-title" id="offcanvasTopLabel">Articulos en el carrito</h5>
                    <button type="button" className="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div className="offcanvas-body">

                    {/* horizontalCard solo para items en carro de compras*/}
                    <div className="card mb-3" style={{maxWidth: '540px'}}>
                        <div className="row g-0">
                            <div className="col-md-4">
                                <img src="https://images.pexels.com/photos/833169/pexels-photo-833169.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="img-fluid rounded-start" alt="..." />
                            </div>
                            <div className="col-md-8">
                                <div className="card-body">
                                    <h5 className="card-title">titulo producto</h5>
                                    <p className="card-text">talla color precio</p>
                                    <p> cantidad 
                                        <CiSquarePlus/> 
                                        <CiSquareMinus/>
                                    </p>
                                    <p className="card-text"><small className="text-body-secondary"><CiTrash /> eliminar</small></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    {/* horizontalCard solo para items en carro de compras*/}
                    
                </div>
            </div>
        </>
    )
}

export default OffCanvaCarrito