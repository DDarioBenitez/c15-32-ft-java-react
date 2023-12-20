import React from 'react'
import { Link } from 'react-router-dom'


const SlidePrincipal = () => {
  return (
    <>
      <div id="carouselExampleCaptions" className="carousel slide ">
        <div className="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" className="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div className="carousel-inner">
          <div className="carousel-item active ">
            {/* <div className="test">COLECCION HOMBRE</div> */}
            <Link to="/hombre" className="">
              <div className="test linkStyle-slidePrincipal test2">
                <h5 className='mt-5 text-light text-shadow '>COLECCION HOMBRE</h5>
                <div>SHOP</div>
              </div>
              <img src="https://images.pexels.com/photos/1835660/pexels-photo-1835660.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100" alt="" />
              <div className="carousel-caption d-none d-md-block">
              </div>
            </Link>
          </div>
          <div className="carousel-item">
            <Link to="/mujer" className="">
              <div className="test linkStyle-slidePrincipal test2">
                <h5 className='mt-5 text-light'>COLECCION MUJER</h5>
                <div>SHOP</div>
              </div>
              <img src="https://images.pexels.com/photos/2816479/pexels-photo-2816479.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100" alt="" />
              <div className="carousel-caption d-none d-md-block">
                {/* <h5>COLECCION MUJER</h5> */}
                {/* <p>Some representative placeholder content for the second slide.</p> */}
              </div>
            </Link>
          </div>
          <div className="carousel-item">
            <Link to="/sale" className="">
              <div className="sale  linkStyle-slidePrincipal ">
                <h5 className='mt-5 text-light text-shadow sale-slidePrincipal'>SHOP</h5>
              </div>
              <img src="https://images.pexels.com/photos/3806753/pexels-photo-3806753.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100" alt="" />
              <div className="carousel-caption d-none d-md-block">
                {/* <h5>SALE</h5> */}
                {/* <p>Some representative placeholder content for the second slide.</p> */}
              </div>
            </Link>
          </div>
        </div>
        <button className="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
          <span className="carousel-control-prev-icon" aria-hidden="true"></span>
          <span className="visually-hidden">Previous</span>
        </button>
        <button className="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
          <span className="carousel-control-next-icon" aria-hidden="true"></span>
          <span className="visually-hidden">Next</span>
        </button>
      </div>
    </>
  )
}

export default SlidePrincipal