import React, { useContext } from "react";
import { Context } from "../../store/appContext.js";
import Card from "./card.jsx";
import ProductCard from "../productsSlider/ProductCard.jsx";
import ProductCardGaleria from "./ProductCardGaleria.jsx";



const GaleriaAccesorios = ({nombre}) => {
    const { store, actions } = useContext(Context);

    // const nombreColeccion=  nombre === 'men' ? <GaleriaHombre /> :
    //       nombre === 'woman' ? <GaleriaMujer /> :
    //         nombre === 'accesorios' ? <GaleriaAccesorios /> :
    //           nombre === 'sale' ? <GaleriaSale /> :
    //             <GaleriaNew />
//   console.log(nombre);


    return (
        <>
            <div className='d-flex justify-content-center align-items-center '>
                {
                    store.accesorios?.map((item, index) => {
                        return (
                            <ProductCardGaleria key={item.id} item={item} />
                        )
                    })
                }
            </div>
        </>
    )
}

export default GaleriaAccesorios
