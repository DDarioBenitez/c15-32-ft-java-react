import React from 'react'

const Card = ({imagen}) => {
    return (
        <div className="card cards col-4 mx-1" style={{ width: '14rem', height: '450px' }}>
            <img src={imagen} className="card-img-top card-coleccion" alt="img-producto" />
            <div className="card-body">
                <h6 className="card-title fw-light">TITULO PRODUCTO</h6>
                <hr />
                <h6 className="card-text fw-light">
                    $ 
                </h6>
            </div>
            <div className="card-body">
                <a href="#" className="card-link">Card link</a>
                <a href="#" className="card-link">Another link</a>
            </div>
        </div>
        )
}

export default Card