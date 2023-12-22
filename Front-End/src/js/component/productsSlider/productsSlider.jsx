import React, { useContext } from 'react';
import { Context } from '../../store/appContext';
import Carousel from 'react-multi-carousel';
import 'react-multi-carousel/lib/styles.css';
import '../../../styles/productSlide.css'

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


    


    return (
        <Carousel responsive={responsive}>


            {store.products?.map((item, index) => {
                return (
                    //*******poner link en titulo para enviar a coleccion sale. cambiar data a un archivo nuevo llamado sale.jsx con json de repo externo
                    // <Card imagen={item.image} tituloProducto={item.title} precio={item.price} key={index} />
                    <div key={index} className='card-slide'>
                        {/* <img src="" alt="product-image" className="product--image" />         */}
                        <img src={item.imagen[0]} className=" product--image" alt="product image" />
                        {/* <div className='title-wrap'>
                        <h6>{item.title}</h6>
                        </div>
                        <hr />
                        <h6 className='price'>{item.price}</h6>
                        <p>descripcion articulo..</p> */}
                        <button onClick={() => actions.addCarrito(item)}>agregar al carrito</button>
                    </div>

                );
            })
            }

            {/* <div>Item 2</div>
            <div>Item 3</div>
            <div>Item 4</div> */}
        </Carousel>


    )
}

export default ProductsSlider