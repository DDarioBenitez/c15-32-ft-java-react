import React, { useContext } from 'react'
import { LuPackageSearch } from "react-icons/lu";
import { Context } from '../store/appContext';


const SeguimientoPedido = () => {
    const { store, actions } = useContext(Context);
    console.log(store.products, 'ooooo')

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
                        <label className="visually-hidden" htmlFor="autoSizingInput">CODIGO DE SEGUIMIENTO</label>
                        <input type="text" className="form-control" id="autoSizingInput" placeholder="Ej: 001273645" />
                    </div>
                   <div className="d-grid">
                   <button type="submit" className="btn text-center boton-pag">BUSCAR</button>
                   </div>
                </form>
            </div>
        </>
    )
}

export default SeguimientoPedido