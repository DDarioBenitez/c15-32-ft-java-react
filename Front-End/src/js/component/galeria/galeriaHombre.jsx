import React, { useContext } from "react";
import { Context } from "../../store/appContext.js";
import Card from "./card.jsx";
import ProductCard from "../productsSlider/ProductCard.jsx";
import ProductCardGaleria from "./ProductCardGaleria.jsx";



const GaleriaHombre = (props) => {
    const { store, actions } = useContext(Context);


    return (
        <>
            <div className='d-flex justify-content-center align-items-center '>
                {
                    store.men?.map((item, index) => {
                        return (
                            <ProductCardGaleria key={item.id} item={item} />
                        )
                    })
                }
            </div>
        </>
    )
}

export default GaleriaHombre
