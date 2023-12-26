import React from 'react'
import Subtitulo from '../landingPage/subtitulo.jsx'
import { useParams } from 'react-router-dom'
import GaleriaNew from './galeriaNew.jsx';
import GaleriaHombre from './galeriaHombre.jsx';
import GaleriaMujer from './galeriaMujer.jsx';
import GaleriaAccesorios from './galeriaAccesorios.jsx';
import GaleriaSale from './galeriaSale.jsx';



const ColeccionDinamica = () => {
  const { coleccion } = useParams();

  // console.log(coleccion, 'COLECCION');

  return (
    <div>
      <div className='d-flex justify-content-center container text-uppercase '>
        <Subtitulo texto={coleccion} />
      </div>
      <div className='d-flex justify-content-center align-items-center '>
        {
          coleccion === 'hombre' ? <GaleriaHombre nombre={'men'} /> :
            coleccion === 'mujer' ? <GaleriaMujer nombre={'woman'} /> :
              coleccion === 'accesorios' ? <GaleriaAccesorios nombre={'accesorios'} /> :
                coleccion === 'sale' ? <GaleriaSale nombre={'sale'} /> :
                  <GaleriaNew nombre={'new'} />
        }
      </div>
    </div>
  )
}

export default ColeccionDinamica