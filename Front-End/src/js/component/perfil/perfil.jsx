import React from 'react'
import { useParams } from 'react-router';
import { Link } from 'react-router-dom';
import Sidebar from '../sidebar';
const Perfil = () => {

  const { id } = useParams();
  // useEffect(() => {
  //     actions.getUserById(id)
  // },[])


  return (
    <div className='d-flex'>
    <Sidebar/>
    <div className='container'>

      <h5>Perfil</h5>
    <div class="row">
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
 
 <div className='form-control'>
  <h5>Nombre</h5>
  <label htmlFor="nombre"></label>
  </div>

  <div className='form-control'>
    <h5>Apellido</h5>
  <label htmlFor="apellido"></label>
  </div>

 <div className='form-control'>
  <h5>Email</h5>
  <label htmlFor="email"></label>
  </div>

  <div className='form-control'>
    <h5>Telefono</h5>
  <label htmlFor="telefon"></label>
  </div>

  <div className='form-control'>
    <h5>Direccion</h5>
  <label htmlFor="direccion"></label>
  </div>
       
        

        
      </div>
    </div>
  </div>
  <div class="col-sm-4">
    <div class="card">
      <div class="card-body">
        <h6>Boletin informativo</h6>
        <p>Quieres recibir boletines informativos promocionales</p>
         
        <div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1"/>
  <label class="form-check-label" for="defaultCheck1">
  Quiero recibir el boletín informativo con promociones.
  </label>
</div>
        
      </div>
    </div>
  </div>
</div>
        </div>
        </div>
  )
}

export default Perfil