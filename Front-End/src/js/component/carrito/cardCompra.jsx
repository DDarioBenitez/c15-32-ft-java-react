import React from 'react'
import { CiSquareMinus, CiSquarePlus } from 'react-icons/ci'
import { IoCloseOutline } from 'react-icons/io5'

const CardCompra = () => {
  return (
    <tr>
    <th scope="row">titulo producto</th>
    <td>$0000</td>
    <td>
        <CiSquareMinus className='carrito-icono' />
        {/* funcion para quitar productos del carrito con post */}
       <span className='mx-2'>1</span> 
        <CiSquarePlus className='carrito-icono' />
        {/* funcion para agregar productos al carrito con post */}
    </td>

    <td>$0000
    <span className='ms-4'><IoCloseOutline /></span>
    </td>
    {/* funcion para eliminar productos del carrito con post */}
</tr>
)
}

export default CardCompra