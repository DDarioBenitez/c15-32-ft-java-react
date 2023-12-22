import React, { useContext } from "react";
import { Context } from "../../store/appContext.js";
import Card from "./card.jsx";



const GaleriaAccesorios = (props) => {
    const { store, actions } = useContext(Context);


    return (
        <>
            <div className='d-flex justify-content-center align-items-center '>
                {
                    store.jewelery.map((item, index) => {
                        return (
                            <Card key={item.id} imagen={item.image} tituloProducto={item.title} precio={item.price} />
                        )
                    })
                }
            </div>
        </>
    )
}

export default GaleriaAccesorios
