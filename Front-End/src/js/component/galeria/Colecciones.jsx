import React from 'react'
import { Link } from 'react-router-dom'

const Colecciones = () => {
  return (
    <>
      <div className='colecciones d-flex px-1'>
        <Link to="/mujer" className="linkStyle colection col ">
          <div className="">
            <span>COLECCION MUJER</span>
            <img src="https://images.pexels.com/photos/2884310/pexels-photo-2884310.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className=" w-100" alt="" />
          </div>

        </Link>


        <Link to="/hombre" className="linkStyle colection  col">
          <div className="">
            <span>COLECCION HOMBRE</span>
            <img src="https://images.pexels.com/photos/2460488/pexels-photo-2460488.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100" alt="" />
          </div>
        </Link>

        <Link to="/accesorios" className="linkStyle colection col">
          <div className="">
            <span>ACCESORIOS</span>
            <img src="https://images.pexels.com/photos/4155246/pexels-photo-4155246.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" className="d-block w-100" alt="" />
          </div>
        </Link>

      </div>
    </>
  )
}

export default Colecciones