import React, { useContext } from "react";
import { Context } from "../store/appContext";
import Card from "./card.jsx";



const GaleriaColeccion = () => {
    const { store, actions } = useContext(Context);
    // console.log(store.jewerly, 'nnn');
   


    return (
        <>
            <div className='d-flex justify-content-center align-items-center '>
            {
                    store.products.map((item, index)=>{
                      return(
                        <Card key={item.id} imagen={item.imagen[0]} tituloProducto={item.nombre} precio={item.precio}/>
                        )
                    })
                  }
            </div>

            {/* {
                "id": 5,
                "title": "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet",
                "price": 695,
                "description": "From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the ocean's pearl. Wear facing inward to be bestowed with love and abundance, or outward for protection.",
                "category": "jewelery",
                "image": "https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg",
                "rating": {
                    "rate": 4.6,
                    "count": 400
        } */}



        </>
    )
}

export default GaleriaColeccion
