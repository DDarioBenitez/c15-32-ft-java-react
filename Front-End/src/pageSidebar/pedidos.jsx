import React from 'react'
import Sidebar from '../js/component/sidebar'
function Pedidos() {
  return (
    <div className='d-flex'>
    <Sidebar/>
    <div className='container'>

      <h5>Pedidos</h5>
    <div class="row">
  <div class="col-sm-8">
    <div class="card">
      <div class="card-body">
 
 
      <div className='form-control'>
  <h5>Pedidos realizados</h5>
  <input type="number" placeholder='Pedidos'/>
  <button type="button" class="btnl btn-lg ">Agregar Pedido</button>
  </div>

        
      </div>
    </div>
  </div>

 
</div>
        </div>
        </div>
  )
}

export default Pedidos