import React from 'react'
import { CiUser } from 'react-icons/ci'
import { Link } from 'react-router-dom'
import { IoMdEye, IoMdEyeOff } from "react-icons/io";
import { HiOutlineUser } from 'react-icons/hi2';

const LoginModal = () => {
    const userId = '1'
    return (
        <>
            {/* usar font-weight: lighter*/}
            <div className="btn-group">
                <button type="button" className="btn dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                    <HiOutlineUser /> 
                </button>
                <ul className="dropdown-menu dropdown-menu-end">
                    {/* 
                    conectado ?
                    <Link to={"/perfil/" + userId} className="linkStyle">
                        <li>
                            <button className="dropdown-item" type="button">
                                MI CUENTA
                            </button>
                        </li>
                    </Link>
                    <li><button className="dropdown-item" type="button">SALIR</button></li> 
                    :
                    */}


                    <li className='dropdown-item'>
                        <h3 className="dropdown-item text-center fw-semibold mt-3" type="button">
                            LOG-IN
                        </h3>
                    </li>
                    <li className="dropdown-item text-end">
                        <form className=' dropdown-item form-logIn'>
                            <div className="col-auto">
                                <input type="email" className="form-control form-control-sm mb-3" id="colFormLabelSm" placeholder="EJEMPLO@MAIL.COM" />
                            </div>
                            <div className="col-auto">
                                {/* <label for="exampleInputPassword1" className="form-label">Password</label> */}
                                <div className='mb-4 bg-dark'>
                                    <input type="password" className="form-control form-control-sm " id="exampleInputPassword1" placeholder="INGRESE SU CONTRASEÑA" />
                                    {/* onclick activa desactiva estado ver contraseña si es false eyeoff true eye  */}
                                    <IoMdEye className='float-start' />
                                    <IoMdEyeOff className='float-start' />
                                </div>
                            </div>
                            <hr />
                            <div className='d-grid'>
                                <button type="submit" className="btn btn-dark btn-sm">ENTRAR</button>
                            </div>

                        </form>
                    </li>

                </ul>
            </div>
        </>
    )
}

export default LoginModal