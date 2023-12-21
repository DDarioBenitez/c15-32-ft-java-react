import React from 'react'
import Sidebar from '../js/component/sidebar'
function Autenticacion() {
  return (
    <div className='d-flex'>
    <Sidebar/>
    <div className='container'>

      <h5>Autenticacion</h5>
    <div class="row">
  <div class="col-sm-8">
    <div class="card">
      <div class="card-body">
 
 
      <div className='form-control'>
  <h5>Contraseña</h5>
  <input type="text" placeholder='Contraseña'/>
  <button type="button" class="btnl btn-lg ">Definir Contraseña</button>
  </div>

        
      </div>
    </div>
  </div>

  <div class="col-sm-8 p-3">
    <div class="card">
      <div class="card-body">
         
      <div className='form-control'>
  <h5>Control de sesiones</h5>
  <input type="text" placeholder='Sesiones'/>
  <button type="button" class="btnl btn-lg ">Ver sesiones</button>
  </div>
     
        
      </div>
    </div>
  </div>
</div>
        </div>
        </div>
  )
}

export default Autenticacion
