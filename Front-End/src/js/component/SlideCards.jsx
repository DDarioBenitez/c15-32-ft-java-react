import React, { useContext } from 'react';
import 'react-multi-carousel/lib/styles.css';
import '../../styles/productSlide.css';
import { Context } from '../store/appContext';
// import Carousel from 'react-multi-carousel';
import Carousel from 'react-multi-carousel';

// import '../../../styles/productSlide.css';



const SlideCards = () => {
  const { store, actions } = useContext(Context);

console.log({products});
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
// cada cara del slide seria un componente con una cantidad x de cards para web serian 4 cards ver material ui https://mui.com/material-ui/react-stepper/#text-with-carousel-effect

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
            <h6 className='price'>{item.price}</h6> */}
            {/* <p>descripcion articulo..</p> */}
            <button>agregar al carrito</button>
        </div>

    );
})
}

</Carousel>

)
}

export default SlideCards