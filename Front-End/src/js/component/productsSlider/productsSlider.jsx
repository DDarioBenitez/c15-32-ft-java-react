import React, { useContext } from 'react';
import { Context } from '../../store/appContext';
import Carousel from 'react-multi-carousel';
import 'react-multi-carousel/lib/styles.css';
import '../../../styles/productSlide.css'
import ProductCard from './ProductCard.jsx';

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



const ProductsSlider = () => {
    const { store, actions } = useContext(Context);

    console.log(store.carrito);
    const responsive = {
        superLargeDesktop: {
            // the naming can be any, depends on you.
            breakpoint: { max: 4000, min: 1280 },
            items: 5
        },
        desktop: {
            breakpoint: { max: 1280, min: 1024 },
            items: 3
        },
        tablet: {
            breakpoint: { max: 1024, min: 464 },
            items: 2
        },
        mobile: {
            breakpoint: { max: 464, min: 0 },
            items: 1
        }
    };

    const addCarrito = (item) => {
        const { nombre, precio, imagen } = item;
        // const newItem = {...item, cantidad: cantidad}
        setStore({ carrito: [...carrito, item] });
    };


    return (
        <Carousel responsive={responsive}>
            {store.products?.map((item, index) => {
                return (
                    //*******poner link en titulo para enviar a coleccion sale. cambiar data a un archivo nuevo llamado sale.jsx con json de repo externo
                    <ProductCard key={index} item={item}/>
                );
            })
            }
        </Carousel>


    )
}

export default ProductsSlider