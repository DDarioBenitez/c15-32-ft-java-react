import React from 'react'
import Subtitulo from './subtitulo.jsx'
import { useParams } from 'react-router-dom'
import Sale from './Sale.jsx';
import GaleriaColeccion from './galeriaColeccion.jsx';



const ColeccionDinamica = () => {
  const {coleccion} = useParams();

console.log({coleccion});

  return (
    <div>
      <div className='d-flex justify-content-center pt-5'>
        <Subtitulo texto={'COLECCION + CATEGORIA'} />
      </div>

      <div className='d-flex justify-content-center align-items-center flex-column'>
        <GaleriaColeccion />
        {/* <Sale />
        <Sale /> */}
      </div>
      {/* filtrar por categoria tipo valor etc revisar si se incluye */}
    </div>
  )
}

export default ColeccionDinamica