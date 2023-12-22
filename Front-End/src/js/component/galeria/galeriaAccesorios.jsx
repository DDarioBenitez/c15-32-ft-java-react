import React, { useContext } from "react";
import { Context } from "../../store/appContext.js";
import Card from "./card.jsx";
import ProductCard from "../productsSlider/ProductCard.jsx";



const GaleriaAccesorios = (props) => {
    const { store, actions } = useContext(Context);


    return (
        <>
            <div className='d-flex justify-content-center align-items-center '>
                {
                    store.accesorios?.map((item, index) => {
                        return (
                            <ProductCard key={item.id} item={item} />
                        )
                    })
                }
            </div>
        </>
    )
}

export default GaleriaAccesorios
