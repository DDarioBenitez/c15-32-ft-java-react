import React from 'react'
import { LuPackageSearch } from "react-icons/lu";


const SeguimientoPedido = () => {
    return (
        <>
            {/* arreglar html react por bootstrap */}
            <div className='deliveryview d-grid '>
                <div>
                    <LuPackageSearch className='seguimientoPedidoIcono my-3' />
                </div>
                <span>SEGUIR MI PEDIDO</span>
                <form className="col my-3">
                    <div className="">
                        <label className="visually-hidden" for="autoSizingInput">CODIGO DE SEGUIMIENTO</label>
                        <input type="text" className="form-control" id="autoSizingInput" placeholder="Ej: 001273645" />
                    </div>
                   
                    <button type="submit" className="btn text-center">BUSCAR</button>
                </form>
            </div>
        </>
    )
}

export default SeguimientoPedido