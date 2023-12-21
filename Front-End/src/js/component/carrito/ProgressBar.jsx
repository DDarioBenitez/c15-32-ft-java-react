import React from 'react'

const ProgressBar = () => {
  return (
    <div className='d-flex'>
    <div class="container-progress-cart d-flex"><div class="progress--bar-container"><div class="progress--bar-section cart-bar" data-url="#/cart"><a href="#/cart"><div class="progress-bar-description cart-bar activeLocationBar"><p class="stepNumber">1</p><p>Carrito</p></div></a></div><div class="progress--bar-section profile" data-url="#/profile"><a href="#/profile"><div class="progress-bar-description profile"><p class="stepNumber">2</p><p>Información</p></div></a></div><div class="progress--bar-section shipping" data-url="#/shipping"><a href="#/shipping"><div class="progress-bar-description shipping"><p class="stepNumber">3</p><p>Envío</p></div></a></div><div class="progress--bar-section payment" data-url="#/payment"><a href="#/payment"><div class="progress-bar-description payment"><p class="stepNumber">4</p><p>Pago</p></div></a></div></div></div>
    </div>
)
}

export default ProgressBar