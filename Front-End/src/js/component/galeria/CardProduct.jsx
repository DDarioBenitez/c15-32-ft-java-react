import React, { useContext } from 'react'
import { CiHeart } from 'react-icons/ci'
import { Link } from 'react-router-dom'
import { Context } from '../../store/appContext';

const CardProduct = ({item}) => {
    const { store, actions } = useContext(Context);
    // const item = store.products.map((item)=> item)

    return (
        <div className="card" style="width: 18rem;">
            <img src={item.imagen[0]} className="card-img-top" alt="..." />
            <div className="card-body">
                <h5 className="card-title">{item.nombre}</h5>
                {/* <p className="card-text">talle </p> */}
                <select class="form-select card-text" aria-label="Default select example">
                    <option selected>talle</option>
                    <option value="1">{item.talle[0]}</option>
                    <option value="2">{item.talle[1]}</option>
                    <option value="3">{item.talle[2]}</option>
                </select>
                <select class="form-select card-text" aria-label="Default select example">
                    <option selected>talle</option>
                    <option value="1">{item.color[0]}</option>
                    <option value="2">{item.color[1]}</option>
                    <option value="3">{item.color[2]}</option>
                </select>
                <CiHeart />
                <Link to={`DetalleProducto/:${item.nombre}/:${item.id}`} className="btn text-uppercase linkStyle">mas detalles</Link>
            </div>
        </div>)
}

export default CardProduct