import React from 'react'
import { CiSquareMinus, CiSquarePlus } from 'react-icons/ci'
import { IoCloseOutline } from 'react-icons/io5'

const CardCompra = () => {
  const { store, actions } = useContext(Context);
  const carro = store.carrito.map()//item esto por cada producto en el 
  
  
  return (
    <tr>
      {/* //enviar id a getPreference */}
    <th scope="row">{carro.nombre}</th>
    <td>${carro.precio}</td>
    <td>
        <CiSquareMinus className='carrito-icono' />
        {/* funcion para quitar productos del carrito con post */}
       <span className='mx-2'>{carro.cantidad}</span> 
        <CiSquarePlus className='carrito-icono' />
        {/* funcion para agregar productos al carrito con post */}
    </td>

    <td>${carro.precio * carro.cantidad}
    {/* //setStore carrito con eso*/}
    <span className='ms-4'><IoCloseOutline /></span>
    </td>
    {/* funcion para eliminar productos del carrito con post */}
</tr>
)
}

export default CardCompra