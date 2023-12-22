import React, { useContext } from 'react'
import { CiSquareMinus, CiSquarePlus } from 'react-icons/ci'
import { IoCloseOutline } from 'react-icons/io5'
import { Context } from '../../store/appContext';


const CardCompra = ({item}) => {
  const { store, actions } = useContext(Context);
  
  
  return (
    <tr>
      {/* //enviar id a getPreference */}
    <th scope="row">{item.nombre}</th>
    <td>${item.precio}</td>
    <td>
        <CiSquareMinus className='carrito-icono' />
        {/* funcion para quitar productos del carrito con post */}
       <span className='mx-2'>{item.cantidad}</span> 
        <CiSquarePlus className='carrito-icono' />
        {/* funcion para agregar productos al carrito con post */}
    </td>

    <td>${item.precio * item.cantidad}
    {/* //setStore carrito con eso*/}
    <span className='ms-4'><IoCloseOutline /></span>
    </td>
    {/* funcion para eliminar productos del carrito con post */}
</tr>
)
}

export default CardCompra