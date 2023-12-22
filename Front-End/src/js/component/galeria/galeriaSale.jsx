import React, { useContext } from "react";
import { Context } from "../../store/appContext.js";
import Card from "./card.jsx";
import ProductCard from "../productsSlider/ProductCard.jsx";



const GaleriaSale = () => {
    const { store, actions } = useContext(Context);
//    console.log(store.props);

    return (
        <>
            <div class=" d-flex justify-content-between p-4 ">
                <div class="container">
                    <div class="d-flex flex-row align-items-center ">
                        {
                            store.sale?.map((item, index) => {
                                return (
                                    <div className="col-md-4 " >

                                    <ProductCard key={item.id} item={item} />
                                    </div>
                                )
                            })
                        }
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

export default GaleriaSale
