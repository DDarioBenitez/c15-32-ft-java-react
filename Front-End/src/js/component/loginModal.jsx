import React from 'react'
import { CiUser } from 'react-icons/ci'
import { Link } from 'react-router-dom'

const LoginModal = () => {
const userId = '1'
    return (
        <>
            {/* usar font-weight: lighter*/}
            <div className="btn-group">
                <button type="button" className="btn dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                    <CiUser />
                </button>
                <ul className="dropdown-menu dropdown-menu-end">
                    <Link to={"/perfil/" + userId} className="linkStyle">
                        <li>
                            <button className="dropdown-item" type="button">
                                MI CUENTA
                            </button>
                        </li>
                    </Link>

                    <li><button className="dropdown-item" type="button">SALIR</button></li>
                </ul>
            </div>
        </>
    )
}

export default LoginModal