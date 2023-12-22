import React, { useContext } from "react";
import { Context } from "../../store/appContext.js";
import ProductCardGaleria from "./ProductCardGaleria.jsx";



const GaleriaHombre = (props) => {
    const { store, actions } = useContext(Context);

    return (
        <>
            <div class=" d-flex justify-content-between p-4 ">
                <div class="container">
                    <div class="d-flex flex-row align-items-center ">
                        {
                            store.men.map((item, index) => {
                                return (

                                    <ProductCardGaleria key={item.id} item={item} />
                                )
                            })
                        }
                    </div>

                </div>
            </div>


        </>
    )
}

export default GaleriaHombre


            {/* <div className='d-flex justify-content-center align-items-center '>
                {
                    store.products.map((item, index) => {
                        return (
                            <Card key={item.id} imagen={item.imagen[0]} tituloProducto={item.nombre} precio={item.precio} />
                        )
                    })
                }
            </div> */}


