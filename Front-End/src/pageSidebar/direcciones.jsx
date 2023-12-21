import React from 'react'
import Sidebar from '../js/component/sidebar'

 function Direcciones() {
  return (
    <div className='d-flex'>
    <Sidebar/>
    <div className='container'>

      <h5 >Direcciones</h5>
    <div class="row">
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
 
 <div className='form'>
  <h5>Pais</h5>
  <input type="text" placeholder='Argentina' />
  </div>

  <div className='form'>
    <h5>Region</h5>
  <input type="text" placeholder='Region'/>
  </div>

 <div className='form'>
  <h5>Comuna</h5>
  <input type="text" placeholder='Comuna'/>
  </div>

  <button type="button" class="btnl btn-lg ">Añadir seccion</button>
       
        

        
      </div>
    </div>
  </div>

</div>
        </div>
        </div>
  )
}
export default Direcciones
