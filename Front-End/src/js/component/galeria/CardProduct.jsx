import React, { useContext } from 'react'
import { CiHeart } from 'react-icons/ci'
import { Link } from 'react-router-dom'
import { Context } from '../../store/appContext';

const CardProduct = ({item}) => {
    const { store, actions } = useContext(Context);
    // const item = store.products.map((item)=> item)

    return (
        <div className="card card-slide " >
            <img src={item.imagen[0]} className="card-img-top img-card-slide " alt={item.nombre} />
            <div className="card-body">
                <h5 className="card-title">{item.nombre}</h5>
                <div className='d-flex justify-content-evenly algin-items-center cardProduct-links '>
                <CiHeart />
                <Link to={`DetalleProducto/:${item.nombre}/:${item.id}`} className="btn text-uppercase linkStyle pe-5">mas detalles</Link>
                </div>
            </div>
        </div>)
}

export default CardProduct