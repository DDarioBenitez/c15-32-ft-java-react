import React, { useContext } from "react";
import { Context } from "../../store/appContext.js";
import Card from "./card.jsx";



const GaleriaColeccion = () => {
    const { store, actions } = useContext(Context);
    console.log(store.jewerly, 'nnn');
    const numberfll = new Array(9)//array con numeros para mapear y crear galeria 4 cards por fila
    //caada row tiene que tener 4 cards, cada card col-4? sidebar para filtros? o offcanvas
    //responsive.
console.log(numberfll);
    return (
        <>
            <div className='d-flex justify-content-center align-items-center '>

                {/* <Card imagen={item.image} /> */}
                <div className="card col-4" style={{ width: '18rem', height: '400px' }}>
                    <img src={imagen} className="card-img-top card-coleccion" alt="img-producto" />
                    <div className="card-body">
                        <h5 className="card-title">Card title</h5>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    </div>
                    <div className="card-body">
                        <a href="#" className="card-link">Card link</a>
                        <a href="#" className="card-link">Another link</a>
                    </div>
                </div>

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
