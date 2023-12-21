import React from 'react'
import Sidebar from '../js/component/sidebar'
function Tarjeta() {
  return (
    <div className='d-flex'>
    <Sidebar/>
    <div className='container'>

      <h5>Tarjetas de Credito</h5>
    <div class="row">
  <div class="col-sm-8">
    <div class="card">
      <div class="card-body">
 
 
      <div className='form-control'>
  <h5>Tarjeta asociada</h5>
  <input type="number" placeholder='Nro. de tarjeta'/>
  <button type="button" class="btnl btn-lg ">Asociar Tarjeta</button>
  </div>

        
      </div>
    </div>
  </div>

 
</div>
        </div>
        </div>
  )
}

export default Tarjeta