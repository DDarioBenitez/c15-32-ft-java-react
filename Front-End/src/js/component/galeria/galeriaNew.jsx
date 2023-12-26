import React, { useContext } from "react";
import { Context } from "../../store/appContext.js";
import ProductCardGaleriaNew from "./ProductCardGaleriaNew.jsx";



const GaleriaNew = (props) => {
    const { store, actions } = useContext(Context);


    return (
        <>
            <div className='d-flex justify-content-center align-items-center container galeria'>
                <div className="row centrar-grid">
                    {
                        store.newIn?.map((item, index) => {
                            return (
                                <ProductCardGaleriaNew key={item.id} item={item} />
                            )
                        })
                    }
                </div>
            </div>
        </>
    )
}

export default GaleriaNew
