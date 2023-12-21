import React, { useContext, useState } from 'react'
import { Context } from '../../store/appContext';
import { request } from "../../services/AxiosService";
import { Link, useNavigate } from 'react-router-dom'
import { IoMdEye, IoMdEyeOff } from "react-icons/io";
import { HiOutlineUser } from 'react-icons/hi2';

const LoginModal = () => {
    const { store, actions } = useContext(Context);
    const { token } = store

    const navigate = useNavigate();

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [formError, setFormError] = useState("");

    const userId = '1'//ver si usar id o email

    const onFormSubmit = e => {
        e.preventDefault();

        request("POST", `/login?email=${email}&password=${password}`, {}).then(() => {
            navigate("/");
        })
        .catch(() => {
            setFormError("Correo electrónico o contraseña incorrecta");
        });
    };


    return (
        <>
            {/* usar font-weight: lighter*/}
            <div className="btn-group">
                <button type="button" className="btn dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                    <HiOutlineUser />
                </button>
                <ul className="dropdown-menu dropdown-menu-end">
                    {
                        store.token ?
                            <>
                                <Link to={"/perfil/" + userId} className="linkStyle">
                                    <li>
                                        <button className="dropdown-item" type="button">
                                            MI CUENTA
                                        </button>
                                    </li>
                                </Link>
                                <li><button className="dropdown-item" type="button">SALIR</button></li>
                                {/* funcion de logout */}
                            </>
                            :
                            <>
                                <li className='dropdown-item'>
                                    <h3 className="dropdown-item text-center fw-semibold mt-3" type="button">
                                        LOG-IN
                                    </h3>
                                </li>
                                <li className="dropdown-item text-end">
                                    <p className="small text-danger">{formError}</p>

                                    <form onSubmit={onFormSubmit} noValidate className=' dropdown-item form-logIn'>
                                        <div className="col-auto">
                                            <input type="email"
                                                name="email"
                                                className="form-control form-control-sm mb-3"
                                                id="colFormLabelSm"
                                                placeholder="ejemplo@mail.com"
                                                onChange={e => setEmail(e.target.value)}
                                                required />
                                        </div>
                                        <div className="col-auto">
                                            <div className='mb-4 bg-dark'>
                                                <input type="password"
                                                    name="password"
                                                    className="form-control form-control-sm "
                                                    id="exampleInputPassword1"
                                                    placeholder="ingrese su contraseña"
                                                    onChange={e => setPassword(e.target.value)}
                                                    required />

                                            </div>
                                        </div>
                                        <hr />
                                        <div className='d-grid'>
                                            <button type="submit" className="btn btn-dark btn-sm  text-uppercase">Iniciar sesión</button>
                                        </div>
                                        <div className='d-grid place-items-center'>
                                            <p className="text-center mt-3">¿No tienes una cuenta?</p>
                                            <Link to={"/registro"} className="btn fw-normal btn-sm pt-0 mt-0">Regístrate aquí</Link>
                                        </div>
                                    </form>
                                </li>
                            </>
                    }
                </ul>
            </div>
        </>
    )
}

export default LoginModal