import React from 'react'

const SlideCards = () => {
  return (
// cada cara del slide seria un componente con una cantidad x de cards para web serian 4 cards ver material ui https://mui.com/material-ui/react-stepper/#text-with-carousel-effect
    <>
      <div id="carouselExample" class="carousel m-2 cards-slide">
        <div class="carousel-inner  ">

          <div class="carousel-item active cards">
            <div className='d-flex cards'>

              <div className='d-flex  col mx-1'>
                <img src="https://images.pexels.com/photos/2860991/pexels-photo-2860991.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" class="cards d-block w-100" alt="..." />
                <div className="carousel-caption d-none d-md-block">
                  <p>Some representative placeholder content for the first slide.</p>
                </div>
              </div>
              <div className=' col mx-1'>
                <img src="https://images.pexels.com/photos/1926769/pexels-photo-1926769.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" class="d-block w-100" alt="..." />
              </div>
              <div className=' col mx-1'>
                <img src="https://images.pexels.com/photos/2916814/pexels-photo-2916814.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" class="d-block w-100" alt="..." />
              </div>

            </div>
          </div>
          <div class="carousel-item">
            <img src="https://images.pexels.com/photos/2860991/pexels-photo-2860991.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" class="d-block w-100" alt="..." />
            <img src="https://images.pexels.com/photos/1926769/pexels-photo-1926769.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" class="d-block w-100" alt="..." />
            <img src="https://images.pexels.com/photos/2916814/pexels-photo-2916814.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" class="d-block w-100" alt="..." />

          </div>
          <div class="carousel-item">
            <img src="https://images.pexels.com/photos/2860991/pexels-photo-2860991.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" class="d-block w-100" alt="..." />
            <img src="https://images.pexels.com/photos/1926769/pexels-photo-1926769.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" class="d-block w-100" alt="..." />
            <img src="https://images.pexels.com/photos/2916814/pexels-photo-2916814.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" class="d-block w-100" alt="..." />

          </div>

        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
    </>
  )
}

export default SlideCards