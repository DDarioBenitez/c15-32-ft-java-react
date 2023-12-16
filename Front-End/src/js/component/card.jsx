import React from 'react'

const Card = ({imagen}) => {
    return (
        <div className="card col-4" style={{ width: '18rem', height: '400px' }}>
            <img src={imagen} className="card-img-top card-coleccion" alt="img-producto" />
            <div className="card-body">
                <h5 className="card-title">Card title</h5>
                <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            </div>
            <div className="card-body">
                <a href="#" className="card-link">Card link</a>
                <a href="#" className="card-link">Another link</a>
            </div>
        </div>
        )
}

export default Card