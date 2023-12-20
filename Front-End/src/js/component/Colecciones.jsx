import React from 'react'
import { Link } from 'react-router-dom'

const Colecciones = () => {
  return (
    <>
      <div className='d-flex ms-1'>

        <Link to="/mujer" className="linkStyle">
          <div className="colection col">
            <span>COLECCION MUJER</span>
            <img src="https://images.pexels.com/photos/18978813/pexels-photo-18978813/free-photo-of-young-redhead-in-sunglasses-sitting-at-the-table-outside-of-a-house.png?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100" alt="" />
          </div>
        </Link>

        <Link to="/hombre" className="linkStyle">
          <div className="colection  col">
            <span>COLECCION HOMBRE</span>
            <img src="https://images.pexels.com/photos/2460488/pexels-photo-2460488.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100" alt="" />
          </div>
        </Link>

        <Link to="/accesorios" className="linkStyle">
          <div className="colection col">
            <span>ACCESORIOS</span>
            <img src="https://images.pexels.com/photos/4155246/pexels-photo-4155246.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100" alt="" />
          </div>
        </Link>

      </div>
    </>
  )
}

export default Colecciones