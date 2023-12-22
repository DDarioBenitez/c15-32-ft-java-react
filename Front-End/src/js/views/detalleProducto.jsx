import React, { useEffect } from 'react'
import { Link, useParams } from 'react-router-dom'
import { Context } from "../store/appContext";
import { useContext } from "react";

const DetalleProducto = (props) => {
    const { store, actions } = useContext(Context);
    const { id, nombre } = useParams();

    useEffect(() => {
        // console.log('se ejecuta useeffect', name);
        actions.getProductById(id, nombre)//byuid? byurl
        // actions.detailPeople(url)
    },[])

    return (
        <>

            {store.product?.nombre == nombre ?
                (
                    <p>producto</p>
                )
                // <div className='container background pt-3 mt-2 rounded'>
                //     <div className="d-flex justify-content-around mb-2 container background rounded">
                //         <div className='col-6'>
                //             <img src={props.image} alt="" className='img-fluid' />
                //         </div>
                //         <div className='col-6 px-3'>
                //             <span className='text-danger characterName d-flex text-start my-4'>{store?.planet?.name}</span>
                //             <p className='texto fs-4'> {store?.description}</p>
                //             <p className='texto fs-4'> {store?.loremDescription}</p>

                //         </div>
                //     </div>
                //     <div className='py-4 row border-top border-danger'>
                //         <div className="col-2 fontDetail text-center text-danger ">
                //             <span> Name: </span>
                //             <div>{store?.planet?.name}</div>
                //         </div>
                //         <div className="col-2 fontDetail text-center text-danger ">
                //             <span>Climate: </span>
                //             <div>{store?.planet?.climate}</div>
                //         </div>
                //         <div className="col-2 fontDetail text-center text-danger ">
                //             <span>Population: </span>
                //             <div>{store?.planet?.population}</div>
                //         </div>
                //         <div className="col-2 fontDetail text-center text-danger ">
                //             <span>Diameter: </span>
                //             <div>{store?.planet?.diameter}</div>
                //         </div>
                //         <div className="col-2 fontDetail text-center text-danger ">
                //             <span>Terrain: </span>
                //             <div>{store?.planet?.terrain}</div>
                //         </div>
                //         <div className="col-2 fontDetail text-center text-danger ">
                //             <span>Gravity: </span>
                //             <div>{store?.planet?.gravity}</div>
                //         </div>
                //     </div>
                // </div>)

                :
                (
                   <p>cargando</p> 
                )
            }

        </>
    )
}

export default DetalleProducto





