import React from 'react'
import { useParams } from 'react-router';
import { Link } from 'react-router-dom';

const Perfil = () => {

  const { id } = useParams();
  // useEffect(() => {
  //     actions.getUserById(id)
  // },[])


  return (
    < div className='perfilWrapper'>
      Mi cuenta
      <hr />
      <div>Información Personal
        <div >Nombre:
          <span className='px-5 '>nombre desde backend</span>
        </div>
        <div>Direccion:
          <span className='px-5 '>direccion desde backend</span>
        </div>
        <div>Favoritos
          <span className='px-5 '>favoritos desde backend</span>
        </div>
      </div>
      <hr />
      <div>Mis Pedidos
        <div>Pedidos Realizados: <span className='px-5 '>datos desde backend</span>
        </div>

      </div>
      <hr />
      <Link to="/" className="navbar-brand">
        <h5>SALIR</h5>
      </Link>
    </div>
  )
}

export default Perfil