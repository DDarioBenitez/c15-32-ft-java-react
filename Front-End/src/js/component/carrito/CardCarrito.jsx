import React from 'react'
import { CiTrash, CiSquarePlus, CiSquareMinus } from "react-icons/ci";
import { BsTrash } from "react-icons/bs";

const CardCarrito = () => {

// traer producto agregado a carrito desde backend


  return (

    <div className="card mb-3 text-uppercase mx-0" style={{ maxWidth: '540px' }}>
    <div className="row g-0">
        <div className="col-md-4 card-carrito-img-container">
            <img src="https://images.pexels.com/photos/833169/pexels-photo-833169.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="img-fluid " alt="..." />
        </div>
        <div className="col-md-8">
            <div className="card-body ps-3">
                <div>
                    <h6 className="card-title ">titulo producto</h6>
                    <p className="card-text mb-1">color </p>
                    <p className="card-text mb-2">talla  </p>
                </div>
                <div className='d-flex align-items-center carrito-cantidad'>
                    <h6><CiSquareMinus className='carrito-icono'/></h6>
                    {/* funcion para quitar productos del carrito con post */}
                    <h6 className='p-2'>1</h6>
                    <h6><CiSquarePlus className='carrito-icono'/></h6>
                    {/* funcion para agregar productos al carrito con post */}
                </div>
                <h6 className="card-text">$ 0000 </h6>
                <div className="card-text d-flex ">
                    <h6><BsTrash className=" fw-bolder"/></h6>
                    {/* funcion para eliminar productos del carrito con post */}

                    <p className="p-2 fw-medium pb-0">eliminar</p>
                </div>
            </div>
        </div>
    </div>
</div>




  )
}

export default CardCarrito