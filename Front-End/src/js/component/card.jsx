import React from 'react'

const Card = ({imagen, tituloProducto, precio  }) => {
    return (
        <div className="card cards col-4 mx-1" style={{ width: '14rem', height: '450px' }}>
            <img src={imagen} className="card-img-top card-coleccion" alt="img-producto" />
            <div className="card-body">
                <h6 className="card-title fw-light mt-2">{tituloProducto}</h6>
                <hr />
                <h6 className="card-text fw-light">
                    $ {precio}
                </h6>
            </div>
            <div className="card-body">
                <a href="#" className="card-link">favoritos</a>
                <a href="#" className="card-link">agregar al carrito</a>
            </div>
        </div>
        )
}

export default Card