import React from 'react'
import { CiDeliveryTruck, CiUser, CiShoppingBasket, CiTrash, CiSquarePlus, CiSquareMinus } from "react-icons/ci";

const OffCanvaCarritoRight = () => {
    return (
        <>
            <button className="btn " type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
                <CiShoppingBasket />
            </button>

            <div className="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
                <div className="offcanvas-header">
                    <h5 className="offcanvas-title fw-lighter" id="offcanvasRightLabel">ARTICULOS EN EL CARRITO</h5>
                    <button type="button" className="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div className="offcanvas-body">

                    {/* horizontalCard solo para items en carro de compras*/}
                    <div className="card mb-3 text-uppercase fw-lighter" style={{ maxWidth: '540px' }}>
                        <div className="row g-0">
                            <div className="col-md-4">
                                <img src="https://images.pexels.com/photos/833169/pexels-photo-833169.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="img-fluid rounded-start" alt="..." />
                            </div>
                            <div className="col-md-8">
                                <div className="card-body fw-lighter">
                                    <div>
                                        <h6 className="card-title fw-light">titulo producto</h6>
                                        <p className="card-text fw-lighter">color </p>
                                        <p className="card-text fw-lighter">talla  </p>
                                    </div>
                                    <div className='d-flex align-items-center'>
                                        <h6><CiSquareMinus /></h6>
                                        <h6 className='p-2'>1</h6>
                                        <h6><CiSquarePlus /></h6>

                                    </div>

                                    <h6 className="card-text">$ 0000 </h6>


                                    <div className="card-text d-flex ">
                                        <h6><CiTrash /></h6>
                                        <p className="p-2 fw-lighter">eliminar</p>
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>
                {/* horizontalCard solo para items en carro de compras*/}

            </div>
       
        </>
    )
}

export default OffCanvaCarritoRight