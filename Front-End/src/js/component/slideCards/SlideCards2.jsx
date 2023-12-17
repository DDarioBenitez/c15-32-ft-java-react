import React from 'react'
import Card from '../card.jsx'

const SlideCards2 = () => {
  return (
    // cada cara del slide seria un componente con una cantidad x de cards para web serian 4 cards ver material ui https://mui.com/material-ui/react-stepper/#text-with-carousel-effect
    // sacar 5 items de la api para mostrar en componente new o sino poner todas en una row con botones next prev en forma de flecha y el slide con css 
    <>
      <div id="carouselExampleAutoplaying" className="carousel slide col" data-bs-ride="carousel">
        <div className="carousel-inner">
          <div className="carousel-item active">
            <div className='d-flex justify-content-around'>
            <Card imagen="https://images.pexels.com/photos/833169/pexels-photo-833169.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100 " />
            <Card imagen="https://images.pexels.com/photos/1926769/pexels-photo-1926769.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100 " />
            <Card imagen="https://images.pexels.com/photos/833169/pexels-photo-833169.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100 " />
            <Card imagen="https://images.pexels.com/photos/833169/pexels-photo-833169.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100 " />
            <Card imagen="https://images.pexels.com/photos/1926769/pexels-photo-1926769.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100 " />
            <Card imagen="https://images.pexels.com/photos/1926769/pexels-photo-1926769.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100 " />

            </div>

            {/* <img src="https://images.pexels.com/photos/833169/pexels-photo-833169.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100" alt="..."/> */}
          </div>
          <div className="carousel-item">
            <img src="https://images.pexels.com/photos/833169/pexels-photo-833169.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100" alt="..." />
          </div>
          <div className="carousel-item">
            <img src="https://images.pexels.com/photos/833169/pexels-photo-833169.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100" alt="..." />
          </div>
        </div>
        <button className="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
          <span className="carousel-control-prev-icon" aria-hidden="true"></span>
          <span className="visually-hidden">Previous</span>
        </button>
        <button className="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
          <span className="carousel-control-next-icon" aria-hidden="true"></span>
          <span className="visually-hidden">Next</span>
        </button>
      </div>
    </>
  )
}

export default SlideCards2