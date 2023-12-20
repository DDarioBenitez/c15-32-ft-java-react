import React from 'react'
import { Link } from 'react-router-dom'


const SlidePrincipal = () => {
  return (
    <Carousel responsive={responsive}>


    {store.jewerly?.map((item, index) => {
        return (
            //*******poner link en titulo para enviar a coleccion sale. cambiar data a un archivo nuevo llamado sale.jsx con json de repo externo
            // <Card imagen={item.image} tituloProducto={item.title} precio={item.price} key={index} />
            <div className='card-slide'>
                {/* <img src="" alt="product-image" className="product--image" />         */}
                <img src={item.image} className=" product--image" alt="product image" />
                <div className='title-wrap'>
                <h6>{item.title}</h6>
                </div>
                <hr />
                <h6 className='price'>{item.price}</h6>
                {/* <p>descripcion articulo..</p> */}
                <button>agregar al carrito</button>
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

export default SlidePrincipal