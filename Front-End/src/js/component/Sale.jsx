import React, { useContext } from 'react'
import Card from './card.jsx'
import { Context } from '../store/appContext.js';

const Sale = () => {
//imagen es un array de imagenes usar la [0]
const { store, actions } = useContext(Context);


  return (
    
        <>
          <div id="carouselExample" className="carousel mx-2 my-5 cards-slide">
            <div className="carousel-inner  ">
    
              <div className="carousel-item active cards">
                <div className='d-flex '>
                  {
                    store.products.map((item, index)=>{
                      return(
                        <Card key={item.id} imagen={item.imagen[0]} tituloProducto={item.nombre} precio={item.precio}/>
                        )
                    })
                  }

                  {/* <div className='d-flex  col mx-1'>
                    <img src="https://images.pexels.com/photos/833169/pexels-photo-833169.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="cards d-block w-100" alt="..." />
                    <div className="carousel-caption d-none d-md-block">
                      <p>Some representative placeholder content for the first slide.</p>
                    </div>
                  </div>
                  <div className=' col mx-1'>
                    <img src="https://images.pexels.com/photos/1926769/pexels-photo-1926769.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100" alt="..." />
                  </div>
                  <div className=' col mx-1'>
                    <img src="https://images.pexels.com/photos/2916814/pexels-photo-2916814.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100" alt="..." />
                  </div>
                  <div className=' col mx-1'>
                    <img src="https://images.pexels.com/photos/3769148/pexels-photo-3769148.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100" alt="..." />
                  </div> */}
    
                </div>
              </div>
              <div className="carousel-item">
                <img src="https://images.pexels.com/photos/2860991/pexels-photo-2860991.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100" alt="..." />
                <img src="https://images.pexels.com/photos/1926769/pexels-photo-1926769.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100" alt="..." />
                <img src="https://images.pexels.com/photos/2916814/pexels-photo-2916814.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100" alt="..." />
    
              </div>
              <div className="carousel-item">
                <img src="https://images.pexels.com/photos/2860991/pexels-photo-2860991.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100" alt="..." />
                <img src="https://images.pexels.com/photos/1926769/pexels-photo-1926769.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100" alt="..." />
                <img src="https://images.pexels.com/photos/2916814/pexels-photo-2916814.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100" alt="..." />
    
              </div>
    
            </div>
            <button className="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
              <span className="carousel-control-prev-icon" aria-hidden="true"></span>
              <span className="visually-hidden">Previous</span>
            </button>
            <button className="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
              <span className="carousel-control-next-icon" aria-hidden="true"></span>
              <span className="visually-hidden">Next</span>
            </button>
          </div>
        </>
       )
}

export default Sale