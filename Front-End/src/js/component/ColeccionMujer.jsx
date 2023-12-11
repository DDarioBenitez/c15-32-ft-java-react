import React from 'react'
import Subtitulo from './subtitulo.jsx'
import { useParams } from 'react-router-dom'
import Sale from './Sale.jsx';



const ColeccionMujer = () => {
  const { categoria } = useParams();
console.log(categoria);
  return (
    <div>
      <div className='d-flex justify-content-center pt-5'>
        <Subtitulo texto={'COLECCION + CATEGORIA'} />
      </div>

      <div className='d-flex justify-content-center align-items-center flex-column'>
        <Sale />
        <Sale />
      </div>
      {/* filtrar por categoria tipo valor etc revisar si se incluye */}
    </div>
  )
}

export default ColeccionMujer